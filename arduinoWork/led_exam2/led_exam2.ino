int pin[3] = {A0,A1,A2};
int pin_length = sizeof(pin)/sizeof(int);

void setup() {
  for(int i =0;i<pin_length;i++){
  pinMode(pin[i],OUTPUT);
  }
}

void loop() {
  for(int i=0;i<pin_length;i++){
    digitalWrite(pin[i],HIGH);
    delay(1000);
    digitalWrite(pin[i],LOW);
    delay(1000);
  }
}
