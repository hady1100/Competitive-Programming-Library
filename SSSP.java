import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SSSP {
	
	static ArrayList<Pair> adjList[];
	static boolean visited[];
	static int V;
	static int INF = (int) 1e9;
	
	
	public static int dijkstra(int S, int T){
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(S, 0));
		
		while(!pq.isEmpty()){
			
			Pair cur = pq.remove();
			
			if(cur.node == T)
				return cur.cost;
			
			if(cur.cost > dist[cur.node])			//lazy deletion
				continue;
			
			for(Pair nxt: adjList[cur.node]){
				if(cur.cost + nxt.cost <= dist[nxt.node])
				{
					dist[nxt.node] = cur.cost + nxt.cost;
					pq.add(new Pair(nxt.node, dist[nxt.node]));
				}
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			V = n;
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int cost = sc.nextInt();
				
				adjList[u].add(new Pair(v, cost));
//				adjList[v].add(u);
			}
		}
		
	}
	static class Pair implements Comparable<Pair>{

		int node, cost;
		
		public Pair(int t, int c){
			node = t;
			cost = c;
		}

		@Override
		public int compareTo(Pair P) {
			// TODO Auto-generated method stub
			return P.cost-cost;
		}
		
	}
}
