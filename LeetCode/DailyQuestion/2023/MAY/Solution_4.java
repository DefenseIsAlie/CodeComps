import java.util.ArrayList;
import java.util.List;

// /**
//  * Solution_4
//  */
// public class Solution_4 {

//     public static void main(String[] args) {
//         Solution soln = new Solution();
//         int[][] isconnected = {{1,0,0},{0,1,0},{0,0,1}};
//         System.out.println(soln.findCircleNum(isconnected));
//     }
// }

class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int N = isConnected.length;

        boolean[] visited = new boolean[N];
        int ans = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                ans++;

                tour_province(isConnected, visited, i);

            }
        }

        return ans;
    }

    void tour_province(int[][] isConnected, boolean[] visited, int node){
        visited[node] = true;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                tour_province(isConnected, visited, node);
            }
        }
    }
}