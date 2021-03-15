int wait_time = 50;

//Instrucciones
int LDA = 22;
int ADD	= 23;
int SUB = 24;
int MUL = 25;
int DIV = 26;
int CALL = 27;
int GOTO = 28;
int RETURN = 29;
int ADICIONAL = 30;
int OPC1 = 31;
int OPC2 = 32;
int OUT = 33;
int HLT	= 34;

//Pines del SAP
int LM = 47;
int ER = 46;
int LI = 45;
int EI = 44;
int LA = 43;
int EA = 42;
int ALU_ADD = 41;
int ALU_SUB = 40;
int ALU_MUL = 39;
int ALU_DIV = 38;
int EU = 37;
int LB = 36;
int LO = 35;

int EP = 53;
int ERR_DIV0 = 7;

/* El bus se maneja con el puerto F */

int PC = 0;
int PC_stored = 0;

void setup() {
    DDRA = B00000000; // Del pin 29 al pin 22
    DDRC = B00000111; // Del pin 30 al pin 37
    DDRL = B11111100; // Del pin 42 al pin 49
    DDRF = B00001111; // Del pin A7 al pin A0. El bus
    pinMode(ALU_ADD, OUTPUT);
    pinMode(ALU_SUB, OUTPUT);
    pinMode(ALU_MUL, OUTPUT);
    pinMode(ALU_DIV, OUTPUT);
    pinMode(EP, OUTPUT);
    pinMode(ERR_DIV0, OUTPUT);
    
    PC = 0;
    PC_stored = 0;
    Serial.begin(9600);
}

void loop() {
    PORTF = PC; //Se envia el PC por el bus
    
    digitalWrite(EP, 1);
    digitalWrite(LM, 1);
    delay(wait_time);
    digitalWrite(LM, 0);
    digitalWrite(EP, 0);
    
    digitalWrite(ER, 1);
    digitalWrite(LI, 1);
    delay(wait_time);
    digitalWrite(LI, 0);
    digitalWrite(ER, 0);
    
    if(digitalRead(LDA) == HIGH) {
      digitalWrite(EI, 1);
      digitalWrite(LM, 1);
      delay(wait_time);
      digitalWrite(LM, 0);
      digitalWrite(EI, 0);
      
      digitalWrite(ER, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(ER, 0);
      PC++;
    }

    else if(digitalRead(ADD) == HIGH) {
      digitalWrite(EI, 1);
      digitalWrite(LM, 1);
      delay(wait_time);
      digitalWrite(LM, 0);
      digitalWrite(EI, 0);
      
      digitalWrite(ER, 1);
      digitalWrite(LB, 1);
      delay(wait_time);
      digitalWrite(LB, 0);
      digitalWrite(ER, 0);
      
      digitalWrite(ALU_ADD, 1);
      digitalWrite(EU, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EU, 0);
      digitalWrite(ALU_ADD, 0);
      PC++;
    }

    else if(digitalRead(SUB) == HIGH) {
      digitalWrite(EI, 1);
      digitalWrite(LM, 1);
      delay(wait_time);
      digitalWrite(LM, 0);
      digitalWrite(EI, 0);
      
      digitalWrite(ER, 1);
      digitalWrite(LB, 1);
      delay(wait_time);
      digitalWrite(LB, 0);
      digitalWrite(ER, 0);
      
      digitalWrite(ALU_SUB, 1);
      digitalWrite(EU, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EU, 0);
      digitalWrite(ALU_SUB, 0);
      PC++;
    }

    else if(digitalRead(MUL) == HIGH) {
      digitalWrite(EI, 1);
      digitalWrite(LM, 1);
      delay(wait_time);
      digitalWrite(LM, 0);
      digitalWrite(EI, 0);
      
      digitalWrite(ER, 1);
      digitalWrite(LB, 1);
      delay(wait_time);
      digitalWrite(LB, 0);
      digitalWrite(ER, 0);
      
      digitalWrite(ALU_MUL, 1);
      digitalWrite(EU, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EU, 0);
      digitalWrite(ALU_MUL, 0);
      PC++;
    }

    else if(digitalRead(DIV) == HIGH) {
      digitalWrite(EI, 1);
      digitalWrite(LM, 1);
      delay(wait_time);
      digitalWrite(LM, 0);
      digitalWrite(EI, 0);
 
      //Control division por cero
      digitalWrite(ER, 1);
      int num = PINF >> 4;
      delay(wait_time);
      digitalWrite(ER, 0);
      if (num == 0) {
        digitalWrite(ERR_DIV0, 1);
        while(true);
      }
      
      digitalWrite(ER, 1);
      digitalWrite(LB, 1);
      delay(wait_time);
      digitalWrite(LB, 0);
      digitalWrite(ER, 0);
      
      digitalWrite(ALU_DIV, 1);
      digitalWrite(EU, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EU, 0);
      digitalWrite(ALU_DIV, 0);
      PC++;
    }

    else if(digitalRead(CALL) == HIGH) {
      PC_stored = PC + 1;
      digitalWrite(EI, 1);
      PC = PINF >> 4;       // Cambia los bits para que se lea el número como es
      delay(wait_time);
      digitalWrite(EI, 0);
    }

    else if(digitalRead(RETURN) == HIGH) {
      PC = PC_stored;
    }

    else if(digitalRead(GOTO) == HIGH) {
      digitalWrite(EI, 1);
      PC = PINF >> 4;
      delay(wait_time);
      digitalWrite(EI, 0);
    }

    //ADC. Se resta uno al acumulador y se mira si el valor es cero. En ese caso, la siguiente instrucción no se ejecuta
    else if(digitalRead(ADICIONAL) == HIGH) {
      PORTF = 1;    //Envia un 1 por el bus
      digitalWrite(EP, 1);
      digitalWrite(LB, 1);
      delay(wait_time);
      digitalWrite(LB, 0);
      digitalWrite(EP, 0);
      
      digitalWrite(ALU_SUB, 1);
      digitalWrite(EU, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EU, 0);
      digitalWrite(ALU_SUB, 0);
      
      digitalWrite(EA, 1);
      int accumulator = PINF >> 4;
      delay(wait_time);
      digitalWrite(EA, 0);
      if(accumulator == 0) PC++;
      PC++;
    }
    
    //Si el número del acumulador es par, se carga un 1 en el acumulador; 0 en caso contrario
    else if(digitalRead(OPC1) == HIGH) {
      digitalWrite(EA, 1);
      int accumulator = PINF >> 4;
      delay(wait_time);
      digitalWrite(EA, 0);

      if (accumulator % 2 == 0) {
        PORTF = 1;
      } else {
        PORTF = 0;
      }
      
      digitalWrite(EP, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EP, 0);
      
      PC++;
    }

    /* Si el valor del acumulador es mayor que 5,
     * se le resta la mitad de este valor.
     * En caso contrario, se le resta 1.
     */
    else if(digitalRead(OPC2) == HIGH) {
      digitalWrite(EA, 1);
      int accumulator = PINF >> 4;
      delay(wait_time);
      digitalWrite(EA, 0);

      if(accumulator > 5) {
        PORTF = 2;
        digitalWrite(EP, 1);
        digitalWrite(LB, 1);
        delay(wait_time);
        digitalWrite(LB, 0);
        digitalWrite(EP, 0);
        
        digitalWrite(ALU_DIV, 1);
        digitalWrite(EU, 1);
        digitalWrite(LB, 1);
        delay(wait_time);
        digitalWrite(LB, 0);
        digitalWrite(EU, 0);
        digitalWrite(ALU_DIV, 0);
      } else {
        //Esto
        PORTF = 1;
        digitalWrite(EP, 1);
        digitalWrite(LB, 1);
        delay(wait_time);
        digitalWrite(LB, 0);
        digitalWrite(EP, 0);
      }
      
      digitalWrite(ALU_SUB, 1);
      digitalWrite(EU, 1);
      digitalWrite(LA, 1);
      delay(wait_time);
      digitalWrite(LA, 0);
      digitalWrite(EU, 0);
      digitalWrite(ALU_SUB, 0);
      
      PC++;
    }
    
    else if(digitalRead(OUT) == HIGH) {
      digitalWrite(EA, 1);
      digitalWrite(LO, 1);
      delay(wait_time);
      digitalWrite(LO, 0);
      digitalWrite(EA, 0);
      PC++;
    }

    else if(digitalRead(HLT) == HIGH) {
      while(true); //Detiene todo
    }
}
