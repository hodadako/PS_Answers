from itertools import combinations_with_replacement as pr

n, m = map(int, input().split())
 
a = [i for i in range(1, n + 1)]

b = list(pr(a, m))
b.sort()
for i in range(len(b)):
    for j in range(len(b[i])):
        print(b[i][j], end = " ")
    print()