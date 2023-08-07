from itertools import combinations_with_replacement as pr

n, m = map(int, input().split())
 
a = list(map(int, input().split()))
a.sort()
b = list(pr(a, m))
b.sort()
for i in range(len(b)):
    for j in range(len(b[i])):
        print(b[i][j], end = " ")
    print()