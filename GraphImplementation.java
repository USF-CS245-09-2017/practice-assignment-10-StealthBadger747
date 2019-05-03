import java.util.*;

public class GraphImplementation implements Graph {

	private int[][] adjMatrix;

	public GraphImplementation(int vertices) {
		adjMatrix = new int[vertices][vertices];
	}

	public int[] neighbors(int vert) {
		int count = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[vert][i] == 1) {
				count++;
			}
		}

		int[] arr = new int[count];
		int ticker = 0;

		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[vert][i] == 1) {
				arr[ticker++] = i;
			}
		}
		return arr;
	}


	public void addEdge(int s, int t) { adjMatrix[s][t] = 1; }

	public List <Integer> topologicalSort(){
		int len = adjMatrix.length;
		int[] nIncident = new int [len];
		List<Integer> TopologicalOrder = new ArrayList<Integer>(); 

		for (int i = 0; i < len; i++) {
		 	nIncident[i] = 0; 
		}

		for (int i = 0; i < len; i++) {
		 	for (int j = 0; j < len; j++) {
		 		if (adjMatrix[j][i] == 1) {
		 			nIncident[i]++; 
		 		}
		 	}
		}

		for(int k = 0; k < len;k++) {
			for (int i = 0; i < len; i++){
				if (nIncident[i] == 0){
					TopologicalOrder.add(i);
					nIncident[i] = -1; 
					int[] temp = neighbors(i);

					for (int j = 0; j < temp.length;j++) {
						nIncident[temp[j]]--; 
					}
					break;
				}
		 
			}
		}
		return TopologicalOrder;
	}
}