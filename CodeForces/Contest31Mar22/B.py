t = int(input())

def solve(testcase: int):
    n = int(input())
    a = list(map(int,input().split()))
    a.sort()
    
    if n == 1:
        if a[0] >= 2:
            print("no")
            return
        else:
            print("yes")
            return

    if a[-1] - a[-2] > 1:
        print('no')
    else:
        print('yes')

for testcase in range(t):
    solve(testcase)
