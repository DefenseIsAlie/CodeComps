t = int(input())

def solve(testcase: int):
    s = input().strip()
    ans = ''
    
    for i in range(len(s)-1):
        if ord(s[i]) < ord(s[i+1]):
            ans += s[i]*2
        else:
            ans += s[i]
    
    ans += s[-1]

    print(f'Case #{testcase + 1}: {ans}')

for testcase in range(t):
    solve(testcase)
