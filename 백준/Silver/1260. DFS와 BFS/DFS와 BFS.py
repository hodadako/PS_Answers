from collections import deque

n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    if b not in graph[a] and a not in graph[b]:
        graph[a].append(b)
        graph[b].append(a)
    

for i in range(n+1):
    graph[i].sort()
answer1 = []
answer1.append(v)

visited_dfs = [False] * (n + 1)
visited_bfs = [False] * (n + 1)

def dfs(graph, visited, v):
    visited[v] = True
    for k in graph[v]:
        if visited[k] == False:
            visited[k] = True
            if k not in answer1:
                answer1.append(k)
            dfs(graph, visited_dfs, k)

def bfs(graph, visited, v):
    answer = []
    visited[v] = True
    q = deque()
    answer.append(v)
    q.append(v)
    while q:
        now = q.popleft()
        for k in graph[now]:
            if visited[k] == False:
                visited[k] = True
                q.append(k)
                answer.append(k)
    return answer

dfs(graph, visited_dfs, v)
answer2 = bfs(graph, visited_bfs, v)
print(" ".join(map(str, answer1)))
print(" ".join(map(str, answer2)))
