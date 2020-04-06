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
				
				if (yIndex != 0 && rng.nextInt(100) < percentChance) {
					GridNode adjacentNode = aGraph.getNode(xIndex, yIndex - 1);
					GridNode current = aGraph.getNode(xIndex, yIndex);
					aGraph.addUndirectedEdge(current, adjacentNode);
				}
				
				if (xIndex != 0 && rng.nextInt(100) < percentChance) {
					GridNode adjacentNode = aGraph.getNode(xIndex - 1, yIndex);
					GridNode current = aGraph.getNode(xIndex, yIndex);
					aGraph.addUndirectedEdge(current, adjacentNode);
				}
			}
		}
		
		return aGraph;
	}
	
	
	public static ArrayList<GridNode> astar(final GridNode sourceNode, final GridNode destNode) {
		ArrayList<GridNode> retList = new ArrayList<GridNode>();
		HashMap<GridNode, int[]> mapToEnd = new HashMap<GridNode, int[]>();
		
		Comparator<GridNode> distanceToNodeComparator = new Comparator<GridNode>() {
			@Override
			public int compare(GridNode first, GridNode second) {
				return (mapToEnd.get(first)[0] + mapToEnd.get(first)[1]) - (mapToEnd.get(second)[0] + mapToEnd.get(second)[1]);
			}
		};
		
		PriorityQueue<GridNode> nodePrioQueue = new PriorityQueue<GridNode>(distanceToNodeComparator);
		
		int[] sourceDistances = {0, heuristic(sourceNode, destNode)};
		mapToEnd.put(sourceNode, sourceDistances);
		
		nodePrioQueue.add(sourceNode);
		
		
		while (!nodePrioQueue.isEmpty()) {
			GridNode current = nodePrioQueue.poll();
			
			if (current.isVisited())
				continue;
			
			current.setVisited();
			retList.add(current);
			
			if (current == destNode) {
				break;
			}
			
			for (GridNode neighbor: current.getNeighbors()) {
				if (neighbor == null || neighbor.isVisited())
					continue;
				
				int currentDist = mapToEnd.get(current)[0] + 1;
				
				if (mapToEnd.containsKey(neighbor)) {
					if (mapToEnd.get(neighbor)[0] < currentDist) {
						currentDist = mapToEnd.get(neighbor)[0];
					}
				}
				
				
				int[] holder = {currentDist, heuristic(neighbor, destNode)};
				mapToEnd.put(neighbor, holder);
				
				nodePrioQueue.add(neighbor);
			}
		}
		
		
		
		for (int currentIndex = retList.size() - 1; currentIndex > 0; currentIndex--) {
			int previousIndex = currentIndex - 1;
			GridNode current = retList.get(currentIndex);
			GridNode previous = retList.get(previousIndex);
			while (!current.hasNeighbor(previous)) {
				retList.remove(previousIndex);
				previousIndex--;
				currentIndex--;
				previous = retList.get(previousIndex);
			}
		}
		
		return retList;
	}
	
	
	private static int heuristic(final GridNode current, final GridNode destination) {
		int xDist = Math.abs(current.getXCoordinate() - destination.getXCoordinate());
		int yDist = Math.abs(current.getYCoordinate() - destination.getYCoordinate());
		
		return xDist + yDist;
	}
}
