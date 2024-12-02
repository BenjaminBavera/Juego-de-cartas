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
    
    public ArrayList<Carta> obtenerCartas(){
        return cartas;
    }

   public Mazo clonarMazo(){
      Mazo mazoClonado = new Mazo();
      for (int i = 0; i < cartas.size(); i++){
         mazoClonado.agregarCarta(obtenerCarta(i));
      }
      return mazoClonado;
   }
}
