package testers;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;
import question_3.*;


public class MainTests {
	
	// Undirected Graph
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void createRandomUnweightedGraphIterTest1() throws Exception {
		Graph aGraph = Main.createRandomUnweightedGraphIter(5);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(5, nodeSet.size());
		System.out.println("Test: createRandomUnweightedGraphIterTest1");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void createLinkedListTest() throws Exception {
		Graph aGraph = Main.createLinkedList(5);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(5, nodeSet.size());
		System.out.println("Test: createLinkedListTest");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}
	
	
	// Directed Graph
}
