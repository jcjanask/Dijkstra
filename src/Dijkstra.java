/** Name: Dijkstra
 * Author: Joe Janaskie 2020
 * Description: Responsible for finding the shortest path
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {
	public static int totalCost = 0;
	
	//Method to find the shortest path from one destination to another.
	public static Queue<Edge> findShortestPath(Graph graph, String startVertexName, String endVertexName) {
		
		Queue<Path> paths = new PriorityQueue<Path>();
		Vertex startVertex = graph.getVertex(startVertexName);
		Vertex endVertex = graph.getVertex(endVertexName);
		Set<Edge> visited = new HashSet<Edge>();
		
		if(startVertex == null || endVertex == null) return new LinkedList<Edge>();
		paths.add(new Path(new Edge(startVertex, startVertex, 0)));
		
		while (!paths.isEmpty()) {
			Path currentPath = paths.remove();
	
			if (currentPath.getEndVertex().equals(endVertex)) {
				totalCost = currentPath.getTotalCost();
				return currentPath.toList();
			}
			Edge last = currentPath.getLastEdge();
			
			visited.add( graph.getEdge(last.fromVertex.name, last.toVertex.name));
			visited.add( graph.getEdge(last.toVertex.name, last.fromVertex.name));
			
			ArrayList<Edge> poss = graph.getEdges(currentPath.getEndVertex());
			
			for (Edge e : poss) {
				if (!visited.contains(e)) {
					Path tmp = currentPath.clone(); //Creates a clone of currentPath
					tmp.addEdge(e); //Add next edge
					paths.add(tmp); 
				}
			}
			
		}
		return new LinkedList<Edge>();
	}
	
}













