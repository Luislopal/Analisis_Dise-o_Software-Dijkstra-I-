package es.upm.dit.adsw.ej1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
* Pruebas del algoritmo de Dijkstra.
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramirez Santana
* @version 17.02.2019
*/
public class GraphTest {
              
    private Graph graph;
    private Node N0;
    private Node N1;
    private Node N2;
    private Node N3;
    private Node N4;
    private Node N5;

    public GraphTest() {
              
        graph = new Graph();
        N0 = new Node("0", 0, 0);
        N1 = new Node("1", 0, 0);
        N2 = new Node("2", 0, 0);
        N3 = new Node("3", 0, 0);
        N4 = new Node("4", 0, 0);
        N5 = new Node("5", 0, 0);
        graph.addNode(N0);
        graph.addNode(N1);
        graph.addNode(N2);
        graph.addNode(N3);
        graph.addNode(N4);
        graph.addNode(N5);
        graph.addLink(new Link("0", "1", 1));
        graph.addLink(new Link("0", "5", 2));
        graph.addLink(new Link("1", "2", 3));
        graph.addLink(new Link("1", "3", 4));
        graph.addLink(new Link("1", "4", 5));
        graph.addLink(new Link("2", "0", 6));
        graph.addLink(new Link("3", "4", 7));
        graph.addLink2D("4", "2", 8);
    }

    @Test
    public void test00() {
        Set<Node> expected = new HashSet<>(Arrays.asList(N0, N1, N2, N3, N4, N5));
        Set<Node> actual = new HashSet<>(graph.getNodes());
        assertEquals(expected, actual);
    }

    @Test
    public void test01() {
        Link link01 = graph.getLink(N0, N1);
        Link link05 = graph.getLink(N0, N5);
        Link link12 = graph.getLink(N1, N2);
        Link link13 = graph.getLink(N1, N3);
        Link link14 = graph.getLink(N1, N4);
        Link link20 = graph.getLink(N2, N0);
        Link link34 = graph.getLink(N3, N4);
        Link link42 = graph.getLink(N4, N2);
        Link link24 = graph.getLink(N2, N4);

        Set<Link> expected = new HashSet<>(Arrays.asList(
                link01, link05, link12, link13, link14,
                link20, link34, link42, link24
        ));
        Set<Link> actual = new HashSet<>(graph.getLinks());
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        assertEquals(N0, graph.getNode("0"));
        assertEquals(N1, graph.getNode("1"));
        assertEquals(N2, graph.getNode("2"));
        assertEquals(N3, graph.getNode("3"));
        assertEquals(N4, graph.getNode("4"));
        assertEquals(N5, graph.getNode("5"));
    }

    @Test
    public void test2() {
        Link link01 = graph.getLink(N0, N1);
        assertEquals("0", link01.getSrc());
        assertEquals("1", link01.getDst());
        assertEquals(1, link01.getWeight());

        Link link10 = graph.getLink(N1, N0);
        assertNull(link10);

        Link link34 = graph.getLink(N3, N4);
        assertEquals("3", link34.getSrc());
        assertEquals("4", link34.getDst());
        assertEquals(7, link34.getWeight());
    }

    @Test
   public void test3() {
        Link link01 = graph.getLink(N0, N1);
        Link link05 = graph.getLink(N0, N5);
        Set<Link> expected0 = new HashSet<>(Arrays.asList(link01, link05));
        Set<Link> actual0 = new HashSet<>(graph.getLinks(N0));
        assertEquals(expected0, actual0);

        Link link34 = graph.getLink(N3, N4);
        List<Link> expected3 = Arrays.asList(link34);
        assertEquals(expected3, graph.getLinks(N3));
    }

    @Test
    public void test4() {
        assertEquals(-1, graph.getWeight(Arrays.asList()));
        assertEquals(0, graph.getWeight(Arrays.asList(N0)));
        assertEquals(1, graph.getWeight(Arrays.asList(N0, N1)));
        assertEquals(1 + 3, graph.getWeight(Arrays.asList(N0, N1, N2)));
        assertEquals(1 + 3 + 6, graph.getWeight(Arrays.asList(N0, N1, N2, N0)));
        assertEquals(-1, graph.getWeight(Arrays.asList(N0, N2, N3)));
    }

    @Test
    public void test5() {
        Link link24 = graph.getLink(N2, N4);
        assertEquals("2", link24.getSrc());
        assertEquals("4", link24.getDst());
        assertEquals(8, link24.getWeight());
        Link link42 = graph.getLink(N4, N2);
        assertEquals("4", link42.getSrc());
        assertEquals("2", link42.getDst());
        assertEquals(8, link42.getWeight());
        assertEquals(8 + 8, graph.getWeight(Arrays.asList(N2, N4, N2)));
    }
}
