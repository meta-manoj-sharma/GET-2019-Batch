package graph;
import java.util.*;
/**
 * interface for the undirected graph 
 *
 */
public interface Graph {

	//method for find is connected graph
    public boolean isConnected();

    //method for find reachable vertices
    public List<Integer> reachable(int source);

    //method for find minimum spanning tree
    public List<Node> mst();
    public int[] mst();
    //method to find shortest path
    public int shotestPath(int source, int destiination);

}
