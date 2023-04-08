from collections import deque

n, k = map(int, input().split())


graph = [0] * 100001
visited = [False] * 100001
dx = [2, -1, 1]

visited[n] = True
def bfs(x):
    q = deque()
    q.append(x)
    while q:
        now = q.popleft()
        for i in range(3):
            if dx[i] == 2:
                nx = now * 2
            else:
                nx = now + dx[i]
            if nx < 0 or nx > 100000:
                continue
            if visited[nx] == False:
                visited[nx] = True
                graph[nx] = graph[now] + 1
                q.append(nx)


bfs(n)

print(graph[k])