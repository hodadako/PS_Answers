p = int(1e9)
total = 0
for i in range(7):
    a = int(input())
    if a % 2 != 0:
        total += a
        p = min(p, a)

if total == 0:
    print(-1)
else:
    print(total)
    print(p)