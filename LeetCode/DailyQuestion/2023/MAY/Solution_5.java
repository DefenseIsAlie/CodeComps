/**
 * Solution_5
 */
// public class Solution_5 {

//     public static void main(String[] args) {
//         int[][] testcase = { { -4, -3 }, { 1, 0 }, { 3, -1 }, { 0, -1 }, { -5, 2 } };

//         Solutiont soln = new Solutiont();

//         System.out.println(soln.checkStraightLine(testcase));
//     }
// }

class Solutiont {
    public boolean checkStraightLine(int[][] coordinates) {
        double prev_slope;
        double curr_slope;

        if (coordinates[1][0] == coordinates[0][0]) {
            curr_slope = Double.MAX_VALUE;
            prev_slope = Double.MAX_VALUE;
        } else {
            curr_slope = (double)(coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);
            prev_slope = curr_slope;
        }

        for (int i = 1; i < coordinates.length - 1; i++) {
            if (coordinates[i + 1][0] == coordinates[i][0]) {
                curr_slope = Double.MAX_VALUE;
            } else {
                curr_slope = (double)(coordinates[i + 1][1] - coordinates[i][1]) / (double)(coordinates[i + 1][0] - coordinates[i][0]);
            }

            System.out.println("prev slope at " + prev_slope + " " + i);
            System.out.println("curr slope at " + curr_slope + " " + i);

            if (Math.abs(curr_slope - prev_slope) > 1e-9) {
                return false;
            }

            prev_slope = curr_slope;
        }

        return true;
    }
}