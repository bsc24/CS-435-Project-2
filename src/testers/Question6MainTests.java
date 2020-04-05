package testers;

import static org.junit.Assert.*;

import org.junit.Test;

import question_6.GridGraph;
import question_6.GridNode;
import question_6.Main;

public class Question6MainTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createRandomGridGraphTest() throws Exception {
		GridGraph aGraph = Main.createRandomGridGraph(4);
		
		for (GridNode value: aGraph.getAllNodes())
			System.out.println(value + "\n");
	}

}
