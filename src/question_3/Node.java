package question_3;

import java.util.HashMap;

public class Node {
	
	private String value;
	private boolean visited;
	private HashMap<String, Node> neighbors;
	
	
	public Node(String input) {
		value = input;
		visited = false;
		neighbors = new HashMap<String, Node>();
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
		if (!neighbors.containsValue(neighborNode))
			neighbors.put(neighborNode.getValue(), neighborNode);
	}
	
	
	public void removeNeighbor(Node neighborNode) {
		neighbors.remove(neighborNode.getValue());
	}
	
	
	public boolean hasNeighbor(Node neighborNode) {
		return neighbors.containsValue(neighborNode);
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
