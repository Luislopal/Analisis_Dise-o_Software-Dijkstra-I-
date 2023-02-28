package es.upm.dit.adsw.ej1;

/**
* CLASE Link
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramírez Santana
* @version 17.02.2019 
*/
public class Link {
    private String src,dst;
    private int weight;
    /**
    * Constructor
    * @param src  origen
    * @param dst  destino
    * @param weight  peso del camino
    * @throws IllegalArgumentException si src es nulo o dst es nulo o weight es negativo
    */

    public Link(String src, String dst, int weight) {
    	if (src == null || dst == null || weight<0)
    		throw new IllegalArgumentException();
    		this.src = src;
            this.dst = dst;
            this.weight = weight;
    }
    
    /**
    * Getter
    * @return src (String)
    */
    public String getSrc() {
    	return src;
    }
    
    /**
    * Getter
    * @return dst (String)
    */
    public String getDst() {
    	return dst;
    }
    
    /**
    * Getter
    * @return weight(número entero)
    */
    public int getWeight() {
    	return weight;
    }
    
    /**
    * Método String
    * @return la estructura que se imprimirá por pantalla
    */
    @Override
    public String toString() {
    	return "Link [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
    }
              
}
