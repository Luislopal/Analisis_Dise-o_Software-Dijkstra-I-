package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
* Pruebas del algoritmo de Dijkstra.
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramirez Santana
* @version 17.02.2019
*/
public class LinkTest {

              
	@Test
	public void test00() {
		Link link = new Link ("A", "B", 1);
        assertEquals ("A", link.getSrc());
        assertEquals ("B", link.getDst());
        assertEquals (1, link.getWeight());
    }
	
    @Test (expected = IllegalArgumentException.class)
    public void test01() {
       Link link = new Link ("A", "B", -9);
              }
    
    @Test (expected = IllegalArgumentException.class)
    public void test02() {
       Link link = new Link (null, "B", 1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test03() {
       Link link = new Link ("A", null, 1);
    }
}
