import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P16173 {

    static int     N;
    static int[][] MAP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                dfs(row, col);
            }
        }
    }

    static void dfs(int row, int col) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(row, col));

        while (!stack.isEmpty()) {
            Point point = stack.pop();
            int now_row = point.row;
            int now_col = point.col;
            int move = MAP[now_row][now_col];
            int next_row = now_row + move;
            int next_col = now_col + move;

            if (next_row > N && next_col > N) {
                continue;
            }
            if (next_row == N - 1 && next_col == N - 1) {
                System.out.print("HaruHaru");
            }
            if (next_row < N && next_col < N) {
                dfs(next_row, next_col);
            }
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
