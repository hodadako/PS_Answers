from itertools import permutations as pr

n, m = map(int, input().split())
 
a = list(map(int, input().split()))

b = list(pr(a, m))
b.sort()
for i in range(len(b)):
    for j in range(len(b[i])):
        print(b[i][j], end = " ")
    print()