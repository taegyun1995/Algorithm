import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P16173_v5 {

    static int         N;
    static int[][]     MAP;
    static boolean[][] VISITED;
    static boolean     IS_ARRIVE = false;
    static int[]       DR        = {0, 1};  // 오른쪽, 아래
    static int[]       DC        = {1, 0};

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
        Deque<Jelly> stack = new ArrayDeque<>();
        stack.push(new Jelly(row, col));
        VISITED[row][col] = true;

        while (!stack.isEmpty()) {
            Jelly jelly = stack.pop();

            int move = MAP[jelly.row][jelly.col];
            if (move == -1) {
                IS_ARRIVE = true;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next_row = jelly.row + DR[i] * move;
                int next_col = jelly.col + DC[i] * move;

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
