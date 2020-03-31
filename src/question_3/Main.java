package question_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		try {
			//BFTRecLinkedList(20000);	// Worked for 10000
			BFTIterLinkedList(200000);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static Graph createRandomUnweightedGraphIter(int n) throws Exception {
		Graph retGraph = new Graph();
		HashSet<Node> nodeSet = retGraph.getAllNodes();
		Random rng = new Random();
		for (int i = 0; i < n; i++) {
			retGraph.addNode(Integer.toString(i));
			Node holder = retGraph.getNode(Integer.toString(i));
			
			for (Node value: nodeSet) {
				if (value != holder && rng.nextInt(100) < 30)
					retGraph.addUndirectedEdge(holder, value);
			}
		}
		
		return retGraph;
	}
	
	
	public static Graph createLinkedList(int n) throws Exception {
		Graph retGraph = new Graph();

		retGraph.addNode("0");
		Node last = retGraph.getNode("0");
		
		for (int i = 1; i < n; i++) {
			retGraph.addNode(Integer.toString(i));
			Node current = retGraph.getNode(Integer.toString(i));
			last.setNeighbor(current);
			last = current;
		}
		
		return retGraph;
	}
	
	
	public static ArrayList<Node> BFTRecLinkedList(final int n) throws Exception {
		return GraphSearch.BFTRec(createLinkedList(n));
	}
	
	
	public static ArrayList<Node> BFTIterLinkedList(final int n) throws Exception {
		return GraphSearch.BFTIter(createLinkedList(n));
	}
}
