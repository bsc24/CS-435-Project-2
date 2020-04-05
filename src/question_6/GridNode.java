package question_6;

import java.util.HashMap;
import java.util.HashSet;


public class GridNode {
	
	//private HashSet<GridNode> allGraphNodes;	// Could be made static, but then can't have different graphs at once
	private String value;
	private boolean visited;
	private int xCoord, yCoord;
	private GridNode[] neighbors;		// 0 = up, 1 = right, 2 = down, 3 = left
	
	
	public GridNode(final String input, final int xCoordinate, final int yCoordinate) {
		value = input;
		visited = false;
		neighbors = new GridNode[4];
		for (int i = 0; i < neighbors.length; i++)
			neighbors[i] = null;
		xCoord = xCoordinate;
		yCoord = yCoordinate;
		//allGraphNodes = graphNodes;
	}
	
	
	public String getValue() {
		return value;
	}
	
	/*
	public HashSet<GridNode> getAllGraphNodes() {
		return allGraphNodes;
	}
	*/
	
	
	public GridNode[] getNeighbors() {
		return neighbors;
	}
	
	
	public int getXCoordinate() {
		return xCoord;
	}
	
	
	public int getYCoordinate() {
		return yCoord;
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
	
	
	public int adjacentTo(GridNode neighborNode) {		// returns position of neighborNode relative to self (e.g. 0 = above)
		int xDiff = xCoord - neighborNode.getXCoordinate();
		int yDiff = yCoord - neighborNode.getYCoordinate();
		
		
		if (xDiff == 0) {
			if (yDiff == -1)
				return 0;
			else if (yDiff == 1)
				return 2;
		}
		
		if (yDiff == 0) {
			if (xDiff == -1)
				return 1;
			else if (xDiff == 1)
				return 3;
		}
		
		return -1;
	}
	
	
	public void setNeighbor(GridNode neighborNode) {
		int direction = this.adjacentTo(neighborNode);
		if (direction != -1)
			neighbors[direction] = neighborNode;
	}
	
	
	public void removeNeighbor(GridNode neighborNode) {
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] == neighborNode) {
				neighbors[i] = null;
				break;
			}
		}
	}
	
	
	public boolean hasNeighbor(GridNode neighborNode) {
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] == neighborNode)
				return true;
		}
		
		return false;
	}
	
	
	@Override
	public String toString() {
		String retString = "Node: " + value +
				"\nCoordinates: " + xCoord + "," + yCoord;
		retString += "\nNeighbor up: ";
		if (neighbors[0] == null)
			retString += "null";
		else
			retString += neighbors[0].getValue();
		
		retString += "\nNeighbor right: ";
		if (neighbors[1] == null)
			retString += "null";
		else
			retString += neighbors[1].getValue();
				
		retString += "\nNeighbor down: ";
		if (neighbors[2] == null)
			retString += "null";
		else
			retString += neighbors[2].getValue();
		
		retString += "\nNeighbor left: ";
		if (neighbors[3] == null)
			retString += "null";
		else
			retString += neighbors[3].getValue();
		
		return retString;
	}
}
