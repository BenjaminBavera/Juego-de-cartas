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
   private int ronda;
   private final int rondasMaximas = 5;

   public Juego(Jugador jugador1, Jugador jugador2, Mazo mazo){
      if (jugador1 == null || jugador2 == null) throw new IllegalArgumentException("jugador invalido");
      if (mazo == null) throw new IllegalArgumentException("mazo invalido");
      this.jugador1 = jugador1;
      this.jugador2 = jugador2;
      this.mazo = mazo;
   }

   public void repartirCartas(){
      if (ronda > 0) throw new IllegalStateException("El juego ya comenzo, no se pueden volver a repartir las cartas");
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
   
   public String jugarRonda(int cartaJugador1, int cartaJugador2){
       if (ronda > rondasMaximas) throw new IllegalStateException("Se han jugado todas las rondas. Ya se puede obtener un ganador");
       String ganador ="empate";
       if (jugador1.obtenerCarta(cartaJugador1).obtenerPoder() > jugador2.obtenerCarta(cartaJugador2).obtenerPoder()){
          ganador = jugador1.obtenerNombre();
          jugador1.sumarPuntuacion();
        }       
       if (jugador2.obtenerCarta(cartaJugador2).obtenerPoder() > jugador1.obtenerCarta(cartaJugador1).obtenerPoder()){
          ganador = jugador2.obtenerNombre();
          jugador2.sumarPuntuacion();
        }
       System.out.println("Carta de "+jugador1.obtenerNombre()+": "+jugador1.obtenerCarta(cartaJugador1).obtenerNombre()+ " "+jugador1.obtenerCarta(cartaJugador1).obtenerPoder());
       System.out.println("VS");
       System.out.println("Carta de "+jugador2.obtenerNombre()+": "+jugador2.obtenerCarta(cartaJugador2).obtenerNombre()+ " "+jugador2.obtenerCarta(cartaJugador2).obtenerPoder());
       System.out.println("********************************");
       System.out.println("Ganador: " + ganador);
       jugador1.eliminarCarta(cartaJugador1); 
       jugador2.eliminarCarta(cartaJugador2);
       ronda++; 
        return ganador; 
    }
    
   public String obtenerGanador(){
       if (ronda < rondasMaximas) throw new IllegalStateException("Aun no se han jugado todas las rondas");
       String ganador = "empate";
       if (jugador1.obtenerPuntuacion() > jugador2.obtenerPuntuacion()){
           ganador = jugador1.obtenerNombre();     
        }
       if (jugador1.obtenerPuntuacion() < jugador2.obtenerPuntuacion()){
           ganador = jugador2.obtenerNombre();     
        } 
       return ganador; 
    } 
}
