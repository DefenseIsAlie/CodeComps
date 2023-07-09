import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Contest_18
 */

public final class Contest_18 {
    public static void main(String[] args) {
        FastScanner Input;
        Input = new FastScanner();

        int t = 0;

        t = Input.nextInt();
        // System.out.println("T is " + t);

        Sloution_A soln_a = new Sloution_A();
        for (int i = 0; i < t; i++) {
            System.out.println(soln_a.solve());
        }

    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
            }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}

class Sloution_A {
    public int solve() {

        FastScanner Input;
        Input = new FastScanner();

        int arr_size = 0;

        arr_size = Input.nextInt();

        // System.out.println("Arr size is " + arr_size);
        int[] A = new int[arr_size];
        int sum = 0;
        int prod = 1;
        for (int i = 0; i < arr_size; i++) {
            int temp;

            temp = Input.nextInt();
            sum += temp;
            prod *= temp;
            A[i] = temp;

        }

        if (sum >= 0 && prod == 1) {
            return 0;
        }

        if (sum >= 0 && prod == -1) {
            return 1;
        }

        if (sum < 0) {
            int ans = 0;
            if (-1 * sum % 2 == 0) {

                ans = -1 * sum / 2;
            } else {
                ans = -1 * sum / 2;
                ans += 1;
            }
            prod = prod * (int) Math.pow(-1, ans);

            if (prod > 0) {
                return ans;
            } else {
                return ans + 1;
            }
        }

        return -1;
    }
}