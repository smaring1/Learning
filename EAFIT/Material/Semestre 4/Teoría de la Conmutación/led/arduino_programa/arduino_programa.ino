#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <Thread.h>
#include <ThreadController.h>

Thread hiloDHT = Thread();

#define LED 13
#define POT A0
int SWI = 16;
int value;
int pos;
const char* ssid     = "MarinGiraldo";
const char* password = "A1152472420";

WiFiServer servidorTCP(8266);
WiFiClient clienteTCP;



ThreadController controladorHilos = ThreadController(); //controlador de hilos


void leerPot() {
  value = analogRead(POT);
  pos = map(value, 0, 1023, 0, 100);
  int leer_switch = digitalRead(SWI);
  String datos = "potenciometro: ";
  datos += pos;
  datos += "\nswitch: ";
  datos += leer_switch;
  datos += '\n';

  clienteTCP.print(datos);
}

void setup() {

  pinMode(LED, OUTPUT);
  pinMode(POT, INPUT);
  pinMode(SWI, INPUT);

  Serial.begin(115200);
  delay(100);

  Serial.print("Conectandose a: ");
  Serial.println(ssid);


  WiFi.begin(ssid, password);  //Intentamos conectarnos a la red Wifi

  while (WiFi.status() != WL_CONNECTED) {  //Esperamos hasta que se conecte.
    delay(200);
  }

  Serial.print ("Conectado, IP: ");
  Serial.println (WiFi.localIP());

  servidorTCP.begin();

  hiloDHT.onRun(leerPot);
  hiloDHT.setInterval(1000);
}

void loop() {

  if (!clienteTCP.connected()) {
    // try to connect to a new client
    clienteTCP = servidorTCP.available();
    if (clienteTCP.connected()) {
      Serial.println("Cliente conectado");
      controladorHilos.add(&hiloDHT);
    }
  } else {
    // read data from the connected client
    if (clienteTCP.available() > 0) {
      char dato = clienteTCP.read();


      if (dato == '1') {
        digitalWrite(LED, HIGH);
        Serial.write(dato);
      }
      else if (dato == '0') {

        digitalWrite(LED, LOW);
        Serial.write(dato);

      }
    }
    controladorHilos.run();
  }





}
