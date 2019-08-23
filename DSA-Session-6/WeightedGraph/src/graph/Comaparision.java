package graph;
import java.util.*;
public class Comaparision implements Comparator<Node>  {
	   @Override
       public int compare(Node node0, Node node1) 
       { 
           return node0.getWeight() - node1.getWeight(); 
       } 
}