package question_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;



public class Main {

	public static void main(String[] args) {
		try {
			GridGraph aGraph = createRandomGridGraph(100);
			GridNode sourceNode = aGraph.getNode(0, 0);
			GridNode destNode = aGraph.getNode(100, 100);
			ArrayList<GridNode> astarPath = astar(sourceNode, destNode);
			for (GridNode value: astarPath) {
				System.out.print(value.getValue() + " ");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static GridGraph createRandomGridGraph(int n) throws Exception {
		GridGraph aGraph = new GridGraph();
		Random rng = new Random();
		int nodeNumber = 0;
		int percentChance = 70;
		
		for (int xIndex = 0; xIndex <= n; xIndex++) {
			for(int yIndex = 0; yIndex <= n; yIndex++) {
				aGraph.addNode(Integer.toString(nodeNumber++), xIndex, yIndex);
				
				if (yIndex != 0 && rng.nextInt(100) < percentChance) {			// If the currently added node isn't at the bottom of the graph, 70% chance to make an undirected edge to the GridNode below it
					GridNode adjacentNode = aGraph.getNode(xIndex, yIndex - 1);
					GridNode current = aGraph.getNode(xIndex, yIndex);
					aGraph.addUndirectedEdge(current, adjacentNode);
				}
				
				if (xIndex != 0 && rng.nextInt(100) < percentChance) {			// If the currently added node isn't at the furthest left of the graph, 70% chance to make an undirected edge to the GridNode to the left of it
					GridNode adjacentNode = aGraph.getNode(xIndex - 1, yIndex);
					GridNode current = aGraph.getNode(xIndex, yIndex);
					aGraph.addUndirectedEdge(current, adjacentNode);
				}
			}
		}
		
		return aGraph;
	}
	
	
	public static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode) {
		HashMap<GridNode, int[]> mapToEnd = new HashMap<GridNode, int[]>();			// [GridNode], [distance from start, heuristic distance to end]
		HashMap<GridNode, GridNode> previousNode = new HashMap<GridNode, GridNode>();		// [GridNode to get to], [GridNode previous to the GridNode to get to]
																							// Used to backtrack and figure out how we got to the end from start
		Comparator<GridNode> distanceToNodeComparator = new Comparator<GridNode>() {
			@Override
			public int compare(GridNode first, GridNode second) {
				return (mapToEnd.get(first)[0] + mapToEnd.get(first)[1]) - (mapToEnd.get(second)[0] + mapToEnd.get(second)[1]);	// Difference of each node's (distance from start + manhattan distance to end)
			}
		};
		
		PriorityQueue<GridNode> nodePrioQueue = new PriorityQueue<GridNode>(distanceToNodeComparator);		// Used for backtracking to save time (thanks for the idea, jb-moroccan!)
		
		int[] sourceDistances = {0, heuristic(sourceNode, destNode)};
		mapToEnd.put(sourceNode, sourceDistances);
		
		nodePrioQueue.add(sourceNode);
		previousNode.put(sourceNode, null);		// there shouldn't be a node previous to our start, set it's previous as null instead
		
		
		while (!nodePrioQueue.isEmpty()) {
			GridNode current = nodePrioQueue.poll();
			
			if (current.isVisited())
				continue;
			
			current.setVisited();
			
			if (current == destNode) {
				break;
			}
			
			for (GridNode neighbor: current.getNeighbors()) {
				if (neighbor == null || neighbor.isVisited())
					continue;
				
				boolean updatePreviousNode = true;
				int currentDist = mapToEnd.get(current)[0] + 1;
				
				if (mapToEnd.containsKey(neighbor)) {
					if (mapToEnd.get(neighbor)[0] < currentDist) {
						currentDist = mapToEnd.get(neighbor)[0];
					}
					else
						updatePreviousNode = false;
				}
				
				
				int[] holder = {currentDist, heuristic(neighbor, destNode)};
				mapToEnd.put(neighbor, holder);
				if (updatePreviousNode)
					previousNode.put(neighbor, current);
				
				nodePrioQueue.add(neighbor);
			}
		}
		
		GridNode current = destNode;
		ArrayList<GridNode> retList = new ArrayList<GridNode>();
		
		while (current != null) {
			retList.add(0, current);
			current = previousNode.get(current);
		}
		
		return retList;
	}
	
	
	private static int heuristic(final GridNode current, final GridNode destination) {		// heuristic being used here is the Manhattan Distance
		int xDist = Math.abs(current.getXCoordinate() - destination.getXCoordinate());
		int yDist = Math.abs(current.getYCoordinate() - destination.getYCoordinate());
		
		return xDist + yDist;
	}
}
