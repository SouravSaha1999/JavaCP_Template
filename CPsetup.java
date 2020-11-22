import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		long[] readArrayLong(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
	}

	static int sumOfDigits(int n) {
		if (n == 0)
			return 0;
		return n % 10 + sumOfDigits(n / 10);
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static long fastPower(long a, long b, int n) {
	
		long res = 1;		
		while ( b > 0) {
			if ( (b&1) != 0) {
				res = (res * a % n) % n;
			}
			a = (a % n * a % n) % n;
			b =  b >> 1;
		}		
		return res;
	}

	static boolean[] seiveOfEratoSthenes(int n) {
		
		boolean isPrime[] = new boolean[n+1];
		
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i = 2; i * i <= n; i++) {
			
			
			for(int j = 2*i; j<=n; j += i) {
				isPrime[j] = false;
			}
			
		}
		
		return isPrime;
		
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int tc = fr.nextInt();
		while(tc-- != 0) {

			}
		}
	}	

class Graph{
	int V;
	LinkedList<Integer> adj[];
	
	Graph(int v){
		V=v;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList<>();
	}
	
	void addedge(int v , int u) {
		adj[v].add(u);
	}
	
	
	void bfs(int val) {
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		
		visited[val]=true;
		q.add(val);
		
		while(q.size()!=0) {
			val = q.poll();
			System.out.print(val+" ");
			Iterator<Integer> i = adj[val].listIterator();
			while(i.hasNext()) {
				int num = i.next();
				if(!visited[num]) {
					visited[num] = true;
					q.add(num);
				}
			}
		}
	}
	
	void dfs(int src) {
		boolean[] visited = new boolean[V];
		dfsUtil(src, visited);
	}
	
	void dfsUtil(int val , boolean[] visited) {
		visited[val]=true;
		System.out.print(val+" ");
		Iterator<Integer> i = adj[val].listIterator();
		while(i.hasNext()) {
			int num = i.next();
			if(!visited[num]) {
				dfsUtil(num, visited);
			}
		}
	}
	
	void dijkstra(int[][] graph , int src) {
		boolean[] sp = new boolean[V];
		int[] dist = new int[V];
		
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sp[i] = false;
		}
		
		dist[src]=0;
		
		for(int i=0; i<V-1; i++) {
			int u = minDist(dist,sp);
			sp[u]=true;
			for(int j=0; j<V; j++) {
				if(!sp[j] && graph[u][j]!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+graph[u][j])<dist[j]) {
					dist[j]=dist[u]+graph[u][j];
				}
			}
		}
//		printPath(dist);
	}
	
	int minDist(int[] dist , boolean[] sp) {
		int minIndex=-1;
		int min=Integer.MAX_VALUE;
		
		for(int i=0; i<V; i++) {
			if(!sp[i] && dist[i]<=min) {
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}