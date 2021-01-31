import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;


public class Main {

	static int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
    
		int n;
		while ((n = sc.nextInt()) > 0 ) {
			int count = 0;
			int sum = 0;
			int pd, pm, py, pc;
			pd = pc = pm = py = 0;
			while (n-- > 0) {
				int cd, cm, cy, cc;
				cd = sc.nextInt();
				cm = sc.nextInt();
				cy = sc.nextInt();
				cc = sc.nextInt();
				if (oneday(cd, cm, cy, cc, pd, pm, py, pc)) {
					count++;
					sum += cc - pc;
				}
				pd = cd;
				pm = cm;
				py = cy;
				pc = cc;
			}
			out.println(count + " " + sum);
		}
		out.flush();
	}

	public static boolean oneday(int cd, int cm, int cy, int cc, int pd, int pm, int py, int pc) {
		if (--cd == 0) {
			if (--cm == 0) {
				cm = 12;
				cy--;
			}

			boolean isleap = ((cy % 4 == 0 && cy % 100 != 0) || cy % 400 == 0);

			cd = days[cm - 1];
			if (isleap && cm == 2)
				cd = 29;

		}

		return (cd == pd && cm == pm && cy == py);
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
