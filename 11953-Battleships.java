import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.Arrays;




public class Main {


	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		int c = 0;
		while (t-- > 0) {
			c++;
			int n = sc.nextInt();
			char [][] grid = new char[n][n];
			boolean [][] isVisited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				grid[i] = sc.next().toCharArray();
				Arrays.fill(isVisited[i], false);
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] != '.' && !isVisited[i][j])
						count += dfs(i, j, grid, isVisited, n);
				}
			}
			out.println("Case " + c + ": " + count);
		}
		out.flush();
	}

	public static int dfs(int i, int j, char[][] grid, boolean [][] isVisited, int n) {
		if (!isValid(i, j, grid, isVisited, n))
			return 0;

		int count = 0;
		isVisited[i][j] = true;
		if (grid[i][j] == 'x')
			count++;

		count += dfs(i, j - 1, grid, isVisited, n);
		count += dfs(i + 1, j, grid, isVisited, n);
		count += dfs(i, j + 1, grid, isVisited, n);
		count += dfs(i + 1, j, grid, isVisited, n);

		return count > 0 ? 1 : 0;
	}

	public static boolean isValid(int i, int j, char[][] grid, boolean [][] isVisited, int n) {
		if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == '.' || isVisited[i][j])
			return false;

		return true;
	}




}




class FastReader {

	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	int [] nextIntArray(int n) {
		int [] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();

		return arr;

	}


	long nextLong() {
		return Long.parseLong(next());
	}

	long [] nextLongArray(int n) {
		long [] arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextLong();

		return arr;

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

}
