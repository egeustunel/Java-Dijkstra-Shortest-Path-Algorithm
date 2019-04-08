
public class Assignment4 {

	public static void main(String[] args) {
		String topoFile=args[0];
		String distFile=args[1];
		String comFile=args[2];
		
		Graph network = FileRead.readTopo(topoFile);
		FileRead.readDistanceFile(distFile, network);
		//network.printGraph();
		FileRead.readCommands(comFile, network);
		
	}

}
