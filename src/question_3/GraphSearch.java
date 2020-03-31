package question_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import sun.misc.Queue;

public class GraphSearch {
	
	public static ArrayList<Node> DFSRec(final Node start, final Node end) {
		ArrayList<Node> retList = new ArrayList<Node>();
		DFSRecHelper(start, end, retList);
		
		for (Node value: retList)
			value.setUnvisited();
		
		if (retList.get(retList.size() - 1) == end)
			return retList;
		else
			return null;
	}
	
	private static void DFSRecHelper(final Node start, final Node end, ArrayList<Node> retList) {
		
		retList.add(start);
		start.setVisited();
		
		if (start == end)
			return;
		
		for (Node next: start.getNeighbors().values()) {
			if (next.isVisited())
				continue;
			
			DFSRecHelper(next, end, retList);
			
			if (retList.get(retList.size() - 1) == end)
				return;
		}
		
		return;
	}
	
	
	public static ArrayList<Node> DFSIter(final Node start, final Node end) {
		ArrayList<Node> retList = new ArrayList<Node>();
		
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(start);
		start.setVisited();
		
		while (!nodeStack.isEmpty()) {
			Node current = nodeStack.peek();
			retList.add(current);
			
			if (current == end)
				return retList;
			
			boolean hasUnvisitedChildren = false;
			for (Node next: current.getNeighbors().values()) {
				if (!next.isVisited()) {
					nodeStack.push(next);
					next.setVisited();
					hasUnvisitedChildren = true;
				}
			}
			
			if(!hasUnvisitedChildren) {
				nodeStack.pop();
			}
		}
		
		for (Node value: retList)
			value.setUnvisited();
		
		return retList;
	}
	
	
	public static ArrayList<Node> BFTRec(final Graph graph) {
		ArrayList<Node> retList = new ArrayList<Node>();
		Iterator<Node> nodeIter = graph.getAllNodes().iterator();
		
		while (nodeIter.hasNext()) {
			Node holder = nodeIter.next();
			if (!holder.isVisited()) {
				holder.setVisited();
				BFTRecHelper(holder, retList);
			}
		}
		
		for (Node value: graph.getAllNodes())
			value.setUnvisited();
		
		return retList;
	}
	
	private static void BFTRecHelper(final Node current, ArrayList<Node> retList) {
		retList.add(current);
		for (Node next: current.getNeighbors().values()) {
			if (!next.isVisited()) {
				next.setVisited();
				BFTRecHelper(next, retList);
			}
		}
	}
	
	
	public static ArrayList<Node> BFTIter(final Graph graph) throws Exception {
		ArrayList<Node> retList = new ArrayList<Node>();
		
		Iterator<Node> nodeIter = graph.getAllNodes().iterator();
		
		while (nodeIter.hasNext()) {
			Node holder = nodeIter.next();
			if (!holder.isVisited()) {
				Queue<Node> nodeQueue = new Queue<Node>();
				nodeQueue.enqueue(holder);
				
				while (!nodeQueue.isEmpty()) {
					Node current = nodeQueue.dequeue();
					current.setVisited();
					retList.add(current);
					for(Node neighbor: current.getNeighbors().values()) {
						if (!neighbor.isVisited()) {
							nodeQueue.enqueue(neighbor);
							neighbor.setVisited();
						}
					}
				}
			}
		}
		
		for (Node value: graph.getAllNodes())
			value.setUnvisited();
		
		return retList;
	}
}
