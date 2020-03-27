package question_3;

import java.util.HashMap;

public class Node {
	
	private String value;
	private HashMap<String, Node> neighbors;
	
	
	public Node(String input) {
		value = input;
		neighbors = new HashMap<String, Node>();
	}

	
	public String getValue() {
		return value;
	}
	
	
	public HashMap<String, Node> getNeighbors() {
		return neighbors;
	}


	public boolean setNeighbor(Node neighborNode) {
		if (neighbors.size() < 4) {
			neighbors.put(neighborNode.getValue(), neighborNode);
			return true;
		}
		
		return false;
	}
	
	
	public void removeNeighbor(Node neighborNode) {
		neighbors.remove(neighborNode.getValue());
	}
	
	
	public boolean hasNeighbor(Node neighborNode) {
		return neighbors.containsValue(neighborNode);
	}
	
	
	public String toString() {
		String retString = "Node: " + value;
		String[] neighborsArray = new String[neighbors.size()];
		neighbors.keySet().toArray(neighborsArray);
		
		for (int i = 0; i < neighborsArray.length; i++)
			if (i == 0)
				retString += "\nNeighbors: " + neighborsArray[i];
			else
				retString += ", " + neighborsArray[i];
		
		return retString;
	}
}
