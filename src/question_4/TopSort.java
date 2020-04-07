package question_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import sun.misc.Queue;

public class TopSort {
	
	public static ArrayList<Node> Kahns(final DirectedGraph graph) throws Exception {
		HashMap<Node, Integer> nodeInDegrees = new HashMap<Node, Integer>();
		HashSet<Node> allNodes = graph.getAllNodes();
		for (Node value: allNodes)
			nodeInDegrees.put(value, value.getInDegree());
		
		ArrayList<Node> retList = new ArrayList<Node>();
		Queue<Node> nodeQueue = new Queue<Node>();
		
		for (Node value: allNodes) {
			if (nodeInDegrees.get(value) == 0)
				nodeQueue.enqueue(value);
		}
		
		while (!nodeQueue.isEmpty()) {
			Node current = nodeQueue.dequeue();
			retList.add(current);
			nodeInDegrees.put(current, -1);
			for (Node neighbor: current.getNeighbors().values()) {
				int newIn = nodeInDegrees.get(neighbor) - 1;
				nodeInDegrees.put(neighbor, newIn);
				if (nodeInDegrees.get(neighbor) == 0)
					nodeQueue.enqueue(neighbor);
			}
		}
		
		return retList;
	}
	
	
	public static ArrayList<Node> mDFS(final DirectedGraph graph) {
		ArrayList<Node> retList = new ArrayList<Node>();
		for (Node value: graph.getAllNodes()) {
			if (!value.isVisited())
				mDFSHelper(value, retList);
		}
		
		return retList;
	}
	
	private static void mDFSHelper(Node current, ArrayList<Node> retList) {
		current.setVisited();
		for (Node neighbor: current.getNeighbors().values()) {
			if (!neighbor.isVisited())
				mDFSHelper(neighbor, retList);
		}
		
		retList.add(0, current);
	}
}
