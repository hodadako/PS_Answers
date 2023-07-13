k = int(input())

dots = []
for _ in range(k):
    a = int(input())
    if a != 0:
        dots.append(a)
    else:
        dots.pop()

print(sum(dots))