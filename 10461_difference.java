import java.util.*;
import java.io.*;


public class A {

	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int v = 0, e = 0;
		int temp = 0;
		while ((v = sc.nextInt()) != 0 && (e = sc.nextInt()) != 0) {
			temp++;
			int []days = new int[v + 1];
			int total = 0;
			for (int i = 1; i <= v; i++) {
				days[i] = sc.nextInt();
				total += days[i];
			}

			int [][] xtoy = new int[v + 1][v + 1];
			int [][] ytox = new int[v + 1][v + 1];
			while (e-- > 0) {
				int x = sc.nextInt(), y = sc.nextInt();
				xtoy[x][y] = 1;
				ytox[y][x] = 1;
			}

			int q = sc.nextInt();
			out.println("Case #" + temp + ":");
			while (q-- > 0) {
				int job = sc.nextInt();
				Queue<Integer>queue1 = new LinkedList<>();
				queue1.offer(job);
				HashSet<Integer>set1 = new HashSet<>();
				int mintime = 0;
				while (!queue1.isEmpty()) {
					int j = queue1.poll();
					mintime += days[j];
					for (int i = 1; i <= v; i++) {
						if (ytox[j][i] == 1 && !set1.contains(i)) {
							queue1.offer(i);
							set1.add(i);
						}
					}
				}

				int maxtime = total + days[job];
				Queue<Integer>queue2 = new LinkedList<>();
				queue2.offer(job);
				HashSet<Integer>set2 = new HashSet<>();
				while (!queue2.isEmpty()) {
					int j = queue2.poll();
					maxtime -= days[j];
					for (int i = 1; i <= v; i++) {
						if (xtoy[j][i] == 1 && !set2.contains(i)) {
							queue2.offer(i);
							set2.add(i);
						}
					}
				}
				out.println(maxtime - mintime);
			}
			out.println();
		}
		out.close();

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
