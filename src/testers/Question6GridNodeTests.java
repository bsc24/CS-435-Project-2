package testers;

import static org.junit.Assert.*;

import org.junit.Test;

import question_6.GridNode;

public class Question6GridNodeTests {

	@Test
	public void adjacentToTest() throws Exception {
		GridNode center = new GridNode("0", 1, 1);
		GridNode up = new GridNode("up", 1, 2);
		GridNode down = new GridNode("down", 1, 0);
		GridNode right = new GridNode("right", 2, 1);
		GridNode left = new GridNode("left", 0, 1);
		
		center.setNeighbor(up);
		center.setNeighbor(down);
		center.setNeighbor(left);
		center.setNeighbor(right);
		
		assertEquals(0, center.adjacentTo(up));
		assertEquals(1, center.adjacentTo(right));
		assertEquals(2, center.adjacentTo(down));
		assertEquals(3, center.adjacentTo(left));
	}


	@Test
	public void getCoordinateTest() {
		GridNode first = new GridNode("0", 0, 0);
		GridNode second = new GridNode("1", 0, 1);
		
		assertEquals(0, first.getXCoordinate());
		assertEquals(0, first.getYCoordinate());
		
		assertEquals(0, second.getXCoordinate());
		assertEquals(1, second.getYCoordinate());
	}
	
	
	@Test
	public void hasNeighborTest() {
		GridNode center = new GridNode("0", 0, 0);
		GridNode adjacent = new GridNode("1", 0, 1);
		
		center.setNeighbor(adjacent);
		assertTrue(center.hasNeighbor(adjacent));
	}
	
	
	@Test
	public void setNeighborFailTest() throws Exception {
		GridNode center = new GridNode("0", 0, 0);
		GridNode diagonal = new GridNode("1", 1, 1);
		
		center.setNeighbor(diagonal);
		assertFalse(center.hasNeighbor(diagonal));
	}
	
	
	@Test
	public void getNeighborsTest() throws Exception {
		GridNode center = new GridNode("0", 1, 1);
		GridNode up = new GridNode("up", 1, 2);
		GridNode down = new GridNode("down", 1, 0);
		GridNode right = new GridNode("right", 2, 1);
		GridNode left = new GridNode("left", 0, 1);
		
		center.setNeighbor(up);
		center.setNeighbor(down);
		center.setNeighbor(left);
		center.setNeighbor(right);
		
		GridNode[] centerNeighbors = center.getNeighbors();
		
		assertEquals(up, centerNeighbors[0]);
		assertEquals(right, centerNeighbors[1]);
		assertEquals(down, centerNeighbors[2]);
		assertEquals(left, centerNeighbors[3]);
	}
	
	
	@Test
	public void removeNeighborTest() throws Exception {
		GridNode first = new GridNode("0", 0, 0);
		GridNode second = new GridNode("1", 0, 1);
		
		first.setNeighbor(second);
		assertTrue(first.hasNeighbor(second));
		
		first.removeNeighbor(second);
		assertFalse(first.hasNeighbor(second));
	}
	
	
	@Test
	public void toStringTest() throws Exception {
		GridNode center = new GridNode("0", 1, 1);
		GridNode up = new GridNode("up", 1, 2);
		GridNode down = new GridNode("down", 1, 0);
		GridNode right = new GridNode("right", 2, 1);
		GridNode left = new GridNode("left", 0, 1);
		
		center.setNeighbor(up);
		center.setNeighbor(down);
		center.setNeighbor(left);
		center.setNeighbor(right);
		
		String expected = "Node: 0" +
				"\nCoordinates: 1,1" +
				"\nNeighbor up: up" +
				"\nNeighbor right: right" +
				"\nNeighbor down: down" +
				"\nNeighbor left: left";
		
		assertEquals(expected, center.toString());
		
		expected = "Node: up" +
				"\nCoordinates: 1,2" +
				"\nNeighbor up: null" +
				"\nNeighbor right: null" +
				"\nNeighbor down: null" +
				"\nNeighbor left: null";
		
		assertEquals(expected, up.toString());
	}
}
