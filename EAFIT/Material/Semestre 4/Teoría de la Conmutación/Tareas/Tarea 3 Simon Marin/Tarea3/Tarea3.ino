#include <Keypad.h>                      //Agrega la libreria del teclado
#include <LiquidCrystal.h>               //Agrega la libreria del LCD
LiquidCrystal lcd(48, 49, 45, 44, 43, 42); //Inicializa la libreria y Define los pines digitales para el LCD
const byte filas = 4;                    //define las 4 filas del teclado
const byte columnas = 3;                 //define las 3 columnas del teclado
char teclas[filas][columnas] =  {
  {'1', '2', '3'},
  {'4', '5', '6'},
  {'7', '8', '9'},
  {'*', '0', '#'}
};
int mw_max_value = 999;
int count = 0;
int start = 34;
int stopper = 35;
int up = 36;
int down = 37;
int myname = 33;
int led_start = 22;
int led_stopper = 23;
int led_up = 24;
int led_down = 25;
int led_myname = 26;
bool timer = false;

byte pinesfilas[filas] = {21, 20, 19, 18}; //defines los pines digitales de las cuatro fila
byte pinescolumnas[columnas] = {17, 16, 15}; //defines los pines digitales de las tres columnas
Keypad teclado = Keypad( makeKeymap(teclas), pinesfilas,  pinescolumnas, filas, columnas ); //lectura del teclado
int led = 22;          	        // led en el pin 22
int tiempo;                               //Define tiempo como entero
char k;                                    //Define k como caracter

void setup()                               //Configuracion de puertos
{
  pinMode(start, INPUT);
  pinMode(stopper, INPUT);
  pinMode(up, INPUT);
  pinMode(down, INPUT);
  pinMode(myname, INPUT);
  pinMode(led_start, OUTPUT);
  pinMode(led_stopper, OUTPUT);
  pinMode(led_up, OUTPUT);
  pinMode(led_down, OUTPUT);
  pinMode(led_myname, OUTPUT);
  pinMode(47, OUTPUT);
  digitalWrite(47, 0);
  lcd.begin(16, 2);                   //Define el LCD a utilizar que en este caso es de 16 filas y 2 columnas
  pinMode(led, OUTPUT);     	     // configura el led como salida
  digitalWrite(led, LOW); 		// desactiva el led

}

void detectButton() {
  if (digitalRead(start) == HIGH) {
    while (digitalRead(start) != LOW) {
      digitalWrite(led_start, HIGH);
    }
    digitalWrite(led_start, LOW);
    timer = true;
  }

  if (digitalRead(stopper) == HIGH) {
    while (digitalRead(stopper) != LOW) {
      digitalWrite(led_stopper, HIGH);
    }
    digitalWrite(led_stopper, LOW);
    timer = false;
  }

  if (digitalRead(up) == HIGH && !timer) {
    while (digitalRead(up) != LOW) {
      digitalWrite(led_up, HIGH);
    }
    digitalWrite(led_up, LOW);

    if (count < mw_max_value) {
      count++;
    }
  }

  if (digitalRead(down) == HIGH && !timer) {
    while (digitalRead(down) != LOW) {
      digitalWrite(led_down, HIGH);
    }
    digitalWrite(led_down, LOW);

    if (count > 0) {
      count--;
    }
  }

  if (digitalRead(myname) == HIGH) {
    while (digitalRead(myname) != LOW) {
      digitalWrite(led_myname, HIGH);
    }
    digitalWrite(led_myname, LOW);
    while (true) {
      lcd.setCursor(0, 0);
      lcd.print("  SIMON MARIN    ");
      lcd.setCursor(0, 1);
      lcd.print("    GIRALDO      ");
      if (digitalRead(myname) == HIGH) {
        while (digitalRead(myname) != LOW) {
          digitalWrite(led_myname, HIGH);
        }
        digitalWrite(led_myname, LOW);
        lcd.clear();
        lcd.setCursor(1, 0);
        lcd.print("INGRESE TIEMPO:");
        break;
      }
    }
  }
}

void loop()                                //Hacer por siempre
{
  lcd.clear();
  lcd.setCursor(1, 0);                     //Columna 1, fila 0 de la pantalla
  lcd.print("INGRESE TIEMPO:");             //Mostrar el mensaje "INGRESE TIEMPO"
  if (!timer) {
    char c = '\0';
    do {
      c = teclado.getKey();
      detectButton();
      lcd.setCursor(2, 1);                     //Columna 3, fila 1 de la pantalla
      lcd.print(count);                          //Mostrar el valor actual de val

    } while (c == '\0' && !timer);
    switch (c) {
      case '*':
        break;

      case '#':
        break;

      case '\0':
        break;

      default:
        count = (count * 10) + (c - 48);
        if (count > mw_max_value) {
          count = mw_max_value;
        }
        break;
    }
  } else {
    lcd.setCursor(1, 0);
    lcd.print("SEG. RESTANTES:");
    lcd.setCursor(2, 1);                     //Columna 6, fila 1 de la pantalla
    lcd.print("    SEGUNDOS");
    lcd.setCursor(2, 1);                     //Columna 3, fila 1 de la pantalla
    lcd.print(count);                          //Mostrar el valor actual de val
    long t_inicial = millis();
    long t_actual = millis();
    while (t_actual - t_inicial < 1000) {
      detectButton();
      t_actual = millis();
    }
    count--;
    if (count <= 0) {
      count = 0;
      timer = false;
    }
  }
}
