t = int(input())

def solve(testcase: int):
    s = input()
    m = 0
    ans = 0
    prev = [False]*26
    for x in s:
        if prev[ord(x)-ord('a')]:
            m += 2
            for i in range(26):
                prev[i] = False
        else:
            prev[ord(x)-ord('a')] = True
    ans = len(s) - m
    print(ans)

for testcase in range(t):
    solve(testcase)
