import java.util.*;

/**
 * Write a description of class Jugadores here.
 * 
 * @author KulilinWP
 * @version 0.1
 */
public class Jugador
{
   private String nombre;
   private Mazo cartas;
   private int puntuacion;

   public Jugador(String nombre){
      this.nombre = nombre;
      puntuacion = 0;
      cartas = new Mazo();
   }
   
   public void agregarCarta(Carta carta){
       cartas.agregarCarta(carta); 
    }
    
   public int cantidadCartas(){
       return cartas.obtenerTamañoLista(); 
    } 
}
