package question_7;

import question_5.*;
import question_6.*;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.print("Generating random weighted graph... ");
			WeightedGraph wGraph = question_5.Main.createRandomCompleteWeightedGraph(2500);
			System.out.println(" Done.");
			Node wStart = wGraph.getNode("0");
			
			System.out.print("Generating random grid graph... ");
			GridGraph gGraph = question_6.Main.createRandomGridGraph(49);	// createRandomGridGraph(n) makes a graph with (n+1)^2 nodes
			System.out.println(" Done.");
			GridNode gStart = gGraph.getNode(0, 0);
			GridNode gEnd = gGraph.getNode(49, 49);
			
			System.out.print("Starting dijkstras... ");
			question_5.Main.dijkstras(wStart);
			System.out.println(" Done.");
			
			System.out.print("Starting A*... ");
			question_6.Main.astar(gStart, gEnd);
			System.out.println(" Done.");
			
			int dijkstrasFinalized = 0;
			for (Node value: wGraph.getAllNodes()) {
				if (value.isVisited())
					dijkstrasFinalized++;
			}
			System.out.println("Total finalized by Dijkstra's: " + dijkstrasFinalized);
			
			int aStarFinalized = 0;
			for (GridNode value: gGraph.getAllNodes()) {
				if (value.isVisited())
					aStarFinalized++;
			}
			System.out.println("Total finalized by A*: " + aStarFinalized);
			
			if (dijkstrasFinalized > aStarFinalized)
				System.out.println("Dijkstra's finalized " + (dijkstrasFinalized - aStarFinalized) + " more nodes than A*.");
			else if (aStarFinalized > dijkstrasFinalized)
				System.out.println("A* finalized " + (aStarFinalized - dijkstrasFinalized) + " more nodes than Dijkstra's.");
			else
				System.out.println("Dijkstra's and A* finalized the same number of nodes.");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
