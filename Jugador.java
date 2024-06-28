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

   /**
    * Crea un jugador con el nombre indicado, puntuacion 0 y un mazo vacio.
    * Precondicion: nombre no puede ser nulo o vacio.
    * @param jugador: es el nombre del jugador.
    */
   public Jugador(String nombre){
        if (nombre == null || nombre.length() == 0 || nombre.isBlank()) throw new IllegalArgumentException("jugador invalido");
        this.nombre = nombre;
        puntuacion = 0;
        cartas = new Mazo();
   }
   
   public String obtenerNombre(){
       return nombre; 
    }
   public void agregarCarta(Carta carta){
       cartas.agregarCarta(carta); 
    }
   
   public void eliminarCarta(int num){
       cartas.eliminarCarta(num); 
    } 
    
   public Carta obtenerCarta(int num){
       return cartas.obtenerCarta(num); 
    } 
    
   public int cantidadCartas(){
       return cartas.obtenerTamañoLista(); 
    } 
    
   public int obtenerPuntuacion(){
       return puntuacion; 
    } 
    
    public void sumarPuntuacion(){
        puntuacion++;
    }
}
