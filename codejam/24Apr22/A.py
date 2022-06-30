t = int(input())

from collections import deque

def solve(testcase: int):
    ans = 0
    N = int(input())
    D = list(map(int,input().split()))
    
    Order = deque(D)
    prevmax = 0
    while Order != deque([]):
        if len(Order) >= 2:
            if Order[0] <= Order[-1]:
                tmp = Order.popleft()
                if tmp >= prevmax:
                    prevmax = tmp
                    ans += 1
            else:
                tmp = Order.pop()
                if tmp >= prevmax:
                    prevmax = tmp
                    ans += 1
        else:
            tmp = Order.pop()
            if tmp >= prevmax:
                prevmax = tmp
                ans += 1
    
    print(f'Case #{testcase + 1}: {ans}')


for testcase in range(t):
    solve(testcase)
    
