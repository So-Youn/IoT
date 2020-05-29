//#define TRIGGER_PIN 10
//#define ECHO_PIN 9
//#include<LiquidCrystal_I2C.h>
//#include<Wire.h>
//LiquidCrystal_I2C lcd(0x27,16,2);
//long duration, cm;
//void setup()
//{
//  lcd.begin(16,2);
//  Serial.begin(9600);
//  pinMode(TRIGGER_PIN, OUTPUT); // 센서 Trig 핀, D12
//  pinMode(ECHO_PIN, INPUT); // 센서 Echo 핀, D13
//  lcd.display();
//  lcd.backlight();
//}
//void loop()
//{
//  digitalWrite(TRIGGER_PIN, HIGH); // 센서에 Trig신호 입력
//  //delayMicroseconds(10); // 10us 정도 유지
//  delay(10);
//  digitalWrite(TRIGGER_PIN,LOW); // Trig 신호 off
//  duration = pulseIn(ECHO_PIN,HIGH); // Echo pin이 HIGH를 유지한 시간을 저장
//  cm = microsecondsToCentimeters(duration); // 거리(cm)로 변환
//  Serial.print(cm);
//  Serial.println("cm");
//  Serial.flush();
//  delay(1000); // 0.3초 대기 후 다시 측정
//  // LCD 시작
//  lcd.setCursor(0,0);
//  lcd.print("Velocity 10km/h");
//  lcd.setCursor(0,1);
//  lcd.print("Distance ");
//  lcd.print("abc");
//  lcd.print("mm");
//  lcd.clear();
//  //LCD 끝
//}
//long microsecondsToCentimeters(long microseconds)
//{
//// 시간에 대한 값을 센티미터로 변환
//return microseconds / 29 / 2;
//}

//#include<Wire.h>
//void setup()
//{
//  Wire.begin();
//  Serial.begin(9600);
//  while(!Serial);
//  Serial.println("\nI2C Scanner");
//}
//void loop()
//{
//  byte error,address;
//  int nDevices;
//  Serial.println("Scanning...");
//  nDevices=0;
//  for(address=1;address<127;address++)
//  {
//    Wire.beginTransmission(address);
//    error = Wire.endTransmission();
//    if(error==0)
//    {
//      Serial.print("I2C device found at address0x");
//      if(address<16)
//      Serial.print("0");
//      Serial.print(address,HEX);
//      Serial.println(" !");
//      nDevices++;
//    }
//    else if (error==4)
//    {
//      Serial.print("Unknow error at address 0x");
//      if(address<16)
//      Serial.print("0");
//      Serial.println(address,HEX);
//    }
//  }
//  if(nDevices==0)
//  Serial.println("No I2C devices found\n");
//  else
//  Serial.println("done\n");
//  delay(5000);
//}

#include<LiquidCrystal_I2C.h>
#include<Wire.h>
LiquidCrystal_I2C lcd(0x27,16,2);
void setup(){
  lcd.display();
  lcd.backlight();
}
void loop(){
  lcd.setCursor(0,0);
  lcd.print("Velocity 30km/h");
  lcd.setCursor(0,1);
  lcd.print("Distance ");
  lcd.print("abc");
  lcd.print("cm");
  delay(1000);
  lcd.clear();
}
