from itertools import combinations

t = int(input())

def solve():
    n = int(input())
    a = list(map(int,input().strip().split()))
    
    comb = combinations(a,3)

    y = True

    for tup in comb:
        if sum(tup) not in a:
            print("NO")
            y = False
            break

    if y:
        print("YES")

for i in range(t):
    solve()