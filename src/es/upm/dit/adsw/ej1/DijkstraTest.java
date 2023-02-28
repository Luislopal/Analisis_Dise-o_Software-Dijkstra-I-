package es.upm.dit.adsw.ej1;

import org.junit.Before;
import org.junit.Test;

import es.upm.dit.adsw.ej1.Dijkstra;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
* Pruebas del algoritmo de Dijkstra.
* @author Luis Alberto López Álvarez
* @author Carlos Daniel Ramirez Santana
* @version 17.02.2019
*/
public class DijkstraTest {
    private Graph graph;
    private Node A;
    private Node B;
    private Node C;
    private Node D;
    
    @Before
    public void setup() {
        graph = new Graph();
        A = new Node("a", 0, 0);
        B = new Node("b", 0, 0);
        C = new Node("c", 0, 0);
        D = new Node("d", 0, 0);
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addLink(new Link("a", "b", 1));
        graph.addLink(new Link("b", "a", 4));
        graph.addLink(new Link("a", "c", 2));
        graph.addLink(new Link("c", "a", 3));
        graph.addLink(new Link("b", "c", 2));
    }

    @Test
    public void test1() {
        Dijkstra dijkstra1 = new Dijkstra(graph, A);
        
        List<Node> pathAA = dijkstra1.getPath(A);
        List<Node> expectedAA = Arrays.asList(A);
        assertEquals(expectedAA,pathAA);
        assertEquals(0, graph.getWeight(pathAA));
              
        List<Node> pathAB = dijkstra1.getPath(B);
        List<Node> expectedAB = Arrays.asList(A,B);
        assertEquals(expectedAB,pathAB);
        assertEquals(1, graph.getWeight(pathAB));
        
        List<Node> pathAC = dijkstra1.getPath(C);
        List<Node> expectedAC = Arrays.asList(A, C);
        assertEquals(expectedAC,pathAC);
        assertEquals(2, graph.getWeight(pathAC));
        
        List<Node> pathAD = dijkstra1.getPath(D);
        assertNull(pathAD);
    }

    @Test
    public void test2() {
        Dijkstra dijkstra1 = new Dijkstra(graph, B);
        
        List<Node> pathBB = dijkstra1.getPath(B);
        List<Node> expectedBB = Arrays.asList(B);
        assertEquals(expectedBB,pathBB);
        assertEquals(0, graph.getWeight(pathBB));
        
        List<Node> pathBA = dijkstra1.getPath(A);
        List<Node> expectedBA = Arrays.asList(B,A);
        assertEquals(expectedBA,pathBA);
        assertEquals(4, graph.getWeight(pathBA));
        
        List<Node> pathBC = dijkstra1.getPath(C);
        List<Node> expectedBC = Arrays.asList(B,C);
        assertEquals(expectedBC,pathBC);
        assertEquals(2, graph.getWeight(pathBC));
        
        List<Node> pathBD = dijkstra1.getPath(D);
        assertNull(pathBD);
    }
    @Test
    public void test3() {
        Dijkstra dijkstra1 = new Dijkstra(graph, C);
        
        List<Node> pathCC = dijkstra1.getPath(C);
        List<Node> expectedCC = Arrays.asList(C);
        assertEquals(expectedCC,pathCC);
        assertEquals(0, graph.getWeight(pathCC));
        
        List<Node> pathCA = dijkstra1.getPath(A);
        List<Node> expectedCA = Arrays.asList(C, A);
        assertEquals(expectedCA,pathCA);
        assertEquals(3, graph.getWeight(pathCA));
        
        List<Node> pathCB = dijkstra1.getPath(B);
        List<Node> expectedCB = Arrays.asList(C,A,B);
        assertEquals(expectedCB,pathCB);
        assertEquals(4, graph.getWeight(pathCB));        
        
        List<Node> pathCD = dijkstra1.getPath(D);
        assertNull(pathCD);
    }
    @Test
    public void test4() {
        Dijkstra dijkstra1 = new Dijkstra(graph, D);
        List<Node> pathDA = dijkstra1.getPath(A);
        assertNull(pathDA);
        List<Node> pathDB = dijkstra1.getPath(B);
        assertNull(pathDB);
        List<Node> pathDC = dijkstra1.getPath(C);
        assertNull(pathDC);
        
        List<Node> pathDD = dijkstra1.getPath(D);
        List<Node> expectedDD = Arrays.asList(D);
        assertEquals(expectedDD,pathDD);
        assertEquals(0, graph.getWeight(pathDD));
        }
        
}
