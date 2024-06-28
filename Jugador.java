
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
   }
}
