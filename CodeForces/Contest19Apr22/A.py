t = int(input())

def solve(testcase: int):
    n,m = map(int,input().split())

    ans = 0
    pos = [0,0]
    moves = [1,2,3,4]
    firstmove = 0
    k = max(n-1,m-1)
    if (n-1)>=(m-1):
        firstmove = 1
    else:
        firstmove = 2


    l = [firstmove]*k
    prevmove = firstmove
    ans += 1
    l.pop()
    while l != []:
        if prevmove == firstmove:
            heur = [[heuristic(pos,x,n,m),x] for x in moves if x!=prevmove]
            prevmove = min(heur)[1]
            ans += 1
        else:
            prevmove = firstmove
            ans +=1
            l.pop()
            
    print(ans)


    


def heuristic(pos:list,move:int,n,m):
    if move == 1:
        return (pos[0]-1-n)**2 + (pos[1]-m)**2
    
    if move == 3:
        return (pos[0]+1-n)**2 + (pos[1]-m)**2
    
    if move == 4:
        return (pos[1]-1-m)**2 + (pos[0]-n)**2
    
    if move == 2:
        return (pos[1]-m+1)**2 + (pos[0]-n)**2


for testcase in range(t):
    solve(testcase)
