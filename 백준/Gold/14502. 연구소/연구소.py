from itertools import combinations
from collections import deque

n, m = map(int, input().split())
answer = 0
dots = []
virus = []

maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))
    for j in range(m):
        if maps[i][j] == 0:
            dots.append((i, j))
        elif maps[i][j] == 2:
            virus.append((i, j))

def count_0(arr):
    result = 0
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if arr[i][j] == 0:
                result += 1
    return result

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx <= -1 or ny <= -1 or nx >= n or ny >= m:
                continue
            if maps[nx][ny] == 1:
                continue
            if maps[nx][ny] == 0:
                maps[nx][ny] = 2
                q.append((nx, ny))

        
dist = list(combinations(dots, 3))


for i in range(len(dist)):
    for j in range(3):
        maps[dist[i][j][0]][dist[i][j][1]] = 1
    for l in range(len(virus)): 
        bfs(virus[l][0], virus[l][1])
    answer = max(answer, count_0(maps))
    for k in range(len(dots)):
        maps[dots[k][0]][dots[k][1]] = 0

print(answer)
