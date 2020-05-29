/*회로 연결(한글은 LCD에 안뜸)
5v = VDD, A
GND = V0, VSS, RW, K
*/
                         
#include <LiquidCrystal.h>
LiquidCrystal lcd(23,12,21,13,22,11);//RS, E, D4, D5, D6, D7
void setup() {
  lcd.begin(16,2);
}

void loop() {
  lcd.setCursor(0,0);
  lcd.print("Velocity 30km/h");
  lcd.setCursor(0,1);
  lcd.print("Distance 10m");
  delay(1000);
  lcd.clear();
}
