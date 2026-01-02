import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AB_1008 {

    static double N;
    static double M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Double.parseDouble(st.nextToken());
        M = Double.parseDouble(st.nextToken());

        System.out.println(N / M);
    }

}
