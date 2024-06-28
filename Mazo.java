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

    public Mazo(int a){
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
    
    public Mazo(){
        cartas = new ArrayList();
    }
    
    public int obtenerTamañoLista(){
        return cartas.size();
    }
   
    public void agregarCarta(Carta carta){
        cartas.add(carta);
    }
    
    public Carta obtenerCarta(int num){
        return cartas.get(num);
    } 
    
    public void eliminarCarta(int num){
        cartas.remove(num);
    }

   public Mazo clonarMazo(){
      Mazo mazoClonado = new Mazo();
      for (int i = 0; i < cartas.length; i++){
         mazoClonado.agregarCarta(obtenerCarta(i));
      }
   }
}
