/** Name: Graph
 * Author: Joe Janaskie 2020
 * Description: Responsible for reading from file that contains all possible edges and adding all distinct vertices
 */
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Graph implements GraphInterface {

	//====================================================================================== Properties
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private Set<Vertex> vertices;
	
	
	//====================================================================================== Constructors
	public Graph(String fileName) {
		vertices = new HashSet<Vertex>();	
		try(Scanner fin = new Scanner(new File(fileName))){
			boolean isDirected = Boolean.parseBoolean(fin.nextLine());
			
			// Now read the single line of all possible vertex entries
			String[] parts = fin.nextLine().split("\t");
			for(String s : parts) {
				Vertex v = new Vertex(s);
				vertices.add(v);
			}
		
			
			// Now read in all other lines... all paths with cost
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				Vertex vertex = getVertex(parts[0]);
				Vertex vertex2 = getVertex(parts[1]);
				int cost = Integer.parseInt(parts[2]);
				if(!(vertex == null || vertex2 == null)) {
					addEdge(vertex, vertex2, cost);
					if(!isDirected) addEdge(vertex2, vertex, cost);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	//====================================================================================== Methods
	@Override
	public boolean addVertex(Vertex vertex) {
		if(vertex == null) return false;
		return vertices.add(vertex); //Adds vertex to set of vertices
	}

	@Override
	public boolean removeVertex(Vertex vertex) {
		if(vertex == null) return false;
		return vertices.remove(vertex); //Removes vertex from set of vertices
	}

	@Override //Creates edge with two vertices
	public boolean addEdge(Vertex vertex1, Vertex vertex2, int cost) {
		if(vertex1 == null || vertex2 == null || vertex1.equals(vertex2)) return false;
		Edge edge = new Edge(vertex1, vertex2, cost); 
		edges.add(edge);
		return true;
	}

	@Override //Returns vertex using parameter passed in
	public Vertex getVertex(String name) {
		for(Vertex v : vertices)
			if(v.name.equals(name)) return v;
		return null;
	}

	@Override //Removes edge from ArrayList of Edges
	public boolean removeEdge(Vertex vertex1, Vertex vertex2) {
		if(vertex1 == null || vertex2 == null) return false;
		if (hasEdge(vertex1, vertex2))   edges.remove(vertex1);   return true; //could be problem
	}

	@Override //Checks to see if edge exists
	public boolean hasEdge(Vertex vertex1, Vertex vertex2) {
		if(vertex1 == null || vertex2 == null) return false;
		return (edges.contains(vertex2) || edges.contains(vertex1)); //could be problem
	}

	@Override //Checks to see if specific vertex exists
	public boolean hasVertex(Vertex vertex) {
		if(vertex == null) return false;
		return vertices.contains(vertex);
	}

	@Override //Checks to see if any vertex exists
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	@Override //Returns number of vertices in the file read from
	public int vertexCount() {
		return vertices.size();
	}

	@Override //Returns number of edges in the file read from
	public int edgeCount() {
		return edges.size();
	}


	@Override //Returns a set of all vertices in the file read from
	public Set getVertices() {
		return vertices;
	}

	@Override //Returns list of edges
	public ArrayList getEdges() {
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
		for (Edge e: edges) {
			listOfEdges.add(e);
		}
		return listOfEdges;
	}

	@Override //Returns a list of edges that contain the passed in vertex as a starting vertex
	public ArrayList getEdges(Vertex vertex) {
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
		for (Edge e: edges) {
			if (e.fromVertex.equals(vertex))
			listOfEdges.add(e);
		}
		return listOfEdges;
	}

	@Override //Returns edge using two string of start vertex and final vertex
	public Edge getEdge(String fromVertexName, String toVertexName) {
	for (Edge e : edges) {
		if (e.fromVertex.name.equals(fromVertexName) && e.toVertex.name.equals(toVertexName)) 
			return e;
	}
	return null;
	}
	
	public String toString() {
		return edges.toString();
	}

}
