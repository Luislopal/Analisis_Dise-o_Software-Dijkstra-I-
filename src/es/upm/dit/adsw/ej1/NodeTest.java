package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
* Pruebas Node
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramirez Santana
* @version 17.02.2019
*/
public class NodeTest {

	@Test
	public void test00() {
		Node node =  new Node("A",0,0);
		assertEquals("A",node.getName());
		assertEquals(0,node.getX());
		assertEquals(0,node.getY());
	}
              
    @Test (expected = IllegalArgumentException.class)
    public void test01() {
        Node node = new Node ("", 0, 0);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test03() {
       Node node = new Node (null,0, 0);
    }
}
