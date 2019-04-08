import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Vertex {

	public static ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	private List<Vertex> shortestPath = new LinkedList<>();
	private String label;
	private int distance = Integer.MAX_VALUE;
	boolean isMaintenance;
	int totalTrain = 0;
	private HashMap<String, Edge> Edges = new HashMap<String, Edge>();

	

	public List<Vertex> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Vertex> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public HashMap<String, Edge> getEdges() {
		return Edges;
	}

	public void setEdges(HashMap<String, Edge> edges) {
		Edges = edges;
	}

	public static ArrayList<Vertex> getVertexList() {
		return vertexList;
	}

	public static void setVertexList(ArrayList<Vertex> vertexList) {
		Vertex.vertexList = vertexList;
	}

	public Vertex(String label) {
		this.label = label;
		vertexList.add(this);

	}

	public String getLabel() {
		return label;
	}

	public static boolean isVertexAvailable(String label) {
		boolean available = false;
		for (Vertex v : vertexList) {
			if (v.label.equals(label)) {
				available = true;
				break;
			}
		}
		return available;
	}

	public static Vertex getVertex(String label) {
		Vertex vert = null;
		for (Vertex v : vertexList) {
			if (v.label.equals(label)) {
				vert = v;
				break;
			}
		}
		return vert;

	}

	public boolean equals(Vertex v) {

		if (this.label.equals(v.label))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return label;
	}

}
