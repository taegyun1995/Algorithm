import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P16173_v3 {

    static int         N;
    static int[][]     MAP;
    static boolean[][] VISITED;
    static boolean     IS_ARRIVE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        VISITED = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (IS_ARRIVE) {
            System.out.print("HaruHaru");
        } else {
            System.out.print("Hing");
        }
    }

    static void dfs(int row, int col) {
        Stack<Jelly> stack = new Stack<>();
        stack.push(new Jelly(row, col));
        VISITED[row][col] = true;

        while (!stack.isEmpty()) {
            Jelly jelly = stack.pop();
            int now_row = jelly.row;
            int now_col = jelly.col;

            int move = MAP[now_row][now_col];
            if (move == -1) {
                IS_ARRIVE = true;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next_row = now_row + move;
                int next_col = now_col + move;

                if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < N && !VISITED[next_row][next_col]) {
                    stack.push(new Jelly(next_row, next_col));
                    VISITED[next_row][next_col] = true;
                }
            }
        }

    }

    static class Jelly {
        int row;
        int col;

        public Jelly(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
