package question_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;



public class GridGraph {
	HashMap<String, GridNode> graphNodes;
	HashSet<GridNode> setOfNodes;
	ArrayList<ArrayList<GridNode>> grid;
	
	
	public GridGraph() {
		graphNodes = new HashMap<String, GridNode>();
		setOfNodes = new HashSet<GridNode>();
		grid = new ArrayList<ArrayList<GridNode>>();
	}
	
	
	public void addNode(final String nodeVal, final int xCoordinate, final int yCoordinate) {
		GridNode nodeToAdd = new GridNode(nodeVal, xCoordinate, yCoordinate);
		
		if (grid.size() <= xCoordinate) {		// if the grid isn't yet big enough in the x direction to contain the provided xCoordinate,
			int size = grid.size();				// then expand the grid out just enough to be able to contain the provided xCoordinate
			for (int i = size; i <= xCoordinate; i++) {
				grid.add(i, new ArrayList<GridNode>());
			}
		}
		
		ArrayList<GridNode> yColumn = grid.get(xCoordinate);
		if (yColumn.size() <= yCoordinate) {		// if the grid isn't yet big enough in the y direction at this xCoordinate to contain the provided yCoordinate
			int size = yColumn.size();				// then expand the grid out just enough at this xCoordinate to contain the provided yCoordinate
			for (int i = size; i <= yCoordinate; i++) {
				yColumn.add(i, null);
			}
		}
		
		GridNode replacedNode = yColumn.remove(yCoordinate);
		yColumn.add(yCoordinate, nodeToAdd);		// remove and replace the GridNode at the provided coordinates
		
		if (replacedNode != null) {			// take the removed GridNode out of the HashSet setOfNodes and the HashMap graphNodes
			graphNodes.remove(replacedNode.getValue());
			setOfNodes.remove(replacedNode);
		}
		
		graphNodes.put(nodeVal, nodeToAdd);
		setOfNodes.add(nodeToAdd);
	}
	
	
	public void addUndirectedEdge(final GridNode first, final GridNode second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			
			if (first.adjacentTo(second) == -1)
				return;
			
			first.setNeighbor(second);
			second.setNeighbor(first);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	
	public void removeUndirectedEdge(final GridNode first, final GridNode second) throws Exception {
		if (undirectedEdgeExists(first, second)) {
			first.removeNeighbor(second);		// first.removeNeighbor(second) does nothing if second is not a neighbor of first (same applies to the next line)
			second.removeNeighbor(first);
		}
	}
	
	
	public boolean undirectedEdgeExists(final GridNode first, final GridNode second) throws Exception {
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			return first.hasNeighbor(second) && second.hasNeighbor(first);
		}
		else {
			throw new Exception("A provided node does not exist in the graph");
		}
	}
	
	
	public HashSet<GridNode> getAllNodes() {
		return setOfNodes;
	}
	
	
	public GridNode getNode(String value) {
		return graphNodes.get(value);
	}
	
	
	public GridNode getNode(final int xCoordinate, final int yCoordinate) {
		return grid.get(xCoordinate).get(yCoordinate);		// TODO: Check that xCoordinate and yCoordinate exist in the graph
	}
}
