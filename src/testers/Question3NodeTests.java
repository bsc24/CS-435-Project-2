package testers;

import static org.junit.Assert.*;

import org.junit.Test;

import question_3.Node;

public class Question3NodeTests {

	@Test
	public void stringConstructorTest() {
		String value = "A String value";
		Node aNode = new Node(value);
	}
	
	
	@Test
	public void getValueTest() {
		String value = "A String value";
		Node aNode = new Node(value);
		assertEquals(value, aNode.getValue());
	}
	
	
	@Test
	public void addNeighborTest() {
		String value = "A String value";
		String value2 = "Another String value";
		Node aNode = new Node(value);
		Node anotherNode = new Node(value2);
		aNode.setNeighbor(anotherNode);
	}
	
	
	@Test
	public void hasNeighborTests() {
		String value = "A String value";
		String value2 = "Another String value";
		Node aNode = new Node(value);
		Node anotherNode = new Node(value2);
		aNode.setNeighbor(anotherNode);
		assertTrue(aNode.hasNeighbor(anotherNode));
		assertFalse(aNode.hasNeighbor(aNode));
		assertEquals("Node: " + value + "\nNeighbor(s): " + value2, aNode.toString());
	}
	
	
	@Test
	public void removeNeighborTest() {
		String value = "A String value";
		String value2 = "Another String value";
		Node aNode = new Node(value);
		Node anotherNode = new Node(value2);
		aNode.setNeighbor(anotherNode);
		assertTrue(aNode.hasNeighbor(anotherNode));
		aNode.removeNeighbor(anotherNode);
		assertFalse(aNode.hasNeighbor(anotherNode));
		assertEquals("Node: " + value, aNode.toString());
	}
}
