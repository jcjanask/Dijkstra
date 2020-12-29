/** Name: GraphInterface
 * Author: Joe Janaskie 2020
 */
import java.util.ArrayList;
import java.util.Set;

public interface GraphInterface {
	public boolean		addVertex(Vertex vertex);
	public boolean		removeVertex(Vertex vertex);
	public boolean		addEdge(Vertex vertex1, Vertex vertex2, int cost);
	public Vertex		getVertex(String name);
	public boolean		removeEdge(Vertex vertex1, Vertex vertex2);
	public boolean		hasEdge(Vertex vertex1, Vertex vertex2);
	public boolean		hasVertex(Vertex vertex);
	public boolean		isEmpty();
	public int			vertexCount();
	public int			edgeCount();
	public String		toString();
	public Set			getVertices();
	public ArrayList	getEdges();
	public ArrayList	getEdges(Vertex vertex);
	public Edge 		getEdge(String fromVertexName, String toVertexName);
	
}