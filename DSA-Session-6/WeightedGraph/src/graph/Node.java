package graph;

public class Node {

	private int vertex;
	private int weight;
	private int destination;

	public Node(int vertex, int weight, int destination) {
		this.vertex = vertex;
		this.weight = weight;
		this.destination = destination;
	}

	public Node() {
		super();
	}

	// getter Setter Methods
	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
public class Node {

    private int vertex;
    private int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    public Node() {
        super();
    }

    //getter Setter Methods
    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
