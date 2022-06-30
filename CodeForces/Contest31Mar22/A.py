
t = input()

for testcase in range(int(t)):
    inp = input().split()

    a = int(inp[0])
    b = int(inp[1])

    if a == 0:
        print(1)
        continue

    if b == 0:
        print(a+1)
        continue
    
    ans =  b + b + a + 1
    print(ans)

