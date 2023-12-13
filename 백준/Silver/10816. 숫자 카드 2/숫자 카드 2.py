from sys import stdin
from collections import Counter

n = int(stdin.readline())
a = list(map(int, stdin.readline().split()))

m = int(stdin.readline())
x = list(map(int, stdin.readline().split()))

C = Counter(a)
print(" ".join(f'{C[i]}' if i in C else "0" for i in x))
