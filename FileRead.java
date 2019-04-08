import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {

	public FileRead() {
		// TODO Auto-generated constructor stub

	}

	public static Graph readTopo(String fileName) {
		Graph network = new Graph();
		Scanner scan;
		String line = "";
		String[] splitArray;
		// vertex which will given beginning of the line
		Vertex mainVertex;
		try {
			scan = new Scanner(new File(fileName));
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				splitArray = line.split("[^\\w']+");
				String vertexLabel = splitArray[0];
				String switchLabel = splitArray[splitArray.length - 1];
				// if this vertex is not created yet
				if (!network.isVertexAvailable(vertexLabel)) {
					mainVertex = new Vertex(vertexLabel);
					network.addVertex(mainVertex);
				}

				else {
					// mainVertex=Vertex.getVertex(vertexLabel);
					mainVertex = network.getVertex(vertexLabel);
				}

				for (int j = 1; j < splitArray.length - 1; j++) {
					// the vertext given in the line except the beginning
					Vertex vertexForEdge = null;
					if (!network.isVertexAvailable(splitArray[j])) {
						vertexForEdge = new Vertex(splitArray[j]);
						network.addVertex(vertexForEdge);
					}

					else {
						vertexForEdge = network.getVertex(splitArray[j]);

					}
					network.getVertex(mainVertex.getLabel()).getEdges().put(vertexForEdge.getLabel(),
							new Edge(mainVertex, vertexForEdge));
					network.getVertex(vertexForEdge.getLabel()).getEdges().put(mainVertex.getLabel(),
							new Edge(vertexForEdge, mainVertex));
				}

				network.getVertex(mainVertex.getLabel()).getEdges().get(switchLabel).setSwitch(true);
				network.getVertex(switchLabel).getEdges().get(mainVertex.getLabel()).setSwitch(true);

			}

			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return network;
	}

	public static void readDistanceFile(String fileName, Graph network) {
		Scanner scan;
		String line = "";
		String[] splitArray;
		String sourceLabel = "";
		String destLabel = "";

		int weight = -1;

		try {
			scan = new Scanner(new File(fileName));
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				splitArray = line.split("-|\\s");
				sourceLabel = splitArray[0];
				destLabel = splitArray[1];
				weight = Integer.parseInt(splitArray[2]);
				network.getVertex(sourceLabel).getEdges().get(destLabel).setWeight(weight);
				network.getVertex(destLabel).getEdges().get(sourceLabel).setWeight(weight);

			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void readCommands(String filename, Graph network) {
		Scanner scan;
		String line = "";
		String[] splitArray;
		String command = "";
		String sourceLabel = "";
		String destLabel = "";
		String velocity = "";
		String station = "";
		String[] link = new String[20];
		try {
			scan = new Scanner(new File(filename));
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				splitArray = line.split("-|\\>|\\,|\\s");
				command = splitArray[0];
				if (command.equals("ROUTE") || command.equals("BREAK") || command.equals("REPAIR")) {
					sourceLabel = splitArray[1];
					destLabel = splitArray[2];
				}

				if (command.equals("ROUTE")) {
					velocity = splitArray[3];
				}
				if (command.equals("MAINTAIN") || command.equals("SERVICE") || command.equals("ADD")
						|| command.equals("LISTROUTESFROM")) {
					station = splitArray[1];
				}
				if (command.equals("LINK")) {
					for (int i = 1; i < splitArray.length; i++) {
						link[i - 1] = splitArray[i];
					}
				}

				if (command.equals("MAINTAIN")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.maintain(station);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("SERVICE")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.service(station);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("BREAK")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.breakRoad(sourceLabel, destLabel);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("REPAIR")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.repair(sourceLabel, destLabel);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("ADD")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.add(station);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("LINK")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.link(link);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("ROUTE")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.route(sourceLabel, destLabel, velocity);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("LISTROUTESFROM")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.listroutesfrom(station);
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("LISTMAINTAINS")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.listMaintains();
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("LISTACTIVERAILS")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.listActiveRails();
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("LISTBROKENRAILS")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.listBrokenRails();
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("LISTCROSSTIMES")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.listCrossTimes();
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("TOTALNUMBEROFJUNCTIONS")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.totalNumberofJunctions();
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else if (command.equals("TOTALNUMBEROFRAILS")) {
					System.out.println("COMMAND IN PROCESS >> " + line);
					network.totalNumberofRails();
					System.out.println("	Command \"" + line + "\" has been executed successfully!");

				} else {
					System.out.println("COMMAND IN PROCESS >> " + line);
					System.out.println("	Unrecognized command "+ "\"" + line + "\"!");
				}

			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
