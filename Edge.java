import java.util.ArrayList;

public class Edge {

//	 private final String id;
	    private final Vertex source;
	    private final Vertex destination;
	    private int weight;
	    
	    private boolean isSwitch=false;
	    private boolean isBroken=false;
	    
	    public boolean isSwitch() {
			return isSwitch;
		}
		public void setSwitch(boolean isMakas) {
			this.isSwitch = isMakas;
		}
		public boolean isBroken() {
			return isBroken;
		}
		public void setYolBozuk(boolean isBroken) {
			this.isBroken = isBroken;
		}

		public static ArrayList<Edge> edgeList=new ArrayList<Edge>();

	    public void setWeight(int weight) {
			this.weight = weight;
		}
		public Edge(Vertex source, Vertex destination, int weight) {
	       
	        this.source = source;
	        this.destination = destination;
	        this.weight = weight;
	        edgeList.add(this);
	    }
	    public Edge(Vertex source, Vertex destination) {
	      
	        this.source = source;
	        this.destination = destination;	       
	        edgeList.add(this);
	    }


	    public Vertex getDestination() {
	        return destination;
	    }

	    public Vertex getSource() {
	        return source;
	    }
	    public int getWeight() {
	        return weight;
	    }

	    @Override
	    public String toString() {
	        return source + " " + destination;
	    }
	    
	    public static Edge getEdge(Vertex source, Vertex dest)
	    {
	    	for(Edge e:edgeList)
	    	{
	    		if(e.destination.equals(dest)&& e.source.equals(source))
	    		{
	    			return e;
	    		}
	    	}
	    	return null;
	    }

}
