package question_4;

import java.util.HashSet;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			TopSort.mDFS(createRandomDAGIter(1000));
			TopSort.Kahns(createRandomDAGIter(1000));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static DirectedGraph createRandomDAGIter(int n) throws Exception {
		DirectedGraph retGraph = new DirectedGraph();
		HashSet<Node> nodeSet = retGraph.getAllNodes();
		Random rng = new Random();
		for (int i = 0; i < n; i++) {
			retGraph.addNode(Integer.toString(i));
			Node holder = retGraph.getNode(Integer.toString(i));
			
			for (Node value: nodeSet) {
				if (value != holder && rng.nextInt(100) < 50)
					retGraph.addDirectedEdge(holder, value);
			}
		}
		
		return retGraph;
	}
}
