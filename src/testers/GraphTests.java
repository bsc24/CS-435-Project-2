package testers;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;
import question_3.Graph;
import question_3.Node;

public class GraphTests {
	
	@Test
	public void defaultConstructorTest() {
		Graph aGraph = new Graph();
	}
	
	
	@Test
	public void stringConstructorTest() {
		String value = "A String value";
		Graph aGraph = new Graph(value);
	}
	
	
	@Test
	public void stringArrayConstructorTest() {
		String[] values = {"A String value", "Another String value", "A third String value"};
		Graph aGraph = new Graph(values);
	}
	
	
	@Test
	public void addNodeTest() {
		String value = "A String value";
		Graph aGraph = new Graph();
		aGraph.addNode(value);
		aGraph.addNode(value);
	}

	
	@Test
	public void addMultipleNodeTest() {
		String value = "A String value";
		String value2 = "Another String value";
		String value3 = "A third String value";
		Graph aGraph = new Graph();
		aGraph.addNode(value);
		aGraph.addNode(value2);
		aGraph.addNode(value3);
	}
	
	
	@Test
	public void getNodeTest() {
		String[] values = {"A String value", "Another String value", "A third String value"};
		Graph aGraph = new Graph(values);
		
		for (int i = 0; i < values.length; i++)
			assertEquals(values[i], aGraph.getNode(values[i]).getValue());
	}
	
	
	@Test
	public void getAllNodesTest() {
		String[] values = {"A String value", "Another String value", "A third String value"};
		Graph aGraph = new Graph(values);
		HashSet<Node> setOfNodes = aGraph.getAllNodes();
		assertFalse(setOfNodes.isEmpty());
		
		Node[] nodesOfGraph = new Node[setOfNodes.size()];
		setOfNodes.toArray(nodesOfGraph);
		for (int i = 0; i < nodesOfGraph.length; i++) {
			String aValue = nodesOfGraph[i].getValue();
			boolean found = false;
			for (int j = 0; j < values.length; j++) {
				if (aValue == values[j]) {
					found = true;
					break;
				}
			}
			
			if (!found)
				fail("A failure occurred");
		}
	}
	
	
	@Test
	public void addUndirectedEdgeTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		Graph aGraph = new Graph(values);
		
		HashSet setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		
		Node first = something.next();
		Node second = something.next();
		
		assertFalse(aGraph.undirectedEdgeExists(first, second));
		aGraph.addUndirectedEdge(first, second);

		assertNotEquals(first, second);
		assertTrue(aGraph.undirectedEdgeExists(first, second));
	}
	
	
	@Test (expected = Exception.class)
	public void addUndirectedEdgeFailTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		Graph aGraph = new Graph(values[0]);
		
		HashSet setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		
		Node first = something.next();
		Node second = new Node(values[1]);

		aGraph.addUndirectedEdge(first, second);
	}
	
	
	@Test
	public void removeUndirectedEdgeTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		Graph aGraph = new Graph(values);
		HashSet setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		Node first = something.next();
		Node second = something.next();
		aGraph.addUndirectedEdge(first, second);

		assertNotEquals(first, second);
		assertTrue(aGraph.undirectedEdgeExists(first, second));
		aGraph.removeUndirectedEdge(first, second);
		assertFalse(aGraph.undirectedEdgeExists(first, second));
	}
	

	@Test (expected = Exception.class)
	public void removeUndirectedEdgeFailTest() throws Exception {
		String[] values = {"A String value", "Another String value"};
		Graph aGraph = new Graph(values[0]);
		
		HashSet setOfNodes = aGraph.getAllNodes();
		Iterator<Node> something = setOfNodes.iterator();
		
		Node first = something.next();
		Node second = new Node(values[1]);

		aGraph.removeUndirectedEdge(first, second);
	}
	
	
	/*
	@Test
	public void addNodeTest() {
		fail("Not yet implemented");
	}
	*/
}
