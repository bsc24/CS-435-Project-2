package question_7;

import question_5.*;
import question_6.*;

public class Main {

	public static void main(String[] args) {
		try {
			WeightedGraph wGraph = question_5.Main.createRandomCompleteWeightedGraph(121);
			Node wStart = wGraph.getNode("0");
			
			GridGraph gGraph = question_6.Main.createRandomGridGraph(10);
			GridNode gStart = gGraph.getNode(0, 0);
			GridNode gEnd = gGraph.getNode(10, 10);
			
			question_5.Main.dijkstras(wStart);
			question_6.Main.astar(gStart, gEnd);
			
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
