import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;



public class Main {

	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char [][] path = new char[n][m];
			boolean [][] isVisited = new boolean[n][m];
			int j = 0;
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				j = str.indexOf('@');
				path[i] = str.toCharArray();
				Arrays.fill(isVisited[i], false);
			}

			ArrayList<String> list = new ArrayList<>();
			dfs(n - 1, j, path, list, "", isVisited);
			for (int i = 1; i < list.size() - 1; i++) {
				out.print(list.get(i) + " ");
			}
			out.print(list.get(list.size() - 1));
			out.println();
			out.flush();
		}

	}


	public static void dfs(int i, int j, char[][] path, ArrayList<String>list, String move, boolean [][] isVisited) {

		if (!isValid(i, j, path, isVisited))
			return;

		isVisited[i][j] = true;

		if (path[i][j] == '#') {
			list.add(move);
			return;
		}

		list.add(move);
		dfs(i, j - 1, path, list, "left", isVisited);
		dfs(i - 1, j , path, list, "forth", isVisited);
		dfs(i, j + 1, path, list, "right", isVisited);
	}

	public static boolean isValid(int i, int j, char[][] path, boolean [][] isVisited) {
		String match = "IEHOVA@#";
		int n = path.length;
		int m = path[0].length;
		if (i < 0 || i >= n || j < 0 || j >= m || match.indexOf(path[i][j]) < 0 || isVisited[i][j])
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
