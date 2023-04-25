from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
tp = [0] * 101
visited = [0] * 101
q = deque([1])

for i in range(n + m):
    a, b = map(int, input().strip().split())
    tp[a] = b


while True:
    if visited[100] != 0:
        print(visited[100])
        break
    now = q.popleft()
    for i in range(1, 7):
        if 1 <= i + now <= 100 and visited[i + now] == 0:
            if tp[i + now] == 0:
                visited[i + now] = visited[now] + 1
                q.append(i + now)
            else:
                if tp[tp[now + i]] == 0 and visited[tp[now + i]] == 0:
                    q.append(tp[now + i])
                    visited[tp[now + i]] = visited[now] + 1
                else:
                    current = tp[now + i]
                    while tp[current] != 0:
                        current = tp[current]
                    q.append(tp[current])
                    visited[tp[current]] = visited[now]
