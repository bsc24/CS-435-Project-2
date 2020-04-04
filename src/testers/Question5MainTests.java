package testers;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import question_5.Main;
import question_5.WeightedGraph;
import question_5.Node;

public class Question5MainTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createRandomCompleteWeightedGraphTest() throws Exception {
		WeightedGraph aGraph = Main.createRandomCompleteWeightedGraph(5);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(nodeSet.size(), 5);
		System.out.println("Test: createRandomCompleteWeightedGraphTest");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void createLinkedListTest() throws Exception {
		WeightedGraph aGraph = Main.createLinkedList(10);
		HashSet<Node> nodeSet = aGraph.getAllNodes();
		assertEquals(nodeSet.size(), 10);
		System.out.println("Test: createLinkedListTest");
		for (Node value: nodeSet)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked, prints in no particular order
	public void dijkstrasTest() throws Exception {
		WeightedGraph aGraph = Main.createRandomCompleteWeightedGraph(5);
		Node start = aGraph.getNode("0");
		HashMap<Node, Integer> dijkstras = Main.dijkstras(start);
		
		System.out.println("Test: dijkstrasTest");
		Node[] neighborsArray = new Node[dijkstras.size()];
		dijkstras.keySet().toArray(neighborsArray);
		
		for (int i = 0; i < neighborsArray.length; i++) {
			System.out.println("Distance: " + dijkstras.get(neighborsArray[i]));
			System.out.println(neighborsArray[i] + "\n");
		}
	}
}
