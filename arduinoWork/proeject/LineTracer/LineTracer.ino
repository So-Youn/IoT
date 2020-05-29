//
// 자동차 진행 방향 정의
//
#define CAR_DIR_FW  0   // 전진.
#define CAR_DIR_BK  1   // 후진.  코드 안 만들었음
#define CAR_DIR_LF  2   // 좌회전.
#define CAR_DIR_RF  3   // 우회전
#define CAR_DIR_ST  4   // 정지.

// 
// 차량 운행 방향 상태 전역 변수. // 정지 상태.
int carDirection = CAR_DIR_ST; // 

//float g_carSpeed = 255.0f * ((float)((float)150*1.66f) / 100.0f);
// 주의:  ENA, ENB 는 PWM 지원 포트에 연결한다.
// 다음 업데이트시 변경합니다.
// ENA, ENB는 DC모터의 속도 조절 및 출발/정지에 사용하는 포트
#define Left_motor_ENA   6
#define Left_motor_go   4
#define Left_motor_back   2

#define Right_motor_ENB   5
#define Right_motor_go   3
#define Right_motor_back   7

void init_car_controller_board()
{
  pinMode(Left_motor_go,OUTPUT); // IN1
  pinMode(Left_motor_back,OUTPUT); // IN2
  pinMode(Left_motor_ENA,OUTPUT);
  pinMode(Right_motor_go,OUTPUT);// IN3
  pinMode(Right_motor_back,OUTPUT);// IN4
  pinMode(Right_motor_ENB,OUTPUT);
}


void car_forward()
{
  digitalWrite(Left_motor_go,HIGH);
  digitalWrite(Left_motor_back,LOW);
  analogWrite(Left_motor_ENA,112);
  digitalWrite(Right_motor_go,HIGH);
  digitalWrite(Right_motor_back,LOW);
  analogWrite(Right_motor_ENB,143);
}

//좌회전
void car_left()
{ 
  digitalWrite(Left_motor_go,HIGH);
  digitalWrite(Left_motor_back,LOW);
  analogWrite(Left_motor_ENA,255);
  digitalWrite(Right_motor_go,LOW);
  digitalWrite(Right_motor_back,HIGH);
  analogWrite(Right_motor_ENB,80);
}

//우회전
void car_right()
{
  digitalWrite(Left_motor_go,LOW);  // IN1
  digitalWrite(Left_motor_back,HIGH);     //IN2
  analogWrite(Left_motor_ENA,80);//ENA
  digitalWrite(Right_motor_go,HIGH);//IN3
  digitalWrite(Right_motor_back,LOW);  // IN4
  analogWrite(Right_motor_ENB,255); //ENB//ENB
}


//
//
void car_stop()
{ 
  analogWrite(Left_motor_ENA, 0);
  analogWrite(Right_motor_ENB, 0);
}

//
// 방향 전환값에 의해 차량 운행.
//
void car_update()
{
  if (carDirection == CAR_DIR_FW)  // 전진
  {
    car_forward();
  }
  else
  if (carDirection == CAR_DIR_LF) // 좌회전
  {
    car_left();
  }
  else
  if (carDirection == CAR_DIR_RF) // 우회전
  {
    car_right();
  }
  else
  if (carDirection == CAR_DIR_ST) // 정지.
  {
    car_stop();
  }
}

////
// 라인트레이서 모듈 핀맵
#define LT_MODULE_R A1   
#define LT_MODULE_L A2  

void init_line_tracer_modules()
{
  pinMode(LT_MODULE_L, INPUT);
  //pinMode(LT_MODULE_F, INPUT);
  pinMode(LT_MODULE_R, INPUT);
}

// is detected left
bool lt_isLeft()
{
  //A0를 digitalRead해서 1인지 0인지 읽고, 이게 1이면 true리턴, 0이면 false리턴.
  int ret = digitalRead(LT_MODULE_L);
  return ret == 1 ? true : false;

}

bool lt_isRight()
{
  int ret = digitalRead(LT_MODULE_R);
  return ret == 1 ? true : false;
}

// 
void lt_mode_update()
{
  //라인트레이서 센서 검정색이면 true를 리턴
  int ll = lt_isLeft();
  //int ff = lt_isForward();
  int rr = lt_isRight();

  if (ll&&rr)//센서 세개가 다 검정색 감지했을 때 정지
  {
    carDirection = CAR_DIR_ST;// stop
  }
  //carDirection = CAR_DIR_FW;
  //감지해야 하는 부분
  if (!ll&&!rr)//센서 세개가 흰색일 때 직진
  {
    carDirection = CAR_DIR_FW; 
  }
  else if (rr && !ll)//왼쪽 센서가 검정이면 우회전
  {
    carDirection = CAR_DIR_RF;
  }
  else if (ll && !rr)//오른쪽 센서가 검정이면 좌회전
  {
    carDirection = CAR_DIR_LF;
  }
}

void setup()
{
  //시리얼 초기화
  Serial.begin(9600);
  //핀 모드 셋팅
  init_car_controller_board();
}
void loop()
{
  lt_mode_update();
  car_update();
}
