package testers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

import question_4.DirectedGraph;
import question_4.Node;

public class Question4DAGTests {
	
	// Only tests things which should be acting differently from Question 3's Graph
	
	@Test
	public void addDirectedEdgeTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		DirectedGraph aGraph = new DirectedGraph(values);
		
		HashSet setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		
		Node first = something.next();
		Node second = something.next();
		
		assertFalse(aGraph.directedEdgeExists(first, second));
		assertFalse(aGraph.directedEdgeExists(second, first));
		aGraph.addDirectedEdge(first, second);

		assertNotEquals(first, second);
		assertTrue(aGraph.directedEdgeExists(first, second));
		assertFalse(aGraph.directedEdgeExists(second, first));
	}
	
	
	@Test
	public void removeUndirectedEdgeTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		DirectedGraph aGraph = new DirectedGraph(values);
		HashSet<Node> setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		Node first = something.next();
		Node second = something.next();
		aGraph.addDirectedEdge(first, second);

		assertNotEquals(first, second);
		assertTrue(aGraph.directedEdgeExists(first, second));
		assertFalse(aGraph.directedEdgeExists(second, first));
		
		aGraph.removeDirectedEdge(first, second);
		assertFalse(aGraph.directedEdgeExists(first, second));
		assertFalse(aGraph.directedEdgeExists(second, first));
	}
}
