package testers;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;
import question_3.*;


public class Question3MainTests {
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createRandomUnweightedGraphIterTest() throws Exception {
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(nodeSet.size(), 10);
		System.out.println("Test: createRandomUnweightedGraphIterTest");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createLinkedListTest() throws Exception {
		Graph aGraph = Main.createLinkedList(10);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(nodeSet.size(), 10);
		System.out.println("Test: createLinkedListTest");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}
}
