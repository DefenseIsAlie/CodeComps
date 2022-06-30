t = int(input())


def solve(testcase: int):
    tmp = input().split()
    N = int(tmp[0])
    X = int(tmp[1])

    sum = 0
    sumlimit = N * X
    ans =f''
    
    notlist = []

    if N == 1:
        print(N*X)

    limit = 0

    if sumlimit >= 1000:
        limit = 1000
    else:
        limit = sumlimit

    for i in range(N):
        pass


    
    print(ans)

    
for testcase in range(t):
    solve(testcase)
