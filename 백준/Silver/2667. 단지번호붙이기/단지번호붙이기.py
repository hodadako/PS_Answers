from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = []
for i in range(n):
    graph.append(list(str(input().rstrip())))
    for j in range(n):
        graph[i][j] = int(graph[i][j])
        
count = []
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
def bfs(x, y):
    q = deque()
    q.append((x, y))
    result = 1
    graph[x][y] = 2
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] == 1:
                q.append((nx, ny))
                graph[nx][ny] = 2
                result += 1
    return result

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            count.append(bfs(i, j))

count.sort()

print(len(count))
for i in range(len(count)):
    print(count[i])      