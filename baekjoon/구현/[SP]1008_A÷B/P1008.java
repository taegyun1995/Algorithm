import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1008 {
    static double A;
    static double B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Double.parseDouble(st.nextToken());
        B = Double.parseDouble(st.nextToken());

        System.out.println(A / B);
    }
}
