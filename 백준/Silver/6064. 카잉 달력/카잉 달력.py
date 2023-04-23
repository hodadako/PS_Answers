import sys
input=sys.stdin.readline

def find_year_number(m,n,x,y):
    k=x
    while k<=m*n:
        if (k-x)%m==0 and (k-y)%n==0:
            return k
        k=k+m
    return -1

for _ in range(int(input())):
    m,n,x,y=list(map(int, input().split()))
    print(find_year_number(m,n,x,y))