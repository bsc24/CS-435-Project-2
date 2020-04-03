package testers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import question_4.DirectedGraph;
import question_4.Node;
import question_4.Main;
import question_4.TopSort;

public class Question4TopSortTests {

	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void mDFSTest() throws Exception {
		DirectedGraph aGraph = Main.createRandomDAGIter(10);
		ArrayList<Node> mDFSort = TopSort.mDFS(aGraph);
		System.out.println("Test: mDFSTest");
		for (Node value: mDFSort)
			System.out.println(value + "\n");
	}
	
	
	@Test		// Doesn't fully test automatically, the printed output must be manually checked
	public void KahnsTest() throws Exception {
		DirectedGraph aGraph = Main.createRandomDAGIter(10);
		ArrayList<Node> mDFSort = TopSort.Kahns(aGraph);
		System.out.println("Test: KahnsTest");
		for (Node value: mDFSort)
			System.out.println(value + "\n");
	}
}
