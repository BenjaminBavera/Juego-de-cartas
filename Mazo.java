import java.util.*;
   
/**
 * Write a description of class Mazo here.
 * 
 * @author KulilinWP
 * @version 0.1
 */
public class Mazo
{
   private Carta[] cartas;

   public Mazo(){
      cartas = new Carta[10];
      cartas[0] = new Carta("CR7",99);
      cartas[1] = new Carta("Messi",99);
      cartas[2] = new Carta("Neymar",95);
      cartas[3] = new Carta("Kroos",90);
      cartas[4] = new Carta("Iniesta",94);
      cartas[5] = new Carta("Ramos",91);
      cartas[6] = new Carta("De Bruyne",90);
      cartas[7] = new Carta("Merentiel",75);
      cartas[8] = new Carta("Courtois",88);
      cartas[9] = new Carta("Modric",90);
   }
}
