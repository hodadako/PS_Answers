from collections import deque
from sys import stdin
input = stdin.readline

n, l = map(int, input().strip().split())
a = list(map(int, input().strip().split()))
queue = deque()

for i in range(n):
    while queue and a[queue[-1]] > a[i]:
        queue.pop()
    queue.append(i)
    if queue and queue[0] <= i - l:
        queue.popleft()
    print(a[queue[0]], end = " ")
