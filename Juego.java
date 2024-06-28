import java.util.*;
/**
 * Write a description of class Juego here.
 * 
 * @author KulilinWP
 * @version 0.1
 */
public class Juego
{
   private Mazo mazo;
   private Jugador jugador1;
   private Jugador jugador2;

   public Juego(Jugador jugador1, Jugador jugador2, Mazo mazo){
      if (jugador1 == null || jugador2 == null) throw new IllegalArgumentException("jugador invalido");
      if (mazo == null) throw new IllegalArgumentException("mazo invalido");
      this.jugador1 = jugador1;
      this.jugador2 = jugador2;
      this.mazo = mazo;
   }

   public void repartirCartas(){
      Random random = new Random();
      Mazo mazoRepartir = mazo.clonarMazo();
      while (mazoRepartir.obtenerTamañoLista() > 0) {
         int num = random.nextInt(mazoRepartir.obtenerTamañoLista());
         jugador1.agregarCarta(mazoRepartir.obtenerCarta(num));
         mazoRepartir.eliminarCarta(num);
         num = random.nextInt(mazoRepartir.obtenerTamañoLista());
         jugador2.agregarCarta(mazoRepartir.obtenerCarta(num));
         mazoRepartir.eliminarCarta(num);
      }
   }
   
   public void jugarRonda(){
    
    }
}
