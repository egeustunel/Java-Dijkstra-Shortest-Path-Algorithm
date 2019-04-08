import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private List<Vertex> vertexes;
	private List<Edge> edges;
	private HashMap<String, Vertex> digraph = new HashMap<String, Vertex>();

	public Graph() {

	}

	public void printGraph() {
		for (String string : digraph.keySet()) {
			for (String edge : digraph.get(string).getEdges().keySet()) {
				System.out.println(digraph.get(string).getEdges().get(edge) + " "
						+ digraph.get(string).getEdges().get(edge).getWeight());
			}
		}
	}

	public void addVertex(Vertex v) {
		this.digraph.put(v.getLabel(), v);
	}

	public Vertex getVertex(String label) {
		return this.digraph.get(label);
	}

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public boolean isVertexAvailable(String label) {
		boolean available = false;
		if (digraph.containsKey(label)) {
			available = true;
		}
		return available;
	}

	public void maintain(String station) {

		digraph.get(station).isMaintenance = true;

	}

	public void service(String station) {

		digraph.get(station).isMaintenance = false;

	}

	public void breakRoad(String source, String destination) {

		digraph.get(source).getEdges().get(destination).setYolBozuk(true);

	}

	public void repair(String source, String destination) {
		digraph.get(source).getEdges().get(destination).setYolBozuk(false);
	}

	public void add(String station) {

		Vertex mainVertex = new Vertex(station);
		digraph.put(station, mainVertex);

	}

	public void link(String[] link) {
		String switchLabel = link[link.length - 1];

		for (int i = 1; i < link.length - 2; i += 2) {
			digraph.get(link[0]).getEdges().put(digraph.get(link[i]).getLabel(),
					new Edge(digraph.get(link[i]), digraph.get(link[0])));
			digraph.get(link[i]).getEdges().put(digraph.get(link[0]).getLabel(),
					new Edge(digraph.get(link[0]), digraph.get(link[i])));

			digraph.get(link[0]).getEdges().get(link[i]).setWeight(Integer.parseInt(link[i + 1]));
			digraph.get(link[i]).getEdges().get(link[0]).setWeight(Integer.parseInt(link[i + 1]));

		}
		digraph.get(link[0]).getEdges().get(switchLabel).setSwitch(true);
		digraph.get(switchLabel).getEdges().get(link[0]).setSwitch(true);

	}

	public void route(String source, String destination, String velocity) {
		for (Map.Entry<String, Edge> edge : digraph.get(source).getEdges().entrySet()) {
			System.out.println("a");
		}
	}

//	private static Vertex getLowestDistanceNode(Set<Vertex> unsettledNodes) {
//		Vertex lowestDistanceNode = null;
//		int lowestDistance = Integer.MAX_VALUE;
//		for (Vertex node : unsettledNodes) {
//			int nodeDistance = node.getDistance();
//			if (nodeDistance < lowestDistance) {
//				lowestDistance = nodeDistance;
//				lowestDistanceNode = node;
//			}
//		}
//		return lowestDistanceNode;
//	}

//	private static void CalculateMinimumDistance(Vertex evaluationNode, Integer edgeWeigh, Vertex sourceNode) {
//		Integer sourceDistance = sourceNode.getDistance();
//		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
//			evaluationNode.setDistance(sourceDistance + edgeWeigh);
//			LinkedList<Vertex> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
//			shortestPath.add(sourceNode);
//			evaluationNode.setShortestPath(shortestPath);
//		}
//	}

	public void listroutesfrom(String station) {

	}

	public void listMaintains() {

	}

	public void listActiveRails() {

	}

	public void listBrokenRails() {

	}

	public void listCrossTimes() {

	}

	public void totalNumberofJunctions() {

	}

	public void totalNumberofRails() {

	}

}
