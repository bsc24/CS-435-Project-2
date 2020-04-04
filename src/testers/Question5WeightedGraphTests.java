package testers;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

import question_5.Node;
import question_5.WeightedGraph;

public class Question5WeightedGraphTests {

	@Test
	public void distanceToNeighborTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		WeightedGraph aGraph = new WeightedGraph(values);
		
		HashSet setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		
		Node first = something.next();
		Node second = something.next();
		
		assertFalse(aGraph.directedEdgeExists(first, second));
		assertFalse(aGraph.directedEdgeExists(second, first));
		aGraph.addWeightedEdge(first, second, 5);

		assertNotEquals(first, second);
		assertTrue(aGraph.directedEdgeExists(first, second));
		assertEquals(aGraph.distanceToNeighbor(first, second), 5);
		assertFalse(aGraph.directedEdgeExists(second, first));
	}

}
