int vr = 13;
int vy = 12;
int vg = 11;
int pr = 10;
int pg = 9;

int start_ = 7;
int stop_ = 8;
int peaton = 22;


int start__ = 0;

unsigned long tinicial = 0;

void setup() {

  pinMode(vr, OUTPUT);
  pinMode(vy, OUTPUT);
  pinMode(vg, OUTPUT);
  pinMode(pr, OUTPUT);
  pinMode(pg, OUTPUT);

  pinMode(start_, INPUT);
  pinMode(stop_, INPUT);
  pinMode(peaton, INPUT);

  digitalWrite(vr, 0);
  digitalWrite(vy, 0);
  digitalWrite(vg, 0);
  digitalWrite(pr, 0);
  digitalWrite(pg, 0);

  Serial.begin(9600);
}

void loop() {

  if (digitalRead(start_) == 1) {
    start__ = 1;
  }

  if (digitalRead(stop_) == 1) {
    start__ = 0;
  }

  if (start__ == 1 && digitalRead(peaton) == 0 && digitalRead(stop_) == 0) {

    digitalWrite(pr, 1);
    digitalWrite(vg, 1);
    tiempo(6000);
    digitalWrite(vg, 0);
    for (int i = 0; i < 10; i++) {
      digitalWrite(vg, 1);
      tiempo(125);
      digitalWrite(vg, 0);
      tiempo(125);
    }
    digitalWrite(vy, 1);
    tiempo(1000);
    digitalWrite(vy, 0);
    digitalWrite(vr, 1);
    digitalWrite(pr, 0);
    digitalWrite(pg, 1);
    tiempo(4500);
    for (int i = 0; i < 10; i++) {
      digitalWrite(pg, 1);
      tiempo(125);
      digitalWrite(pg, 0);
      tiempo(125);
    }
    digitalWrite(vr, 0);
  }



  if (start__ == 1 && digitalRead(peaton) == 1 && digitalRead(stop_) == 0) {


    digitalWrite(vg, 0);
    digitalWrite(vr, 0);
    for (int i = 0; i < 10; i++) {
      digitalWrite(vy, 1);
      tiempop(125);
      digitalWrite(vy, 0);
      tiempop(125);
    }
    digitalWrite(pr, 0);
    digitalWrite(pg, 1);
    digitalWrite(vr, 1);
    tiempop(2200);
    digitalWrite(vr, 0);
    for (int i = 0; i < 10; i++) {
      digitalWrite(vy, 1);
      tiempop(125);
      digitalWrite(vy, 0);
      tiempop(125);
    }
    digitalWrite(pg, 0);
    digitalWrite(vr, 0);
  }

}

void tiempo(int time_) {

  tinicial = millis();

  while ((millis() < (tinicial + time_)) && digitalRead(stop_) == 0 && digitalRead(peaton) == 0) {
  }
}

void tiempop(int time_) {

  tinicial = millis();

  while ((millis() < (tinicial + time_)) && digitalRead(stop_) == 0) {
  }
}
