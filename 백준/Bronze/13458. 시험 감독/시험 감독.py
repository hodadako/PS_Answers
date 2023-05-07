from sys import stdin
input = stdin.readline

n = int(input().strip())
a = list(map(int, input().strip().split()))
b, c = map(int, input().strip().split())

count = 0
for i in range(n):
    if b >= a[i]:
        a[i] = 0
    else:
        a[i] -= b
    count += 1

for i in range(n):
    count += a[i] // c
    if a[i] % c > 0:
        count += 1

print(count)


