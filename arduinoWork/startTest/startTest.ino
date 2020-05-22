//모터 정의 시작
//지금 모터 2개만 제어하는 코드인 듯
int Left_motor_ENA=6;   //좌측모터 통제
int Left_motor_go=7;     //좌측모터전진(IN1)
int Left_motor_back=3;     //좌측모터후진(IN2)
int Right_motor_ENB=4;   //우측모터 통제
int Right_motor_go=2;    // 우측모터 전진(IN3)
int Right_motor_back=5;   //우측모터 후진(IN4)
int car_speed = 100;
void setup(){
  pinMode(Left_motor_go,OUTPUT); // IN1
  pinMode(Left_motor_back,OUTPUT); // IN2
  pinMode(Left_motor_ENA,OUTPUT);
  pinMode(Right_motor_go,OUTPUT);// IN3
  pinMode(Right_motor_back,OUTPUT);// IN4
  pinMode(Right_motor_ENB,OUTPUT);
}
//IN1,2,3,4 는 전압을 준다 VS 안준다 니까 digitalWrite
//ENA,B는 계속 전압을 가하는 거니까 analogWrite
void run()     // 전진
{
  digitalWrite(Left_motor_go,LOW);  // IN1
  digitalWrite(Left_motor_back,HIGH);     //IN2
  digitalWrite(Left_motor_ENA,car_speed);//ENA
  digitalWrite(Right_motor_go,LOW);//IN3
  digitalWrite(Right_motor_back,HIGH);  // IN4
  digitalWrite(Right_motor_ENB,car_speed); //ENB
}
void loop() {
    run();
}
