package question_5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;


public class Main {
	
	public static void main(String[] args) {
		try {
			WeightedGraph aGraph = createRandomCompleteWeightedGraph(4);
			Node start = aGraph.getNode("0");
			HashMap<Node, Integer> dijkstrasResult = dijkstras(start);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static WeightedGraph createRandomCompleteWeightedGraph(int n) throws Exception {
		WeightedGraph retGraph = new WeightedGraph();
		HashSet<Node> nodeSet = retGraph.getAllNodes();
		Random rng = new Random();
		
		for (int i = 0; i < n; i++) {
			retGraph.addNode(Integer.toString(i));
			Node holder = retGraph.getNode(Integer.toString(i));
			
			for (Node value: nodeSet) {
				if (value != holder) {
					retGraph.addWeightedEdge(holder, value, rng.nextInt(100) + 1);
					retGraph.addWeightedEdge(value, holder, rng.nextInt(100) + 1);
				}
			}
		}
		
		return retGraph;
	}
	
	
	public static WeightedGraph createLinkedList(int n) throws Exception {
		WeightedGraph retGraph = new WeightedGraph();

		retGraph.addNode("0");
		Node last = retGraph.getNode("0");
		
		for (int i = 1; i < n; i++) {
			retGraph.addNode(Integer.toString(i));
			Node current = retGraph.getNode(Integer.toString(i));
			last.setNeighbor(current, 1);
			last = current;
		}
		
		return retGraph;
	}
	
	
	public static HashMap<Node, Integer> dijkstras(final Node start) {
		HashMap<Node, Integer> distanceMap = new HashMap<Node, Integer>();	// [Node to get to], [distance to Node to get to]
		HashMap<Node, Node> previousNode = new HashMap<Node, Node>();		// [Node to get to], [Node previous to the Node to get to]
		
		Comparator<Node> distanceToNodeComparator = new Comparator<Node>() {
			@Override
			public int compare(Node first, Node second) {
				if (distanceMap.get(first) == -1) {
					if (distanceMap.get(second) == -1)
						return 0;
					
					return 1;
				}
				
				return distanceMap.get(first).intValue() - distanceMap.get(second).intValue();
			}
		};
		
		PriorityQueue<Node> nodePrioQueue = new PriorityQueue<Node>(distanceToNodeComparator);
		
		distanceMap.put(start, 0);
		distanceMap.put(start, null);
		start.setVisited();
		
		for (Node value: start.getAllGraphNodes()) {
			Node previous = null;
			int distance = -1;
			
			if (value == start) {
				distance = 0;
			}
			else if (start.hasNeighbor(value)) {
				previous = start;
				distance = start.distanceToNeighbor(value);
			}
			
			distanceMap.put(value, distance);
			previousNode.put(value, previous);
			
			if (value != start) {
				nodePrioQueue.add(value);
			}
		}
		
		
		while (!nodePrioQueue.isEmpty()) {
			Node current = nodePrioQueue.poll();
			Integer distanceToCurrent = distanceMap.get(current);
			current.setVisited();
			if (distanceToCurrent == -1)
				continue;
			
			for (Node neighbor: current.getNeighbors().keySet()) {
				if (neighbor.isVisited())
					continue;
				
				Integer distanceToValue = distanceToCurrent + current.distanceToNeighbor(neighbor);
				if (distanceToValue < distanceMap.get(neighbor)) {
					distanceMap.put(neighbor, distanceToValue);
					previousNode.put(neighbor, current);
				}
			}
		}
		
		return distanceMap;
	}
}
