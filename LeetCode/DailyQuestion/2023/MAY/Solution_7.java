/**
 * Solution_8
 */
// public class Solution_8 {

//     public static void main(String[] args) {
//         int[] arg = { 9874, 1439, 2953 };
//         Solution_d8 soln = new Solution_d8();
//         System.out.println(soln.minFlips(arg[0], arg[1], arg[2]));
//     }
// }

class Solution_d8 {
    public int minFlips(int a, int b, int c) {
        int ans = 0;

        String XOR = Integer.toBinaryString((a | b) ^ c);
        String A_bits = Integer.toBinaryString(a);
        String B_bits = Integer.toBinaryString(b);
        
        if (A_bits.length() < B_bits.length()) {
            for (int i = 0; B_bits.length() != A_bits.length(); i++) {
                A_bits = "0" + A_bits;
            }
        }

        if (A_bits.length() > B_bits.length()) {
            for (int i = 0; A_bits.length() != B_bits.length(); i++) {
                B_bits = "0" + B_bits;
            }
        }

        if (XOR.length() < A_bits.length()) {
            for (int i = 0; A_bits.length() != XOR.length(); i++) {
                XOR = "0" + XOR;
            }
        }
        
        if (XOR.length() > A_bits.length()) {
            for (int i = 0; XOR.length() != A_bits.length(); i++) {
                A_bits = "0" + A_bits;
                B_bits = "0" + B_bits;
            }
        }

        // B_bits = "0" + B_bits;
        // System.out.println(A_bits);
        // System.out.println(B_bits);
        // System.out.println(XOR);

        for (int i = 0; i < XOR.length(); i++) {

            if (XOR.substring(i, i + 1).equals("0")) {
                continue;
            }

            if (XOR.substring(i, i + 1).equals("1") && A_bits.substring(i, i + 1).equals("1")
                    && B_bits.substring(i, i + 1).equals("1")) {
                ans += 2;
            } else {
                ans += 1;
            }
        }

        return ans;
    }
}