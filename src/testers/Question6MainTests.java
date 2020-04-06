package testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import question_6.GridGraph;
import question_6.GridNode;
import question_6.Main;

public class Question6MainTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createRandomGridGraphTest() throws Exception {
		GridGraph aGraph = Main.createRandomGridGraph(4);

		System.out.println("Test: createRandomGridGraphTest");
		for (GridNode value: aGraph.getAllNodes())
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void astarTest() throws Exception {
		GridGraph aGraph = Main.createRandomGridGraph(4);
		GridNode source = aGraph.getNode(0, 0);
		GridNode destination = aGraph.getNode(4, 4);
		
		ArrayList<GridNode> astarAnswer = Main.astar(source, destination);

		System.out.println("Test: astarTest");
		System.out.println("Full graph: ");
		for (GridNode value: aGraph.getAllNodes())
			System.out.println(value + "\n");
		
		System.out.print("A* Traversal: ");
		for (GridNode value: astarAnswer)
			System.out.print(value.getValue() + " ");
	}

}
