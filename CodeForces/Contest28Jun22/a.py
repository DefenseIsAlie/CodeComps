from functools import reduce
from operator import xor

t = int(input())

def solve():
    n = int(input())
    a = list(map(int,input().strip().split()))
    for i in range(n):
        j = n-i-1
        tmp1=a[:]
        tmp1.pop(i)
        tmp2=a[:]
        tmp2.pop(j)
        

        if a[i] == reduce(xor,tmp1):
            print(a[i])
            break
        if a[j] == reduce(xor,tmp2):
            print(a[j])
            break

for i in range(t):
    solve()