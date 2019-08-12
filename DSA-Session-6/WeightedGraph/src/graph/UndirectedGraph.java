package graph;

import java.util.*;

public class UndirectedGraph implements Graph {

	private int noOfVertices;
	private LinkedList<Node> adjacentList[];

	// constructor
	public UndirectedGraph(int vertices) throws Exception {
		if (vertices <= 0) {
			throw new Exception("Number of vertices can't be null or negative");
		}
		this.noOfVertices = vertices;
		adjacentList = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adjacentList[i] = new LinkedList<Node>();
	}

	/**
	 * method to add an edge in graph 
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination, int weight) throws Exception {
		if (source < 0 || source >= noOfVertices || destination < 0 || destination >= noOfVertices || weight < 0) {
			throw new Exception("Invalid values");
		}
		// node to add link from source to destination
		Node nodeSource = new Node(destination, weight);
		adjacentList[source].add(nodeSource);
		// node to add link from destination to source
		Node nodeDest = new Node(source, weight);
		adjacentList[destination].add(nodeDest);
	}

	/**
	 * method to know that graph is connected or not
	 * @return true if connected
	 */
	@Override
	public boolean isConnected() {
		// if vertex is connected index is true
		boolean[] visited = new boolean[noOfVertices];
		findConnected(0, visited);
		for (boolean visit : visited) {
			if (!visit) {
				return false;
			}
		}
		return true;
	}

	private void findConnected(int index, boolean[] visited) {
		visited[index] = true;
		for (Node neighbour : adjacentList[index]) {
			if (!visited[neighbour.getVertex()])
				findConnected(neighbour.getVertex(), visited);
		}
	}

	/**
	 * method to get reachable vertices
	 * @return list of vertices
	 */
	@Override
	public List<Integer> reachable(int source) {
		List<Integer> reachableNodes = new ArrayList<Integer>();
		boolean[] visited = new boolean[noOfVertices];
		if (source < 0 || source >= noOfVertices)
			throw new AssertionError("Enter valid startIndex");
		findConnected(source, visited);
		for (int i = 0; i < noOfVertices; ++i)
			if (visited[i] == true)
				reachableNodes.add(i);
		return reachableNodes;
	}

	/**
	 * method to return minimum spanning tree
	 */
	@Override
	public int[] mst() {

		Boolean[] visited = new Boolean[this.noOfVertices];
		Node[] nodeList = new Node[this.noOfVertices];
		int[] parent = new int[this.noOfVertices];
		PriorityQueue<Node> queue = new PriorityQueue<>(this.noOfVertices, new Comaparision());

		for (int i = 0; i < this.noOfVertices; i++) {
			visited[i] = false;
			nodeList[i] = new Node();
			nodeList[i].setWeight(Integer.MAX_VALUE);
			nodeList[i].setVertex(i);
			parent[i] = -1;
		}
		nodeList[0].setWeight(0);

		for (int i = 0; i < this.noOfVertices; i++)
			queue.add(nodeList[i]);

		// Loops until the PriorityQueue is not empty
		while (!queue.isEmpty()) {
			// Extracts a node with min weight value
			Node node0 = queue.poll();
			// Include that node into mstset
			visited[node0.getVertex()] = true;

			// For all adjacent vertex of the extracted vertex V
			for (Node node : this.adjacentList[node0.getVertex()]) {
				// If Vertex is in PriorityQueue
				if (visited[node.getVertex()] == false) {
					// If the key value of the adjacent vertex is more than the
					// extracted key
					// update the key value of adjacent vertex to update first
					// remove and add the updated vertex
					if (nodeList[node.getVertex()].getWeight() > node.getWeight()) {
						queue.remove(nodeList[node.getVertex()]);
						nodeList[node.getVertex()].setWeight(node.getWeight());
						queue.add(nodeList[node.getVertex()]);
						parent[node.getVertex()] = node0.getVertex();
					}
				}
			}
		}
		return parent;
	}

	/**
	 * method to find the shortest path
	 * 
	 * @param source
	 * @param destination
	 */
	@Override
	public int shotestPath(int source, int destination) {
		if (source < 0 || source >= this.noOfVertices || destination < 0 || destination >= this.noOfVertices)
			throw new AssertionError("Please enter correct input");

		// distance[i] will hold the shortest distance from src to i
		int distance[] = new int[this.noOfVertices];
		// shortestPath[i] will true if vertex i is included in shortest path
		boolean shortestPath[] = new boolean[this.noOfVertices];

		// Initialise all distances as INFINITE
		for (int i = 0; i < this.noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		// Distance of source vertex from itself is always 0
		distance[source] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < this.noOfVertices - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices not yet processed.
			// minDistanceVertex is always equal to src in first iteration.
			int minDistanceVertex = getMinKeyVertex(distance, shortestPath);

			// Mark the picked vertex as processed
			shortestPath[minDistanceVertex] = true;

			// Update distance value of the adjacent vertices of the picked vertex.
			for (Node edge : adjacentList[minDistanceVertex]) {
				int vertex = edge.getVertex();
				// Update distance[v] only if is not in shortestPath, there is an edge from u to
				// v, and
				// total weight of path from src to v through u is smaller than current value of
				// distance[v]
				if (!shortestPath[vertex] && distance[minDistanceVertex] != Integer.MAX_VALUE
						&& distance[minDistanceVertex] + edge.getWeight() < distance[vertex]) {
					distance[vertex] = distance[minDistanceVertex] + edge.getWeight();
				}
			}
		}
		return distance[destination];
	}

	private int getMinKeyVertex(int key[], boolean mstSet[]) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < this.noOfVertices; i++)
			if (mstSet[i] == false && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		return minIndex;
	}
}