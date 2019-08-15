package graph;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		try 
		{
			Scanner input = new Scanner(System.in);
			UndirectedGraph undirectedGraph;
			List<Integer> reachableNodes = new ArrayList<Integer>();
			int capacity, source, destination, weight, choice;
			List<Node> mst = new ArrayList<>();;
			System.out.println("Enter number of vertex in graph");
			capacity = input.nextInt();
			undirectedGraph = new UndirectedGraph(capacity);
			while (true) 
			{
				System.out.println("Enter 1 for add edges in graph");
				System.out.println("Enter 2 to check connected graph");
				System.out.println("Enter 3 to get reachable nodes");
				System.out.println("Enter 4 to get mst");
				System.out.println("Enter 5 to get shortest path");
				System.out.println("Enter 6 for Exit");
				choice = input.nextInt();
				switch (choice) 
				{
				case 1:
					System.out.println("Enter source");
					source = input.nextInt();
					System.out.println("Enter destination");
					destination = input.nextInt();
					System.out.println("Enter weight");
					weight = input.nextInt();
					undirectedGraph.addEdge(source, destination, weight);
					break;
				case 2:
					if (undirectedGraph.isConnected()) 
					{
						System.out.println("graph is connected");
					} 
					else 
					{
						System.out.println("graph is not  connected");
					}
					break;
				case 3:
					System.out.println("Enter source node to get reachable nodes");
					int node = input.nextInt();
					reachableNodes = undirectedGraph.reachable(node);
					System.out.println("reachable nodes are");
					for (int reach : reachableNodes) 
					{
						System.out.print(reach + " ");
					}
					break;
				case 4:
					mst = undirectedGraph.mst();
					System.out.println("mst is");
					for (int index = 0; index < mst.size(); index++) 
					{
						System.out.println(mst.get(index).getVertex() + " ----- " + mst.get(index).getDestination());
					}
					break;
				case 5:
					System.out.println("Enter source for shortest path");
					source = input.nextInt();
					System.out.println("Enter destination for shortest path");
					destination = input.nextInt();
					System.out.println("shortest path is   " + undirectedGraph.shotestPath(source, destination));
					break;
				case 6:
					System.out.println("program exited....");
					System.exit(0);
				default:
					System.out.println("enter valid choice...");
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			main(args);
		}
	}
}
