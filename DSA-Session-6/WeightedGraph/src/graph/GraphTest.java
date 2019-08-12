package graph;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	/**
	 * test case for is connected
	 * @throws Exception
	 */
	@Test
	public void isConnectedTest() throws Exception{
		UndirectedGraph undirectedGraph = new UndirectedGraph(5);
		undirectedGraph.addEdge(0, 1, 5);
		undirectedGraph.addEdge(0, 2, 7);
		undirectedGraph.addEdge(2, 3, 2);
		undirectedGraph.addEdge(0, 3, 1);
		undirectedGraph.addEdge(1, 3, 6);
		undirectedGraph.addEdge(1, 4, 9);
		undirectedGraph.addEdge(3, 4, 8);
		assertEquals(true, undirectedGraph.isConnected());
	}
	
	/**
	 * test case for find reachable node 
	 * @throws Exception
	 */
	@Test
	public void reachableTest() throws Exception{
		UndirectedGraph undirectedGraph = new UndirectedGraph(5);
		undirectedGraph.addEdge(0, 1, 5);
		undirectedGraph.addEdge(0, 2, 7);
		undirectedGraph.addEdge(2, 3, 2);
		undirectedGraph.addEdge(0, 3, 1);
		undirectedGraph.addEdge(1, 3, 6);
		undirectedGraph.addEdge(1, 4, 9);
		undirectedGraph.addEdge(3, 4, 8);
		assertEquals(new ArrayList(Arrays.asList(0,1,2,3,4)),undirectedGraph.reachable(1));
		
	}
	
	/**
	 * test case for minimum spanning tree
	 * @throws Exception
	 */
	@Test
	public void mstTest() throws Exception{
		UndirectedGraph undirectedGraph = new UndirectedGraph(5);
		undirectedGraph.addEdge(0, 1, 5);
		undirectedGraph.addEdge(0, 2, 7);
		undirectedGraph.addEdge(2, 3, 2);
		undirectedGraph.addEdge(0, 3, 1);
		undirectedGraph.addEdge(1, 3, 6);
		undirectedGraph.addEdge(1, 4, 9);
		undirectedGraph.addEdge(3, 4, 8);
		assertArrayEquals(new int[]{-1, 0,3,0,3},undirectedGraph.mst());
		
	}
	
	/**
	 * test case for shortest path
	 * @throws Exception
	 */
	@Test
	public void shortestPathTest() throws Exception{
		UndirectedGraph undirectedGraph = new UndirectedGraph(5);
		undirectedGraph.addEdge(0, 1, 5);
		undirectedGraph.addEdge(0, 2, 7);
		undirectedGraph.addEdge(2, 3, 2);
		undirectedGraph.addEdge(0, 3, 1);
		undirectedGraph.addEdge(1, 3, 6);
		undirectedGraph.addEdge(1, 4, 9);
		undirectedGraph.addEdge(3, 4, 8);
		assertEquals(9, undirectedGraph.shotestPath(1, 4));
		
	}
}
