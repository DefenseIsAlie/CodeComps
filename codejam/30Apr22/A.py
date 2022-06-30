t = int(input())

import heapq


def solve(testcase: int):
    N = int(input())
    Alphabet = [[0, 0]] * 26
    T = []

    for _ in range(N):
        tmp = input()
        Alphabet[ord(tmp[0]) - ord("a")][0] += 1
        Alphabet[ord(tmp[-1]) - ord("a")][1] += 1
        T.append(tmp)

    for x in Alphabet:
        if x[0] - x[1]:
            print(f"Case #{testcase + 1}: IMPOSSIBLE")


for testcase in range(t):
    solve(testcase)
