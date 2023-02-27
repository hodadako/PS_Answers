from collections import deque

INF = 1e9

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

def bfs(graph, start, visited):
    q = deque([start])
    visited[start] = True
    while q:
        now = q.popleft()
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                dist[i] = dist[now] + 1
                if len(graph[i]) != 0:
                    q.append(i)



visited = [False] * (n + 1)
dist = [INF] * (n + 1)
dist[x] = 0

bfs(graph, x, visited)


if k not in dist:
    print(-1)
else:
    for i in range(1, n + 1):
        if dist[i] == k:
            print(i)

