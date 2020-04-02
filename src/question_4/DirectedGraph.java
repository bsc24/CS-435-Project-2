package question_4;

import java.util.HashMap;
import java.util.HashSet;

public class DirectedGraph {

	HashMap<String, Node> graphNodes;
	HashSet<Node> setOfNodes;
	
	public DirectedGraph() {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
	}
	
	public DirectedGraph(final String value) {
		graphNodes = new HashMap<String, Node>();
		setOfNodes = new HashSet<Node>();
		
		Node nodeToAdd = new Node(value);
		
		graphNodes.put(value, nodeToAdd);
		setOfNodes.add(nodeToAdd);
	}
	
	public DirectedGraph(final String[] values) {
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
	
	
	public void addDirectedEdge(final Node first, final Node second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second) && !second.hasNeighbor(first)) {
			first.setNeighbor(second);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	
	public void removeDirectedEdge(final Node first, final Node second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			first.removeNeighbor(second);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	public boolean directedEdgeExists(final Node first, final Node second) {
		return first.hasNeighbor(second);
	}
	
	
	public HashSet<Node> getAllNodes() {
		return setOfNodes;
	}
	
	
	public Node getNode(String value) {
		return graphNodes.get(value);
	}
}
