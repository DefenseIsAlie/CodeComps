t = int(input())

def solve(testcase: int):
    n = int(input())
    a = list(map(int,input().split()))

    l = []
    
    prev = 0
    for curr in range(len(a)):
        if a[curr]==0:
            l.append([a[prev:curr],prev,curr])
            prev = curr


for testcase in range(t):
    solve(testcase)
