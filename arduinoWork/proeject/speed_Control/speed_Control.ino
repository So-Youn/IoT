
int Right_motor_ENB=6;   //우측모터 통제 -- PWD 
int Right_motor_back=7;     //우측모터전진(IN1)
int Right_motor_go=3;     //우측모터후진(IN2)
int Left_motor_go=4;    // 좌측모터 전진(IN3) 
int Left_motor_back=2;   //좌측모터 후진(IN4)
int Left_motor_ENA=5;   //좌측모터 통제 --PWD
int speed_left = 105;
int speed_right = 80;

void setup(){
  Serial.begin(9600);
  pinMode(Left_motor_go,OUTPUT); // IN1
  pinMode(Left_motor_back,OUTPUT); // IN2
  pinMode(Left_motor_ENA,OUTPUT);
  pinMode(Right_motor_go,OUTPUT);// IN3
  pinMode(Right_motor_back,OUTPUT);// IN4
  pinMode(Right_motor_ENB,OUTPUT);
}

void speed_low(){
  digitalWrite(Left_motor_go,HIGH);  // IN1
  digitalWrite(Left_motor_back,LOW);     //IN2
  analogWrite(Left_motor_ENA,speed_left);//ENA
  digitalWrite(Right_motor_go,HIGH);//IN3
  digitalWrite(Right_motor_back,LOW);  // IN4
  analogWrite(Right_motor_ENB,speed_right); //ENB
  }

void speed_mid(){
  
  digitalWrite(Left_motor_go,HIGH);  // IN1
  digitalWrite(Left_motor_back,LOW);     //IN2
  analogWrite(Left_motor_ENA,160);//ENA
  digitalWrite(Right_motor_go,HIGH);//IN3
  digitalWrite(Right_motor_back,LOW);  // IN4
  analogWrite(Right_motor_ENB,160); //ENB
  }

  void speed_high(){
  digitalWrite(Left_motor_go,HIGH);  // IN1
  digitalWrite(Left_motor_back,LOW);     //IN2
  analogWrite(Left_motor_ENA,255);//ENA
  digitalWrite(Right_motor_go,HIGH);//IN3
  digitalWrite(Right_motor_back,LOW);  // IN4
  analogWrite(Right_motor_ENB,255); //ENB
    }

void speed_rise(){
  i = i + 3;
  Serial.println(i);
  digitalWrite(Left_motor_go,HIGH);  // IN1
  digitalWrite(Left_motor_back,LOW);     //IN2
  analogWrite(Left_motor_ENA,i);//ENA
  digitalWrite(Right_motor_go,HIGH);//IN3
  digitalWrite(Right_motor_back,LOW);  // IN4
  analogWrite(Right_motor_ENB,i); //ENB
}
  
void speed_fall(){
  j = j - 3;
  Serial.println(j);
  digitalWrite(Left_motor_go,HIGH);  // IN1
  digitalWrite(Left_motor_back,LOW);     //IN2
  analogWrite(Left_motor_ENA,i);//ENA
  digitalWrite(Right_motor_go,HIGH);//IN3
  digitalWrite(Right_motor_back,LOW);  // IN4
  analogWrite(Right_motor_ENB,i); //ENB
  }
    
 void stop(){
  analogWrite(Left_motor_ENA,0);
  analogWrite(Right_motor_ENB,0);
  }
void run()
{
  char msg = Serial.read();
  if(msg == '1'){
    speed_low();
   }else if(msg == '2'){
    speed_mid();
   }else if(msg == '3'){
    speed_high();
   }else if(msg == '4'){
    speed_rise();
   }else if(msg == '5'){
    speed_fall();
   }else if(msg == '0'){
    stop();
   }
  
}
void loop() {
    run();
}
