package question_3;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	
	HashMap<String, Node> graphNodes;
	HashSet<Node> setOfNodes;
	
	// Constructors
	public Graph() {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
	}
	
	public Graph(final String value) {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
		
		Node nodeToAdd = new Node(value);
		
		graphNodes.put(value, nodeToAdd);
		setOfNodes.add(nodeToAdd);
	}
	
	public Graph(final String[] values) {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
		
		for (int i = 0; i < values.length; i++) {
			Node nodeToAdd = new Node(values[i]);
			graphNodes.put(values[i], nodeToAdd);
			setOfNodes.add(nodeToAdd);
		}
	}
	
	
	public void addNode(final String nodeVal) {
		Node nodeToAdd = new Node(nodeVal);
		
		graphNodes.put(nodeVal, nodeToAdd);
		setOfNodes.add(nodeToAdd);
	}
	
	
	// Edge adding/removing, may need to check that first and second exist in the graph already (or add them if they don't exist?)
	public void addUndirectedEdge(final Node first, final Node second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			first.setNeighbor(second);
			second.setNeighbor(first);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	public void removeUndirectedEdge(final Node first, final Node second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			first.removeNeighbor(second);
			second.removeNeighbor(first);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	public boolean undirectedEdgeExists(final Node first, final Node second) {
		return first.hasNeighbor(second) && second.hasNeighbor(first);
	}
	
	
	public HashSet<Node> getAllNodes() {
		return setOfNodes;
	}
	
	
	public Node getNode(String value) {
		return graphNodes.get(value);
	}
	
	
}
