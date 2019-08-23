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
	public void isConnectedTest() throws Exception
	{
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
	public void reachableTest() throws Exception
	{
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
	public void mstTest() throws Exception 
	{
		UndirectedGraph graph = new UndirectedGraph(5);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 2, 4);
		List<Node> edges = new ArrayList<Node>();
		edges = graph.mst();

		int actual[][] = new int[edges.size()][3];
		for (int i = 0; i < edges.size(); i++) 
		{
			actual[i][0] = edges.get(i).getDestination();
			actual[i][1] = edges.get(i).getVertex();
			actual[i][2] = edges.get(i).getWeight();
		}
		int expected[][] = new int[][] { { 1, 2, 1 }, { 1, 3, 2 }, { 3, 4, 2 }, { 0, 2, 3 } };
		assertArrayEquals(expected, actual);
	}

	/**
	 * test case for shortest path
	 * @throws Exception
	 */
	@Test
	public void shortestPathTest() throws Exception
	{
	public void mstTest() throws Exception{
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
	
	/**
	 * test case for is connected
	 * @throws Exception
	 */
	@Test
	public void isConnectedTestNegative() throws Exception
	{
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
		assertEquals(false, undirectedGraph.isConnected());
		undirectedGraph.addEdge(0, 3, 1);
		undirectedGraph.addEdge(1, 3, 6);
		undirectedGraph.addEdge(1, 4, 9);
		undirectedGraph.addEdge(3, 4, 8);
		assertEquals(9, undirectedGraph.shotestPath(1, 4));
		
	}
}
