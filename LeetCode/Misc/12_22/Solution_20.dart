void main(List<String> args) {
  Solution s = new Solution();
  List<List<int>> test = [
    [1],
    [2],
    [3],
    []
  ];
  print(s.canVisitAllRooms(test));
}

class Solution {
  bool canVisitAllRooms(List<List<int>> rooms) {
    if (rooms.length == 0) {
      return true;
    }

    List<bool> visited = new List.filled(rooms.length, false);

    visitNodes(rooms, visited, 0);

    for (int i = 0; i < rooms.length; i++) {
      if (!visited[i]) {
        return false;
      }
    }

    return true;
  }

  void visitNodes(List<List<int>> rooms, List<bool> visited, int rootIndx) {
    visited[rootIndx] = true;

    for (int room in rooms[rootIndx]) {
      if (!visited[room]) {
        visitNodes(rooms, visited, room);
      }
    }
  }
}
