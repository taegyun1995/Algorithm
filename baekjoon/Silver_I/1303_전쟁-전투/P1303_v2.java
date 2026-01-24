import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1303_v2 {

    static int N, M;
    static char[][]    BOARD;
    static boolean[][] VISITED;
    static int[]       DX = {-1, 0, 1, 0};
    static int[]       DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BOARD = new char[M][N];
        VISITED = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = s.charAt(j);
            }
        }
        int b_count = 0;
        int w_count = 0;

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (VISITED[row][col]) {
                    continue;
                }

                if ('B' == BOARD[row][col]) {
                    int b_power = dfs(row, col);
                    b_count += b_power * b_power;
                } else if ('W' == BOARD[row][col]) {
                    int w_power = dfs(row, col);
                    w_count += w_power * w_power;
                }
            }
        }

        sb.append(w_count).append(" ").append(b_count);
        System.out.print(sb);
    }

    static int dfs(int row, int col) {
        Stack<Position> stack = new Stack<>();
        Position position = new Position(row, col);
        stack.push(position);
        VISITED[row][col] = true;
        int power = 0;

        while (!stack.isEmpty()) {
            Position now = stack.pop();
            int now_row = now.row;
            int now_col = now.col;
            power++;

            for (int i = 0; i < 4; i++) {
                int next_row = now_row + DX[i];
                int next_col = now_col + DY[i];

                if (next_row >= 0 && next_col >= 0 && next_row < M && next_col < N) {
                    if (!VISITED[next_row][next_col] && BOARD[now_row][now_col] == BOARD[next_row][next_col]) {
                        stack.push(new Position(next_row, next_col));
                        VISITED[next_row][next_col] = true;
                    }
                }
            }

        }

        return power;
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
