from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

size = 2
cur_x, cur_y = 0, 0

n = int(input().strip())
graph = []
for i in range(n):
    graph.append(list(map(int, input().strip().split())))
    for j in range(n):
        if graph[i][j] == 9:
            cur_x = i
            cur_y = j
            graph[i][j] = 0

def bfs_distance():
    dist = [[-1] * n for _ in range(n)]
    q = deque()
    q.append((cur_x, cur_y))
    dist[cur_x][cur_y] = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if dist[nx][ny] == -1 and graph[nx][ny] <= size:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))
    return dist

def find(dist):
    x, y = 0, 0
    min_dist = int(1e9)
    for i in range(n):
        for j in range(n):
            if dist[i][j] != -1 and 1 <= graph[i][j] < size:
                if dist[i][j] < min_dist:
                    x, y = i, j
                    min_dist = dist[i][j]
    
    if min_dist == int(1e9):
        return None
    else:
        return x, y, min_dist

result = 0
ate = 0

while True:
    value = find(bfs_distance())
    if value == None:
        print(result)
        break
    else:
        cur_x, cur_y = value[0], value[1]
        result += value[2]
        graph[cur_x][cur_y] = 0
        ate += 1
        if ate >= size:
            size += 1
            ate = 0