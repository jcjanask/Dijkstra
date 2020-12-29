/** Name: Path
 *  Author: Joe Janaskie 2020
 *  Description: Creates a comparable path of edges
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Path implements Comparable<Path> {
		//==================================Properties=========================================
		private int totalCost;
		private ArrayList<Edge> edges;
		//==================================Constructors=========================================
		public Path() {
			super();
			edges = new ArrayList<Edge>();
		}
		
		public Path(Edge e) {
			this();
			addEdge(e);
		}
		//==================================Methods=========================================
		//Adds edge to ArrayList of Edges
		public void addEdge(Edge e) {
			edges.add(e);
			totalCost += e.cost;
		}
		
		@Override
		public int compareTo(Path o) {
			return totalCost - o.totalCost;	//Compare paths by total cost.		
		}
		//Returns first vertex in path (where the path starts)
		public Vertex getStartVertex() {
			return edges.get(0).fromVertex;
		}
		//Returns last vertex in path (final destination)
		public Vertex getEndVertex() {
			return edges.get(edges.size()-1).toVertex;
		}
		//Make a copy of the Path
		public Path clone() {
			Path ret = new Path();
			ret.edges = (ArrayList<Edge>) edges.clone();
			ret.totalCost = getTotalCost();
			return ret;
		}
		//Returns last edge in list of edges
		public Edge getLastEdge() {
			return edges.get(edges.size()-1);
		}
		//Returns last edge but in reverse (destinationVertex to startVertex)
		public Edge getLastEdgeRev() {
			Edge ret = edges.get(edges.size()-1);
			return new Edge(ret.toVertex, ret.fromVertex, ret.cost);
		}
		//Returns linked list of edges in the path
		public LinkedList<Edge> toList() {
			LinkedList<Edge> ret = new LinkedList<Edge>(edges);
			ret.remove();
			return ret;
		}
		//Returns total cost of path
		public int getTotalCost() {
			return totalCost;
		}
}
