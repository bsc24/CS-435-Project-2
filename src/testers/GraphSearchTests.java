package testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import question_3.*;

public class GraphSearchTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void DFSRecTest() throws Exception{
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		Node start = aGraph.getNode("0");
		Node end = aGraph.getNode("9");
		ArrayList<Node> DFSearch = GraphSearch.DFSRec(start, end);
		System.out.println("Test: DFSRecTest");
		for (Node value: DFSearch)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void DFSIterTest() throws Exception {
		Graph aGraph = Main.createRandomUnweightedGraphIter(10);
		Node start = aGraph.getNode("0");
		Node end = aGraph.getNode("9");
		ArrayList<Node> DFSearch = GraphSearch.DFSIter(start, end);
		System.out.println("Test: DFSIterTest");
		for (Node value: DFSearch)
			System.out.println(value + "\n");
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
