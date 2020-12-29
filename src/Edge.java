/** Name: 
 * Author: Joe Janaskie 2020
 *
 */
public class Edge {


	public Vertex fromVertex;
	public Vertex toVertex;
	public int cost;

	public Edge(Vertex fromVertex, Vertex toVertex, int cost) {
		super();
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.cost = cost;
	}

	public String toString() {
		return fromVertex.toString() + "-" + toVertex.toString() + ":" + cost;
	}



}
