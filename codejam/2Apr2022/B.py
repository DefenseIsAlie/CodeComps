t = int(input())

def solve(testcase: int):
    P1 = list(map(int,input().split()))
    P2 = list(map(int,input().split()))
    P3 = list(map(int,input().split()))
    possible = False
    ans = [0,0,0,0]
    
    minC = [ min((P1[i],i,1),(P2[i],i,2),(P3[i],i,3)) for i in range(4) ]

    if sum([i[0] for i in minC]) >= 10**6:
        possible = True

    i = min(minC)
    if i[0] >= 10**6 and possible:
        ans[i[1]] = 10**6
        print(f'Case #{testcase + 1}: {ans[0]} {ans[1]} {ans[2]} {ans[3]}')
        return
    else:
        ans[i[1]] = i[0]
    
    minC.remove(i)
    totes = 10**6 - i[0]

    for j in range(3):
        i = min(minC)
        if totes > i[0]:
            ans[i[1]] = i[0]
            totes -= i[0]
        else:
            ans[i[1]] = totes
            totes -= totes
        minC.remove(i)

    if possible:
        print(f'Case #{testcase + 1}: {ans[0]} {ans[1]} {ans[2]} {ans[3]}')
    else:
        print(f'Case #{testcase + 1}: IMPOSSIBLE')


for testcase in range(t):
    solve(testcase)
