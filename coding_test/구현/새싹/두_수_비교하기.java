package 새싹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두_수_비교하기 {

    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A > B) {
            System.out.println(">");
        } else if (A == B) {
            System.out.println("==");
        } else {
            System.out.println("<");
        }
    }

}
