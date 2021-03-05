import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String str;
		while ((str = br.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			int sj = str.charAt(0) - 'a' + 1;
			int si = str.charAt(1) - '0';

			int dj = str.charAt(3) - 'a' + 1;
			int di = str.charAt(4) - '0';
			Queue<cell>queue = new LinkedList<>();
			boolean [][] visited = new boolean[9][9];
			visited[si][sj] = true;
			queue.offer(new cell(si, sj, 0));

			int [] dx = { -1, 1, 2, 2, -1, 1, -2, -2};
			int [] dy = {2, 2, -1, 1, -2, -2, -1, 1};

			while (!queue.isEmpty()) {
				cell c = queue.poll();
				if (di == c.i && dj == c.j) {
					out.println("To get from " + tokenizer.nextToken() + " to " + tokenizer.nextToken() + " takes " + c.dis + " knight moves.");
					break;
				}

				for (int i = 0; i < 8; i++) {
					if (isValid(c.i + dx[i], c.j + dy[i], visited)) {
						visited[c.i + dx[i]][c.j + dy[i]] = true;
						queue.offer(new cell(c.i + dx[i], c.j + dy[i], c.dis + 1));
					}
				}
			}
		}
		out.close();
	}

	public static boolean isValid(int i, int j, boolean [][] visited) {
		if (i < 1 || j < 1 || i > 8 || j > 8 || visited[i][j])
			return false;

		return true;
	}

}

class cell {
	int i, j, dis;
	cell(int i, int j, int dis) {
		this.i = i;
		this.j = j;
		this.dis = dis;
	}
}
