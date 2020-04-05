package question_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;



public class GridGraph {
	HashMap<String, GridNode> graphNodes;
	HashSet<GridNode> setOfNodes;
	ArrayList<ArrayList<GridNode>> grid;
	int gridHeight;
	
	public GridGraph() {
		graphNodes = new HashMap<String, GridNode>();
		setOfNodes = new HashSet<GridNode>();
		grid = new ArrayList<ArrayList<GridNode>>();
	}
	
	
	public void addNode(final String nodeVal, final int xCoordinate, final int yCoordinate) {
		GridNode nodeToAdd = new GridNode(nodeVal, xCoordinate, yCoordinate);
		
		if (grid.size() <= xCoordinate) {
			int size = grid.size();
			for (int i = size; i <= xCoordinate; i++) {
				grid.add(i, new ArrayList<GridNode>());
			}
		}
		
		ArrayList<GridNode> yColumn = grid.get(xCoordinate);
		if (yColumn.size() <= yCoordinate) {
			int size = yColumn.size();
			for (int i = size; i <= yCoordinate; i++) {
				yColumn.add(i, null);
			}
		}
		
		GridNode replacedNode = yColumn.remove(yCoordinate);
		yColumn.add(yCoordinate, nodeToAdd);
		
		if (replacedNode != null) {
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
		if (graphNodes.containsValue(first) && graphNodes.containsValue(second)) {
			first.removeNeighbor(second);
			second.removeNeighbor(first);
		}
		else
			throw new Exception("A provided node does not exist in the graph.");
	}
	
	
	public boolean undirectedEdgeExists(final GridNode first, final GridNode second) {
		return first.hasNeighbor(second) && second.hasNeighbor(first);
	}
	
	
	public HashSet<GridNode> getAllNodes() {
		return setOfNodes;
	}
	
	
	public GridNode getNode(String value) {
		return graphNodes.get(value);
	}
	
	
	public GridNode getNode(final int xCoordinate, final int yCoordinate) {
		return grid.get(xCoordinate).get(yCoordinate);
	}
}
