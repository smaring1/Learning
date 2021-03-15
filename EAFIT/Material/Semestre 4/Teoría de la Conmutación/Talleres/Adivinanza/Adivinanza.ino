int uno = 13;
int dos = 12;
int tres = 11;
int cuatro = 10;
int cinco = 9;

int a = 2;
int b = 3;
int c = 4;
int d = 5;
int e = 6;
int f = 7;
int g = 8;

int a_ = 15;
int b_ = 16;
int c_ = 17;
int d_ = 18;
int e_ = 19;
int f_ = 20;
int g_ = 21;


unsigned int contador;

int eleccion = 0;

int random_ = -1;

void setup() {

  pinMode(uno, INPUT);
  pinMode(dos, INPUT);
  pinMode(tres, INPUT);
  pinMode(cuatro, INPUT);
  pinMode(cinco, INPUT);

  pinMode(a, OUTPUT);
  pinMode(b, OUTPUT);
  pinMode(c, OUTPUT);
  pinMode(d, OUTPUT);
  pinMode(e, OUTPUT);
  pinMode(f, OUTPUT);
  pinMode(g, OUTPUT);

  pinMode(a_, OUTPUT);
  pinMode(b_, OUTPUT);
  pinMode(c_, OUTPUT);
  pinMode(d_, OUTPUT);
  pinMode(e_, OUTPUT);
  pinMode(f_, OUTPUT);
  pinMode(g_, OUTPUT);
  contador = 0;
  Serial.begin(9600);
}

void loop() {

  muestra_(contador);


  if (digitalRead(uno) == 1) {
    while(digitalRead(uno) != 0);
    random_ = random(1, 6);
    eleccion = 1;
    muestra(random_);
    if (random_ == eleccion) {
      contador++;
    }

    else if (random_ != eleccion) {
      contador = 0;
    }
  }

  if (digitalRead(dos) == 1) {
    while(digitalRead(dos) != 0);
    random_ = random(1, 6);
    eleccion = 2;
    muestra(random_);
    if (random_ == eleccion) {
      contador++;
    }

    else if (random_ != eleccion) {
      contador = 0;
    }
  }

   if (digitalRead(tres) == 1) {
    while(digitalRead(tres) != 0);
    random_ = random(1, 6);
    eleccion = 3;
    muestra(random_);
    if (random_ == eleccion) {
      contador++;
    }

    else if (random_ != eleccion) {
      contador = 0;
    }
  }

  if (digitalRead(cuatro) == 1) {
    while(digitalRead(cuatro) != 0);
    random_ = random(1, 6);
    eleccion = 4;
    muestra(random_);
    if (random_ == eleccion) {
      contador++;
    }

    else if (random_ != eleccion) {
      contador = 0;
    }
  }

  if (digitalRead(cinco) == 1) {
    while(digitalRead(cinco) != 0);
    random_ = random(1, 6);
    eleccion = 5;
    muestra(random_);
    if (random_ == eleccion) {
      contador++;
    }

    else if (random_ != eleccion) {
      contador = 0;
    }
  }

}

void escribirEnElDisplay(int va, int vb, int vc, int vd, int ve, int vf, int vg) {

  digitalWrite(a, va);
  digitalWrite(b, vb);
  digitalWrite(c, vc);
  digitalWrite(d, vd);
  digitalWrite(e, ve);
  digitalWrite(f, vf);
  digitalWrite(g, vg);

}

void escribirEnElDisplay_(int va, int vb, int vc, int vd, int ve, int vf, int vg) {

  digitalWrite(a_, va);
  digitalWrite(b_, vb);
  digitalWrite(c_, vc);
  digitalWrite(d_, vd);
  digitalWrite(e_, ve);
  digitalWrite(f_, vf);
  digitalWrite(g_, vg);

}

void muestra(int num) {

  switch (num) {


    case 1:
      escribirEnElDisplay(0, 1, 1, 0, 0, 0, 0);
      break;

    case 2:
      escribirEnElDisplay(1, 1, 0, 1, 1, 0, 1);
      break;

    case 3:
      escribirEnElDisplay(1, 1, 1, 1, 0, 0, 1);
      break;

    case 4:
      escribirEnElDisplay(0, 1, 1, 0, 0, 1, 1);
      break;

    case 5:
      escribirEnElDisplay(1, 0, 1, 1, 0, 1, 1);
      break;
  }
}

void muestra_(int num) {

  switch (num) {

    case 0:
      escribirEnElDisplay_(1, 1, 1, 1, 1, 1, 0);
      break;

    case 1:
      escribirEnElDisplay_(0, 1, 1, 0, 0, 0, 0);
      break;

    case 2:
      escribirEnElDisplay_(1, 1, 0, 1, 1, 0, 1);
      break;

    case 3:
      escribirEnElDisplay_(1, 1, 1, 1, 0, 0, 1);
      break;

    case 4:
      escribirEnElDisplay_(0, 1, 1, 0, 0, 1, 1);
      break;

    case 5:
      escribirEnElDisplay_(1, 0, 1, 1, 0, 1, 1);
      break;
  }
}
