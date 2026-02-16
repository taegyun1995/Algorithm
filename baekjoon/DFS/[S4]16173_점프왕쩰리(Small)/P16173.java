import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 가로와 세로의 칸 수가 같은 정사각형
 * 출발점은 가장 왼쪽, 위 (다른 출발점은 없음)
 * 이동 가능한 방향은 오른쪽과 아래 (위, 왼쪽은 이동 불가함)
 * 가장 오른쪽, 가장 아래 칸(-1)에 도달하는 순간, 승리로 게임은 종료됨
 * 한 번에 이동할 수 있는 칸의 수는 현재 밟고 있는 칸에 쓰여 있는 수 만큼 (초과나 미만으로는 이동할 수 없음)
 */
public class P16173 {

    static int         N;
    static int[][]     MAP;
    static boolean[][] VISITED;
    static int[]       DR        = {0, 1};
    static int[]       DC        = {1, 0};
    static boolean     IS_ARRIVE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MAP = new int[N][N];
        VISITED = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
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
            int jump = MAP[now_row][now_col];

            if (jump == -1) {
                IS_ARRIVE = true;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next_row = now_row + DR[i] * jump;
                int next_col = now_col + DC[i] * jump;
                if (next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) {
                    continue;
                }

                if (!VISITED[next_row][next_col]) {
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
