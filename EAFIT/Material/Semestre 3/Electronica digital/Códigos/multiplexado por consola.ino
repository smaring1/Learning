int numeros[][7] = {
  	{1,1,1,0,1,1,1},
  	{1,0,0,0,0,0,1},
    {0,1,1,1,0,1,1},
    {1,1,0,1,0,1,1},
    {1,0,0,1,1,0,1},
    {1,1,0,1,1,1,0},
    {1,1,1,1,1,1,0},
    {1,0,0,0,0,1,1},
    {1,1,1,1,1,1,1},
    {1,0,0,1,1,1,1},
    {0,0,0,1,0,0,0}
  };
bool decimal;
String medium;
void setup()
{
  medium = "";
  decimal = false;
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(A2, INPUT);
  pinMode(A3, OUTPUT);
  pinMode(A4, OUTPUT);
  pinMode(A5, OUTPUT);
  digitalWrite(13, LOW);
  digitalWrite(12, LOW);
}

void loop()
{
  //Temp sensor
  double sensorInput = analogRead(A2);
  double temp = ((double)(sensorInput*5*100)/1024) - 50;
  
  //Print number
  digitalWrite(12, LOW);
  String numero = String(temp);
  number(numero);
  
  color(255,1,1);
}

void digit(int n) {
  for(int i = 0; i < 8; i++) {
  	digitalWrite(i+3, numeros[n][i]);
  }
} 

void number (String valor){
  digitalWrite(2, 0);
  int first = 0;
  int second = 0;
  String f = "";
  String s= "";
  for (int i = 0; i < valor.length(); i++) {
  if (valor.substring(i, i+1) == ".") {
    f = valor.substring(0, i);
    s = valor.substring(i+1);
    break;
    }
  }
  if(f.length() > 1){
  	first = f.substring(0,1).toInt();
 	second = f.substring(1,2).toInt();
    decimal = false;
  }
  else if(s.toInt() == 0){
    first = 0;
    second = f.substring(0,1).toInt();
    decimal = false;
  }
  else {
    first = f.substring(0,1).toInt();
 	second = s.substring(0,1).toInt();
    decimal = true;
  }
  digitalWrite(13, HIGH);
  digitalWrite(12, LOW);
  if(decimal) digitalWrite(2, 1);
  digit(first);
  delay(15);
  digitalWrite(12, HIGH);
  digitalWrite(13, LOW);
  digitalWrite(2, 0);
  digit(second);
  delay(15);
}

void color(int r, int g, int b){
  analogWrite(A5, r);
  analogWrite(A4, b);
  analogWrite(A3, g);
}