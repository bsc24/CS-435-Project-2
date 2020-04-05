package question_6;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public static GridGraph createRandomGridGraph(int n) throws Exception {
		GridGraph aGraph = new GridGraph();
		Random rng = new Random();
		int nodeNumber = 0;
		
		for (int xIndex = 0; xIndex <= n; xIndex++) {
			for(int yIndex = 0; yIndex <= n; yIndex++) {
				aGraph.addNode(Integer.toString(nodeNumber++), xIndex, yIndex);
				
				if (yIndex != 0 && rng.nextInt(100) < 50) {
					GridNode adjacentNode = aGraph.getNode(xIndex, yIndex - 1);
					GridNode current = aGraph.getNode(xIndex, yIndex);
					aGraph.addUndirectedEdge(current, adjacentNode);
				}
				
				if (xIndex != 0 && rng.nextInt(100) < 50) {
					GridNode adjacentNode = aGraph.getNode(xIndex - 1, yIndex);
					GridNode current = aGraph.getNode(xIndex, yIndex);
					aGraph.addUndirectedEdge(current, adjacentNode);
				}
			}
		}
		
		return aGraph;
	}
}
