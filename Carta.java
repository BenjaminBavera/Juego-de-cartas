
/**
 * Write a description of class Cartas here.
 * 
 * @author KulilinWP
 * @version 0.1
 */
public class Carta
{
   private String nombre;
   private int poder;
   
   /**
   * Crea un objeto carta con el nombre y el poder indicado.
   * Precondicion: nombre no puede ser null, vacio o tener solo espacios en blanco y poder debe ser mayor que 0.
   * @param nombre: es el nombre de la carta.
   * @param poder: es el poder de la carta.
   */
   public Carta(String nombre, int poder){
       if (nombre == null || nombre.isBlank() || nombre.length() == 0) throw new IllegalArgumentException("nombre invalido");
       if (poder <= 0) throw new IllegalArgumentException("poder invalido");  
       this.nombre = nombre;
       this.poder = poder;
    }
   /**
   * Retorna el nombre de la carta.
   */
   public String obtenerNombre(){
       return nombre;  
   }

   /**
   * Retorna el poder de la carta.
   */
   public int obtenerPoder(){
       return poder;  
   }
}
