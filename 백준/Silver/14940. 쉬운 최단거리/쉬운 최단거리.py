from collections import deque
from sys import stdin
input = stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


n, m = map(int, input().strip().split())
arr = []
visited = [[False] * m for _ in range(n)]
answer = [[0] * m for _ in range(n)]
start = (0, 0, 0)
for i in range(n):
    arr.append(list(map(int, input().strip().split())))
    for j in range(m):
        if arr[i][j] == 2:
            start = (i, j, 0)

def bfs(x, y, count):
    q = deque()
    q.append((x, y, count))
    answer[x][y] = count
    visited[x][y] = True
    while q:
        a, b, cur = q.popleft()
        for i in range(4):
            nx, ny = a + dx[i], b + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and arr[nx][ny] == 1:
                    visited[nx][ny] = True
                    answer[nx][ny] = cur + 1
                    q.append((nx, ny, cur + 1))

bfs(start[0], start[1], start[2])

for i in range(n):
    for j in range(m):
        if i == start[0] and j == start[1]:
            print(answer[i][j], end = " ")
        elif arr[i][j] == 1 and answer[i][j] != 0:
            print(answer[i][j], end = " ")
        elif arr[i][j] == 0:
            print(0, end = " ")
        else:
            print(-1, end = " ")
    print()



        