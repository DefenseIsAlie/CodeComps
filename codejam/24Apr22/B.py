t = int(input())

def fixProductOrder(N:int,P:int,L:list):
    pass




def solve(testcase: int):
    ans = 0
    N,P = map(int,input().split())
    XP = []
    minPossibleOrder = []
    for i in range(N):
        tmp = list(map(int,input().split()))
        tmp.sort()
        minPossibleOrder.extend([(i,tmp[x]) for x in range(P)])
        XP.append(tmp)

    

    print(f'Case #{testcase + 1}: {ans}')

for testcase in range(t):
    solve(testcase)
