from itertools import combinations

n, m = map(int, input().split())
a = input().split()

a1 = list(combinations(a, 3))

jack = []
for i in range(len(a1)): 
    sum = 0
    for j in range(3):
        sum += int(a1[i][j])
    jack.append(sum)

jack.sort()

if m in jack:
    print(m)
else:
    jack.append(m)
    jack.sort()
    id = jack.index(m)
    print(jack[id - 1])