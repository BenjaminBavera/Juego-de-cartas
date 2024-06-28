import java.util.*;
   
/**
 * Write a description of class Mazo here.
 * 
 * @author KulilinWP
 * @version 0.1
 */
public class Mazo
{
   private ArrayList<Carta> cartas;

   public Mazo(){
      cartas = new ArrayList();
      cartas.add(new Carta("CR7",99));
      cartas.add(new Carta("Messi",99));
      cartas.add(new Carta("Neymar",95));
      cartas.add(new Carta("Kroos",90));
      cartas.add(new Carta("Iniesta",94));
      cartas.add(new Carta("Ramos",91));
      cartas.add(new Carta("De Bruyne",90));
      cartas.add(new Carta("Merentiel",75));
      cartas.add(new Carta("Courtois",88));
      cartas.add(new Carta("Modric",90));
   }
}
