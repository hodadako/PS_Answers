from collections import deque
from copy import deepcopy
import sys
input = sys.stdin.readline

n = int(input().strip())
graph = []
for i in range(n):
    temp = list(str(input().strip()))
    graph.append(temp)
graph_cb = deepcopy(graph)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(x, y, arr, a):
    q = deque()
    q.append((x, y))
    current = arr[x][y]
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if arr[nx][ny] != current:
                continue
            if arr[nx][ny] == current:
                arr[nx][ny] = a
                q.append((nx, ny))

count = 0
for i in range(n):
    for j in range(n):
        if isinstance(graph[i][j], str): 
            bfs(i, j, graph, count)
            count += 1

for i in range(n):
    for j in range(n):
        if graph_cb[i][j] == "G":
            graph_cb[i][j] = "R"

count_cb = 0
for i in range(n):
    for j in range(n):
        if isinstance(graph_cb[i][j], str):
            bfs(i, j, graph_cb, count_cb)
            count_cb  += 1

print(count, count_cb)