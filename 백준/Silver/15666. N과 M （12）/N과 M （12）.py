from itertools import combinations_with_replacement as pr

n, m = map(int, input().split())
 
a = list(set(map(int, input().split())))

b = list(pr(a, m))
b.sort()
answer = []
for i in range(len(b)):
    c = []
    for j in range(len(b[i])):
        c.append(b[i][j])
    c.sort()
    answer.append(c)
    
answer.sort()
for i in range(len(answer)):
    for j in range(m):
        print(answer[i][j], end = " ")
    print()