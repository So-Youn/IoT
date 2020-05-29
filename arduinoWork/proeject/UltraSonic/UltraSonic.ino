#define TRIGGER_PIN 10
#define ECHO_PIN 9
int Right_motor_ENB=5;   //우측모터 통제 -- PWD 
int Right_motor_back=7;     //우측모터전진(IN1)
int Right_motor_go=3;     //우측모터후진(IN2)
int Left_motor_go=4;    // 좌측모터 전진(IN3) 
int Left_motor_back=2;   //좌측모터 후진(IN4)
int Left_motor_ENA=6;   //좌측모터 통제 --PWD
long duration, cm;
int speed_left = 80;
int speed_right = 95;
int speed_sum = 0;  // speed_left + speed_right 할 아이
int speed_cal = 0;  //  speed_sum을 저장해놓을 아이

void setup()
{
  Serial.begin(9600);
  pinMode(TRIGGER_PIN, OUTPUT); // 센서 Trig 핀, D12
  pinMode(ECHO_PIN, INPUT); // 센서 Echo 핀, D13
  pinMode(Left_motor_go,OUTPUT); // IN1
  pinMode(Left_motor_back,OUTPUT); // IN2
  pinMode(Left_motor_ENA,OUTPUT);
  pinMode(Right_motor_go,OUTPUT);// IN3
  pinMode(Right_motor_back,OUTPUT);// IN4
  pinMode(Right_motor_ENB,OUTPUT);
}

void Ultrasonic(){
  digitalWrite(TRIGGER_PIN, HIGH); // 센서에 Trig신호 입력
  //delayMicroseconds(10); // 10us 정도 유지
  delay(10);
  digitalWrite(TRIGGER_PIN,LOW); // Trig 신호 off
  duration = pulseIn(ECHO_PIN,HIGH); // Echo pin이 HIGH를 유지한 시간을 저장
  cm = microsecondsToCentimeters(duration); // 거리(cm)로 변환
  Serial.print(cm);
  Serial.println("cm");
  Serial.flush();
  //delay(50); // 0.05초 대기 후 다시 측정
  }

long microsecondsToCentimeters(long microseconds)
{
// 시간에 대한 값을 센티미터로 변환
return microseconds / 29 / 2;
}

void motor(){
  digitalWrite(Left_motor_go,HIGH);
  digitalWrite(Left_motor_back,LOW);
  analogWrite(Left_motor_ENA,speed_left);
  digitalWrite(Right_motor_go,HIGH);
  digitalWrite(Right_motor_back,LOW);
  analogWrite(Right_motor_ENB,speed_right);
  }
void loop(){
  motor();
  speed_sum = speed_left + speed_right;
  speed_cal = speed_sum;
  Ultrasonic();
  while(cm < 50){
    speed_cal = speed_cal - 35;
    speed_left = speed_cal * 16/35;
    speed_right = speed_cal * 19/35;
    motor();
    Ultrasonic();
    if(cm >= 50){
      for(int i = speed_cal; i<= speed_sum; i = i + 35){
          speed_left = i * 16/35;
          speed_right = i * 19/35;
          motor();
          Ultrasonic();
      }
    }
  }
}
