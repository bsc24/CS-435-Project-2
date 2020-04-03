package question_5;

import java.util.HashMap;


public class Node {
	
	private String value;
	private boolean visited;
	private int inDegree;
	private HashMap<Node, Integer> neighbors;
	
	
	public Node(String input) {
		value = input;
		visited = false;
		neighbors = new HashMap<Node, Integer>();
		inDegree = 0;
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public HashMap<Node, Integer> getNeighbors() {
		return neighbors;
	}
	
	
	public boolean isVisited() {
		return visited;
	}
	
	
	public void setVisited() {
		visited = true;
	}
	
	
	public void setUnvisited() {
		visited = false;
	}
	
	
	public void setNeighbor(Node neighborNode, int weight) {
		if (!neighbors.containsKey(neighborNode)) {
			neighborNode.inDegree++;
		}
		neighbors.put(neighborNode, new Integer(weight));
	}
	
	
	public void removeNeighbor(Node neighborNode) {
		if (neighbors.containsKey(neighborNode)) {
			neighbors.remove(neighborNode);
			neighborNode.inDegree--;
		}
	}
	
	
	public boolean hasNeighbor(Node neighborNode) {
		return neighbors.containsKey(neighborNode);
	}
	
	
	public int getInDegree() {
		return inDegree;
	}
	
	
	@Override
	public String toString() {
		String retString = "Node: " + value;
		Node[] neighborsArray = new Node[neighbors.size()];
		neighbors.keySet().toArray(neighborsArray);
		
		for (int i = 0; i < neighborsArray.length; i++)
			if (i == 0)
				retString += "\nNeighbor(s): " + neighborsArray[i].getValue() + "," + neighbors.get(neighborsArray[i]);
			else
				retString += "; " + neighborsArray[i];
		
		return retString;
	}
}
