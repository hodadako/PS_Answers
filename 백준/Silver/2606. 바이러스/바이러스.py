from collections import deque

n = int(input())
m = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)

def dfs(v, graph):
    q = deque()
    q.append(v)
    visited[v] = True
    count = 0
    while q:
        now = q.popleft()
        for i in graph[now]:
            if visited[i] == False:
                visited[i] = True
                q.append(i)
                count += 1
    return count

print(dfs(1, graph))
