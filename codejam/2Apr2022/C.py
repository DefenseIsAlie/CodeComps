t = int(input())

def solve(testcase: int):
    N = int(input())
    Dice = list(map(int,input().split()))
    ans = 0
    Dice.sort()

    l = []
    i = 1

    for x in Dice:
        if x >= i:
            l.append(i)
            i += 1


    ans = len(l)
    print(f'Case #{testcase}: {ans}')

for testcase in range(t):
    solve(testcase)
