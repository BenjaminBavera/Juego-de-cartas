import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Juego here.
 * 
 * @author KulilinWP
 * @version 0.1
 */
public class Juego
{
   private JFrame frame;
   private Mazo mazo;
   private Jugador jugador1;
   private Jugador jugador2;
   private int ronda;
   private final int rondasMaximas = 5;

   public Juego(String nombre1, String nombre2){
      if (nombre1 == null || nombre2 == null) throw new IllegalArgumentException("jugador invalido");
      this.jugador1 = new Jugador(nombre1);
      this.jugador2 = new Jugador(nombre2);
      crearMazo();
      makeFrame();
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
      
      private void crearMazo(){
         this.mazo = new Mazo();
         mazo.agregarCarta(new Carta("CR7",99));
         mazo.agregarCarta(new Carta("Messi",99));
         mazo.agregarCarta(new Carta("Neymar",95));
         mazo.agregarCarta(new Carta("Kroos",90));
         mazo.agregarCarta(new Carta("Iniesta",94));
         mazo.agregarCarta(new Carta("Ramos",91));
         mazo.agregarCarta(new Carta("De Bruyne",90));
         mazo.agregarCarta(new Carta("Merentiel",75));
         mazo.agregarCarta(new Carta("Courtois",88));
         mazo.agregarCarta(new Carta("Modric",90));
      }

      private void makeFrame(){
         frame = new JFrame();
         makeMenuBar(frame);

         Container contentPane = new Container();

         frame.pack();
         frame.setVisible(true);
      }

      private void makeMenuBar(JFrame frame){
         JMenuBar menubar = new JMenuBar();
         frame.setJMenuBar(menubar);

         JMenu gameMenu = new JMenu("Juego");
            JMenuItem repartirCartas = new JMenuItem("Repartir cartas");
            repartirCartas.addActionListener(e -> repartirCartas());
            gameMenu.add(repartirCartas);

            JMenuItem jugarRonda = new JMenuItem("Jugar ronda");
            jugarRonda.addActionListener(e -> jugarRonda(1, 1));
            gameMenu.add(jugarRonda);

            JMenuItem obtenerGanador = new JMenuItem("Obtener ganador");
            obtenerGanador.addActionListener(e -> obtenerGanador());
            gameMenu.add(obtenerGanador);

         menubar.add(gameMenu);   
      }
}
