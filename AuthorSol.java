import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

- index of chosen > index of previously chosen (except the 1st)
- no consecutive students belong to the same row
- the total height should be maximum


5
9 3 5 7 3
5 8 1 4 5

3
1 2 9
10 1 1

6
3 7 9 7 2 8 
2 4 8 4 7 9

 */

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[][] arr = new int[2][n];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = fs.nextInt();
				}
			}
			Pair p = new Pair(0, 0);
			for (int i = 0; i < n; i++) {
//				System.out.println(p.top + " " +  (p.bottom + arr[0][i]));
//				System.out.println(p.bottom + " " +  (p.top + arr[1][i]));
				
				p = new Pair(Math.max(p.top, p.bottom + arr[0][i]), 
							 Math.max(p.bottom, p.top + arr[1][i]));
				
//				System.out.println();
			}
			out.println(Math.max(p.top, p.bottom));
		}
		out.close();
	}
	
	static class Pair {
		long top, bottom;
		
		Pair(long top, long bottom) {
			this.top = top;
			this.bottom = bottom;
		}
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
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
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
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
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
