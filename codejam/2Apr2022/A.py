t = int(input())

def solve(testcase: int):
    i = input().split()

    r = int(i[0])
    c = int(i[1])

    print(f'Case #{testcase + 1}:')
    
    for i in range(2*r + 1):
        tmp = ''
        for j in range(2*c + 1):
            if i == 0:
                if j == 0 or j == 1:
                    tmp += '.'
                elif j%2 ==0:
                    tmp += '+'
                else:
                    tmp += '-'
                continue
            elif i == 1:
                if j == 0 or j == 1:
                    tmp += '.'
                elif j%2 ==0:
                    tmp += '|'
                else:
                    tmp += '.'
                continue
            elif i%2 ==0:
                if j%2 == 0:
                    tmp += '+'
                else:
                    tmp += '-'
                    continue
            elif i%2 != 0:
                if j%2 == 0:
                    tmp += '|'
                else:
                    tmp += '.'
        

        print(tmp)


for testcase in range(t):
    solve(testcase)
