/** Name: Vertex
 * Author: Joe Janaskie 2020
 * Description: Creates vertex from file, only one endpoint
 */
public class Vertex {
	//==================================Properties=========================================
	public String name;
	//==================================Constructor=========================================
	public Vertex(String name) {
		this.name = name;
	}
	//==================================Methods=========================================
	public String toString() {
		return name;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Vertex)) return false;
		Vertex ver = (Vertex)o;
		return name.equals(ver.name);
	}


}
