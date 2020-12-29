/** Name: Tester
 * Author: Joe Janaskie 2020
 * Description: Runs the shortest path
 */
public class Tester {
	public static void main(String[] args) {

		System.out.println(Dijkstra.findShortestPath(new Graph("trails.txt") , "AA", "NP").toString().replace(",","\n"));
		System.out.printf("Total Cost is %,d",Dijkstra.totalCost);
	}

}
