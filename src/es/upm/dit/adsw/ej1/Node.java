package es.upm.dit.adsw.ej1;

/**
* CLASE Node crea los nodos en los que se basa el algoritmo de Dijkstra.
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramírez Santana
* @version 17.02.2019
*/
 public class Node {
     private String name;
     private int x,y;
     /**
     * Constructor
     * @param name
     * @param x
     * @param y
     * @throws IllegalArgumentException si el parámetro name de la clase String es nulo o el tamaño es 0.
     */
     public Node(String name, int x, int y) {
          if (name == null || name.length() == (0)) 
              throw new IllegalArgumentException();
          this.name = name;
          this.x = x;
          this.y = y;
          }
     /**
     * Método String
     * @return la estructura que se imprimirá por pantalla
     */
              
     @Override
     public String toString() {
          return "Node [name=" + name + ", x=" + x + ", y=" + y + "]";
     }
     /**
     * Getter
     * @return name
     */
     public String getName() {
           return name;
     }
     
      /**
      * Getter
      * @return x
      */
      public int getX() {
            return x;
      }
      
     /**
     * Getter
     * @return y
     */
     public int getY() {
            return y;
     }
}
