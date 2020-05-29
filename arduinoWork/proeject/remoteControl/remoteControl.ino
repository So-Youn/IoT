//#include <SoftwareSerial.h>
//SoftwareSerial mySerial(0, 1);  // RX, TX(UNO)
int Left_motor_ENA=6;   //좌측모터 통제 -- PWD
int Left_motor_go=7;     //좌측모터전진(IN1)
int Left_motor_back=3;     //좌측모터후진(IN2)
int Right_motor_go=4;    // 우측모터 전진(IN3)
int Right_motor_back=2;   //우측모터 후진(IN4)
int Right_motor_ENB=5;   //우측모터 통제 --PWD
//Ultrasonic sensor
int Sonic_TRIG = 10;
int Sonic_ECHO = 9;
#define blinkLED 8 //충돌 경고
#define CAR_DIR_FW 0 //직진
#define CAR_DIR_BK 1 //후진
#define CAR_DIR_LT 2 //좌회전
#define CAR_DIR_RT 3 //우회전
#define CAR_DIR_ST 4 //정지
#define MAX_DISTANCE  200
#define CAR_SPEED_DEFAULT 150
//#define pin_InfraR    8      // Right Infrared sensor
//#define pin_InfraL    9      // Left Infrared sensor
int cmFront = 0;
int cmF_old = 0;
int cmF_avg = 0;
int InfraL = HIGH;
int InfraR = HIGH;
int InfraL_Old = HIGH;
int InfraR_Old = HIGH;
int obstacle_cnt = 0;
int obstacle_try = 0;
long duration, cm, avg_cm;
int g_carDirection = CAR_DIR_ST;
int g_carSpeed = 230;
int g_carSpeed_L;
int g_carSpeed_R;
void car_right(){
  digitalWrite(Left_motor_go,HIGH);
  digitalWrite(Left_motor_back,LOW);
  digitalWrite
  (Left_motor_ENA,g_carSpeed);
  digitalWrite(Right_motor_go,HIGH);
  digitalWrite(Right_motor_back,LOW);
  digitalWrite(Right_motor_ENB,g_carSpeed);
}
void car_left(){
  digitalWrite(Left_motor_go,LOW);
  digitalWrite(Left_motor_back,HIGH);
  digitalWrite(Left_motor_ENA,g_carSpeed);
  digitalWrite(Right_motor_go,LOW);
  digitalWrite(Right_motor_back,HIGH);
  digitalWrite(Right_motor_ENB,g_carSpeed);
}
void car_forward(){
  digitalWrite(Left_motor_go,LOW);
  digitalWrite(Left_motor_back,HIGH);
  digitalWrite(Left_motor_ENA,g_carSpeed);
  digitalWrite(Right_motor_go,HIGH);
  digitalWrite(Right_motor_back,LOW);
  digitalWrite(Right_motor_ENB,g_carSpeed);
}
void car_backward() {
  digitalWrite(Left_motor_go,HIGH);
  digitalWrite(Left_motor_back,LOW);
  digitalWrite(Left_motor_ENA,g_carSpeed);
  digitalWrite(Right_motor_go,LOW);
  digitalWrite(Right_motor_back,HIGH);
  digitalWrite(Right_motor_ENB,g_carSpeed);
}
void car_stop(){
  analogWrite(Left_motor_ENA,0);
  analogWrite(Right_motor_ENB,0);
}
void update_Car(){
  switch ( g_carDirection ) {
    case CAR_DIR_FW:
        car_forward();
        break;
    case CAR_DIR_BK:
        car_backward();
        break;
    case CAR_DIR_LT:
        car_left();
        break;
    case CAR_DIR_RT:
        car_right();
        break;
    case CAR_DIR_ST:
        car_stop();
        break;
    default :
        ;
  }
  return;
}
//Serial Protocol
class _CommProtocol
{
private:
  unsigned char protocolPool[28];
  int bufPoint;
public:
  _CommProtocol()
  {
  }
  void addPool(unsigned char cByte)
  {
    if (bufPoint < 28)
    {
      if (bufPoint == 0 and cByte != 0x0c)
        return;  // invalid code
      protocolPool[bufPoint++]=cByte;
      //Serial.print("bufPoint -> ");
      //Serial.println(bufPoint);
    }
  }
  void clearPool()
  {
    bufPoint = 0;
    memset(protocolPool, 0x00, 28);
    Serial.println("clearPool");
  }
  bool isValidPool()
  {
    if (bufPoint >= 28)
    {
      //Serial.print("protocol length : ");
      if (protocolPool[0] == 0x0c && protocolPool[14] == 0x0c)
      {
        //Serial.println(protocolPool.length());
        return true;
      }
      else
      {
        clearPool();
        Serial.println("isValidPool 28 OVER");
      }
    }
    return false;
  }
    unsigned char getMotorLValue()
  {
    unsigned char szProto[14];
    memcpy(szProto, protocolPool, 14);
    if (szProto[0] == 0x0C &&
      szProto[1] == 0x00 &&
      szProto[2] == 0x80 &&
      szProto[3] == 0x04 &&
      szProto[4] == 0x02)
    {
      unsigned char l = szProto[5];// -0x32;
      return l;
    }
    return 0x00;
  }
  unsigned char getMotorRValue()
  {
    unsigned char szProto[14];
    memcpy(szProto, &protocolPool[14], 14);
    if (szProto[0] == 0x0C &&
      szProto[1] == 0x00 &&
      szProto[2] == 0x80 &&
      szProto[3] == 0x04 &&
      szProto[4] == 0x01)
    {
      unsigned char l = szProto[5];// -0x32;
      return l;
    }
    return 0x00;
  }
}; //class
_CommProtocol SerialCommData;
void process_SerialCommModule()
{
  if (SerialCommData.isValidPool())
  {
    char motorLR[2];
    motorLR[0] = (char)SerialCommData.getMotorLValue();
    motorLR[1] = (char)SerialCommData.getMotorRValue();
    SerialCommData.clearPool();
    //
    Serial.print("Left [");
    Serial.print(motorLR[0],DEC);
    Serial.print("] Right [");
    Serial.print(motorLR[1],DEC);
    Serial.println("]");
    //
    char szCmdValue = '5';
    // set MOVE commands
    if (motorLR[0] == 0 && motorLR[1] == 0) {  // (0,0) stop
      szCmdValue = '5';
    }
    else
    {
      int nSpeed;
      nSpeed = max(abs(motorLR[0]), abs(motorLR[1]));
      // Set direction
      if (motorLR[0] > 0 && motorLR[1] > 0)   // (+,+) forward
      {
        szCmdValue = '2';
        g_carSpeed = 255.0f * ((float)nSpeed / 100.0f);
      }
      else if (motorLR[0] < 0 && motorLR[1] < 0)   // (-,-) backward
      {
        szCmdValue = '8';
        g_carSpeed = 255.0f * ((float)nSpeed / 100.0f);
      }
      else if (motorLR[0] < 0 && motorLR[1] > 0)   // (-,+) left turn
      {
        szCmdValue = '4';
        g_carSpeed = 255.0f * ((float)((float)nSpeed*1.66f) / 100.0f);
      }
      else if (motorLR[0] > 0 && motorLR[1] < 0)   // (+,-) right turn
      {
        szCmdValue = '6';
        g_carSpeed = 255.0f * ((float)((float)nSpeed*1.66f) / 100.0f);
      }
    }
    //
    Serial.print("speed ");
    Serial.print(g_carSpeed);
    Serial.print(" ");
    Serial.println(szCmdValue);
    //
    // Set the direction and speed with command
    controlByCommand(szCmdValue);
  }
}
void controlByCommand(char doCommand)
{
  switch ( doCommand ) {
    case '+' :    // speed up
      g_carSpeed += 20;
      g_carSpeed = min(g_carSpeed, 255);
      break;
    case '-' :    // speed down
      g_carSpeed -= 20;
      g_carSpeed = max(g_carSpeed, 75);
      break;
    case '2' :    // forward
      g_carDirection = CAR_DIR_FW;
      break;
    case '5' :    // stop
      g_carDirection = CAR_DIR_ST;
      break;
    case '8' :    // backward
      g_carDirection = CAR_DIR_BK;
      break;
    case '4' :    // left
      g_carDirection = CAR_DIR_LT;
      break;
    case '6' :    // right
      g_carDirection = CAR_DIR_RT;
      break;
    default  :
      ;
  }
  return;
}
void setup(){
  Serial.begin(9600);
  delay(100);
  Serial1.begin(9600);
  pinMode(Left_motor_go,OUTPUT); // IN1
  pinMode(Left_motor_back,OUTPUT); // IN2
  pinMode(Left_motor_ENA,OUTPUT);
  pinMode(Right_motor_go,OUTPUT);// IN3
  pinMode(Right_motor_back,OUTPUT);// IN4
  pinMode(Right_motor_ENB,OUTPUT);
  pinMode(blinkLED,OUTPUT);
  pinMode(Sonic_TRIG,OUTPUT);
  pinMode(Sonic_ECHO,INPUT);
  //pinMode(pin_InfraR,INPUT);
  //pinMode(pin_InfraL,INPUT);
  //
   Serial.print("DIRECTION Value");
   Serial.println(g_carDirection);
   Serial.print("Speed pwm value:");
   Serial.print(g_carSpeed);
   Serial.println("");
}
void loop(){
  if (Serial1.available()) {
    unsigned char cByte;
    cByte = Serial1.read();
    SerialCommData.addPool(cByte);
    process_SerialCommModule();
    update_Car();
  }
}
/*bool alert_Bump()
{
long duration, cm;
digitalWrite(Sonic_TRIG, HIGH); // 센서에 Trig 신호 입력
delayMicroseconds(10); // 10us 정도 유지
digitalWrite(Sonic_TRIG,LOW); // Trig 신호 off
duration = pulseIn(Sonic_ECHO,HIGH); // Echo pin: HIGH->Low 간격을 측정
cm = microsecondsToCentimeters(duration); // 거리(cm)로 변환
if (cm < 20)
{
Serial.print("cm -> ");
Serial.println(cm);
digitalWrite(blinkLED, HIGH);
return true;
}
else
digitalWrite(blinkLED, LOW);
return false;
}
long microsecondsToCentimeters(long microseconds)
{
return microseconds/29/2;
}*/
