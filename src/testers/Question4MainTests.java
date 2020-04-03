package testers;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import question_4.*;

public class Question4MainTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createRandomDAGIterTest() throws Exception {
		DirectedGraph aGraph = Main.createRandomDAGIter(10);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(10, nodeSet.size());
		System.out.println("Test: createRandomDAGIterTest");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}

}
