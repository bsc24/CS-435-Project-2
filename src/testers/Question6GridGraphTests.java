package testers;

import static org.junit.Assert.*;

import org.junit.Test;

import question_6.GridGraph;
import question_6.GridNode;

public class Question6GridGraphTests {

	@Test
	public void defaultConstructorTest() {
		GridGraph aGraph = new GridGraph();
	}
	
	
	@Test
	public void addNodeTest() {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("4", 1, 1);
		aGraph.addNode("0", 1, 2);
		aGraph.addNode("1", 2, 1);
		aGraph.addNode("2", 1, 0);
		aGraph.addNode("3", 0, 1);
	}
	
	
	@Test
	public void addNodeReplaceTest() {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("0", 1, 1);
		assertEquals(1, aGraph.getAllNodes().size());
		
		aGraph.addNode("1", 1, 1);
		assertEquals(1, aGraph.getAllNodes().size());
	}
	
	
	@Test
	public void getNodeTest() {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("4", 1, 1);
		
		GridNode one = aGraph.getNode("4");
		GridNode two = aGraph.getNode(1, 1);
		
		assertEquals(one, two);
	}
	
	
	@Test
	public void addUndirectedEdgeTest() throws Exception {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("4", 1, 1);
		aGraph.addNode("0", 1, 2);
		
		GridNode center = aGraph.getNode("4");
		GridNode up = aGraph.getNode("0");
		
		aGraph.addUndirectedEdge(center, up);
		assertTrue(aGraph.undirectedEdgeExists(center, up));
		assertTrue(aGraph.undirectedEdgeExists(up, center));
	}
	
	
	@Test
	public void addUndirectedEdgeFailTest() throws Exception {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("0", 1, 2);
		aGraph.addNode("2", 1, 0);
		
		GridNode up = aGraph.getNode("0");
		GridNode down = aGraph.getNode("2");
		
		aGraph.addUndirectedEdge(up, down);
		assertFalse(aGraph.undirectedEdgeExists(up, down));
		assertFalse(aGraph.undirectedEdgeExists(down, up));
	}
	
	
	@Test (expected = Exception.class)
	public void addUndirectedEdgeThrowExceptionTest() throws Exception {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("4", 1, 1);
		
		GridNode center = aGraph.getNode("4");
		GridNode up = new GridNode("0", 1, 2);
		
		aGraph.addUndirectedEdge(center, up);
	}
	
	
	@Test
	public void removeUndirectedEdgeTest() throws Exception {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("0", 1, 2);
		aGraph.addNode("2", 1, 0);
		aGraph.addNode("4", 1, 1);

		GridNode up = aGraph.getNode("0");
		GridNode center = aGraph.getNode("4");
		GridNode down = aGraph.getNode("2");
		
		aGraph.addUndirectedEdge(center, up);
		aGraph.addUndirectedEdge(down, center);
		aGraph.addUndirectedEdge(up, down);
		
		assertTrue(aGraph.undirectedEdgeExists(center, up));
		assertTrue(aGraph.undirectedEdgeExists(up, center));
		
		assertTrue(aGraph.undirectedEdgeExists(center, down));
		assertTrue(aGraph.undirectedEdgeExists(down, center));
		
		assertFalse(aGraph.undirectedEdgeExists(up, down));
		assertFalse(aGraph.undirectedEdgeExists(down, up));
		
		aGraph.removeUndirectedEdge(up, center);
		
		assertFalse(aGraph.undirectedEdgeExists(center, up));
		assertFalse(aGraph.undirectedEdgeExists(up, center));
		
		assertTrue(aGraph.undirectedEdgeExists(center, down));
		assertTrue(aGraph.undirectedEdgeExists(down, center));
		
		assertFalse(aGraph.undirectedEdgeExists(up, down));
		assertFalse(aGraph.undirectedEdgeExists(down, up));
	}
	
	
	@Test
	public void removeUndirectedEdgeFailTest() throws Exception {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("0", 1, 2);
		aGraph.addNode("2", 1, 0);
		
		GridNode up = aGraph.getNode("0");
		GridNode down = aGraph.getNode("2");
		
		aGraph.addUndirectedEdge(up, down);
		assertFalse(aGraph.undirectedEdgeExists(up, down));
		assertFalse(aGraph.undirectedEdgeExists(down, up));
		
		aGraph.removeUndirectedEdge(up, down);
		assertFalse(aGraph.undirectedEdgeExists(up, down));
		assertFalse(aGraph.undirectedEdgeExists(down, up));
	}
	
	
	@Test (expected = Exception.class)
	public void removeUndirectedEdgeThrowExceptionTest() throws Exception {
		GridGraph aGraph = new GridGraph();
		aGraph.addNode("4", 1, 1);
		
		GridNode center = aGraph.getNode("4");
		GridNode up = new GridNode("0", 1, 2);
		
		aGraph.removeUndirectedEdge(center, up);
	}
}
