package question_4;

import java.util.HashMap;

// This node is *slightly* different from question_3.Node, it uses up a bit more memory because of storing inDegree but otherwise should be the same
public class Node {
	
	private String value;
	private boolean visited;
	private int inDegree;
	private HashMap<String, Node> neighbors;
	//private HashMap<String, Node> neighborsIn;
	
	
	public Node(String input) {
		value = input;
		visited = false;
		neighbors = new HashMap<String, Node>();
		inDegree = 0;
		//neighborsIn = new HashMap<String, Node>();
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public HashMap<String, Node> getNeighbors() {
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
	
	
	public void setNeighbor(Node neighborNode) {
		if (!neighbors.containsValue(neighborNode)) {
			neighborNode.inDegree++;
		}
		
		neighbors.put(neighborNode.getValue(), neighborNode);
	}
	
	
	public void removeNeighbor(Node neighborNode) {
		if (neighbors.containsValue(neighborNode)) {
			neighbors.remove(neighborNode.getValue());
			neighborNode.inDegree--;
		}
	}
	
	
	public boolean hasNeighbor(Node neighborNode) {
		return neighbors.containsValue(neighborNode);
	}
	
	
	public int getInDegree() {
		return inDegree;
	}
	
	
	@Override
	public String toString() {
		String retString = "Node: " + value;
		String[] neighborsArray = new String[neighbors.size()];
		neighbors.keySet().toArray(neighborsArray);
		
		for (int i = 0; i < neighborsArray.length; i++)
			if (i == 0)
				retString += "\nNeighbor(s): " + neighborsArray[i];
			else
				retString += ", " + neighborsArray[i];
		
		return retString;
	}
}
