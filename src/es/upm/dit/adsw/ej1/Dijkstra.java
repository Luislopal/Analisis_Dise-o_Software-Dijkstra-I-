package es.upm.dit.adsw.ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.upm.dit.adsw.ej1.Graph;
import es.upm.dit.adsw.ej1.Node;
              
/**
 * CLASE DIJKSTRA hará el algoritmo de dijkstra
 * @author Luis Alberto López Álvarez
 * @author Carlos Daniel Ramírez Santana
 * @version 17.02.2019
 * FUENTE: Vogella (https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html)
 */
public class Dijkstra {
    private Graph graph;
    private Node src;
    private List<Link> links;
    private Set<Node> settledNodes;//crea un set de nodes que están comprobados
    private Set<Node> unSettledNodes;//crea un set de nodes que están no comprobados
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;
    /**
    * Constructor.calcula el camino mínimo a cada uno de los otros nodes en el grafo
    * @param graph Graph
    * @param src es el node origen
    */
    public Dijkstra(Graph graph, Node src) {
    	this.graph = graph;
    	this.src = src;
    	links = graph.getLinks();
    	settledNodes = new HashSet<Node>();
    	unSettledNodes = new HashSet<Node>();
    	predecessors = new HashMap<Node,Node>();
    	distance = new HashMap<Node,Integer>();
    	distance.put(this.src, 0);
    	unSettledNodes.add(this.src);
    	while (unSettledNodes.size() > 0) {
    		Node node = getMinimun(unSettledNodes);
    		settledNodes.add(node);
    		unSettledNodes.remove(node);
    		findMinimalDistances(node);
    	}
    }
    
    /**
    * consigue el camino más corto (el peso mínimo) 
    * @param dst Destination node
    * @return shortest path
    */
    public List<Node> getPath(Node dst) {
        List<Node> path = new ArrayList<Node>();
        if(dst.equals(this.src)) {
                path.add(src);
                return path;
          }
          Node step = dst;
          if(predecessors.get(step) == null) {
               return null;
          }
          path.add(step);
          while(predecessors.get(step) != null) {
               step = predecessors.get(step);
               path.add(step);
          }
          Collections.reverse(path);
          return path;
    }
    
    /**
    * @param node nodo cuyos vecinos se van a estudiar
    */
    private void findMinimalDistances(Node node) {
    List<Node> adjacentNodes = getNeighbors(node);
    for(Node target: adjacentNodes) {
        if(getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
            distance.put(target,  getShortestDistance(node) + getDistance(node, target));
            predecessors.put(target, node);
            unSettledNodes.add(target);
            }
    	}
    }
    
    /**
    * @param node nodo fuente
    * @param target nodo destino
    * @return int Integer.MAX_VALUE
    */
    private int getDistance(Node node, Node target) {
    	for(Link link: links) {
    		if(link.getSrc().equals(node.getName()) && link.getDst().equals(target.getName())) {
    			return link.getWeight();
    		}
    	}
    	return Integer.MAX_VALUE;
    }
    
    /**
    * @param node nodo fuente
    * @return List<Node> 
     */
    private List<Node> getNeighbors(Node node) {
            List<Node> neighbors = new ArrayList<Node>();
            for (Link link: links) {
              if (link.getSrc().equals(node.getName()) && !isSettled(graph.getNode(link.getDst()))) {
                 neighbors.add(graph.getNode(link.getDst()));
              }
            }
    return neighbors;
    }
    
    /**
    * @param nodes (Set)
    * @return Node nodo
    */
    private Node getMinimun(Set<Node> nodes) {
           Node minimun = null;
           for (Node node: nodes) {
              if (minimun == null) {
                 minimun = node;
               } 
              else {
                 if (getShortestDistance(node) < getShortestDistance(minimun)) {
                     minimun = node;
                 }
              }
           }
           return minimun;
    }
    
    /**
    * @param node nodo
    * @return settledNodes.contains(node)
    */
    private boolean isSettled(Node node) {
       return settledNodes.contains(node);
    }
    
    /**
    * @param destination
    * @return int (distancia)
    */
    private int getShortestDistance(Node destination) {
    	Integer d = distance.get(destination);
    	if (d == null) {
    		return Integer.MAX_VALUE;
            } else {
            	return d;
            }
    }
}

