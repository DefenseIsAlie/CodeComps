void main(List<String> args) {
  Solution s = new Solution();
  List<List<int>> dislikes = [
    [1, 2],
    [1, 3],
    [2, 4]
  ];
  int n = dislikes.length;
  print(s.possibleBipartition(n, dislikes));
}

class Solution {
  bool possibleBipartition(int n, List<List<int>> dislikes) {
    List<int> q = [];
    List<int> color = new List.filled(n+1, -1);

    color[1] = 0;
    q.add(1);

    while (q.isNotEmpty) {
      int node1 = q.removeAt(0);

      for (int dislike in dislikes[node1]) {
        if (color[dislike] == -1) {
          color[dislike] = (color[node1] == 0) ? 1 : 0;
          q.add(dislike);
          print(q);
        } else {
          if (color[dislike] == color[node1]) {
            return false;
          }
        }
      }
    }

    return true;
  }
}
