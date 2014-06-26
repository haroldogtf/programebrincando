#include <Servo.h>

int START_DELAY = 10000;
int MOTOR_DELAY = 800;
int ACAO_DELAY  = 2000;

int DIRECAO_PARAFRENTE =  100;
int DIRECAO_PARATRAS   = -100;

int PIN_RODA1 = 9;
int PIN_RODA2 = 10;

int PIN_RED   = 3;
int PIN_GREEN = 5;
int PIN_BLUE  = 6;

Servo motor1;   
Servo motor2;   

int caneta;
int red    = 255;
int green  = 255;
int blue   = 255;

boolean executar = true;

void setup() {
    usarCaneta(true);
    delay(START_DELAY);
}

void loop() {
  if(executar) {
    //@ACAO@
    desativar();
  }
}

void ligarMotores() {
  motor1.attach(PIN_RODA1); 
  motor2.attach(PIN_RODA2); 
}

void desligarMotores() {
  motor1.detach();
  motor2.detach();
}

void mover(int direcao1, int direcao2, int tempo) {
  ligarMotores();
  motor1.write(direcao1);
  motor2.write(direcao2);
  delay(MOTOR_DELAY * tempo);
  desligarMotores();
  delay(ACAO_DELAY);
}

void desativar() {
  executar = false;
  desligarMotores();
  usarCaneta(false);
}

void paraFrente(int valor) {
  mover(DIRECAO_PARAFRENTE, DIRECAO_PARAFRENTE, valor);
}

void paraTras(int valor) {
  mover(DIRECAO_PARATRAS, DIRECAO_PARATRAS, valor);
}

void girarEsquerda(int valor) {
  mover(DIRECAO_PARATRAS, DIRECAO_PARAFRENTE, valor); 
}

void girarDireita(int valor) {
  mover(DIRECAO_PARAFRENTE, DIRECAO_PARATRAS, valor); 
}

void setCores(int r, int g, int b) {
  analogWrite(PIN_RED,   r);
  analogWrite(PIN_GREEN, g);
  analogWrite(PIN_BLUE,  b);
}

void usarCaneta(boolean valor) {
  caneta = valor;
  
  if(caneta) {
    setCores(red, green, blue);
  } else {
    setCores(0, 0, 0);
  }
}

void corCaneta(int r, int g, int b) {
  red   = r;
  green = g;
  blue  = b;
  
  if(caneta) {
    setCores(red, green, blue);
  }

}