import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;


public class Main {

	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int []arr = sc.nextIntArray(n);
		int t = sc.nextInt();
		while (t-- > 0) {
			int luchu = sc.nextInt();

			int left = 0, right = n - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (arr[mid] >= luchu)
					right = mid - 1;

				else
					left = mid + 1;
			}

			out.print(right >= 0 ? arr[right] : "X");
			out.print(" ");

			left = 0; right = n - 1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (arr[mid] <= luchu)
					left = mid + 1;

				else
					right = mid - 1;
			}

			out.print(left >= n ? "X" : arr[left]);
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
