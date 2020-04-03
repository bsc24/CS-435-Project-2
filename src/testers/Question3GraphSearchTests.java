package testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import question_3.*;

public class Question3GraphSearchTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void DFSRecTest() throws Exception{
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		Node start = aGraph.getNode("0");
		Node end = aGraph.getNode("9");
		ArrayList<Node> DFSearch = GraphSearch.DFSRec(start, end);
		System.out.println("Test: DFSRecTest");
		if (DFSearch == null) {
			System.out.println("No path found, printing nodes");
			for (Node value: aGraph.getAllNodes())
				System.out.println(value + "\n");
		}
		else {
			for (Node value: DFSearch)
				System.out.println(value + "\n");
		}
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void DFSIterTest() throws Exception {
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		Node start = aGraph.getNode("0");
		Node end = aGraph.getNode("9");
		ArrayList<Node> DFSearch = GraphSearch.DFSIter(start, end);
		System.out.println("Test: DFSIterTest");
		if (DFSearch == null) {
			System.out.println("No path found, printing nodes");
			for (Node value: aGraph.getAllNodes())
				System.out.print(value + "\n");
		}
		else {
			for (Node value: DFSearch)
				System.out.println(value + "\n");
		}
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void BFTRecTest() throws Exception {
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		ArrayList<Node> BFT = GraphSearch.BFTIter(aGraph);
		System.out.println("Test: BFTRecTest");
		for (Node value: BFT)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void BFTIterTest() throws Exception {
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		ArrayList<Node> BFT = GraphSearch.BFTIter(aGraph);
		System.out.println("Test: BFTIterTest");
		for (Node value: BFT)
			System.out.println(value + "\n");
	}
}
