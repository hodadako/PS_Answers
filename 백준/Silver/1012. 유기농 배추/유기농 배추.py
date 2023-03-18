from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, arr, count):
    if arr[x][y] == 1:
        q = deque()
        q.append((x, y))
        arr[x][y] = 2 
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx >= n or ny < 0 or ny >= m:
                    continue
                if arr[nx][ny] == 1:
                    arr[nx][ny] = 2
                    q.append((nx, ny))
        count += 1
    else:
        count += 0

    return count


t = int(input())
for i in range(t):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]
    cabbage = []
    count = 0
    for j in range(k):
        y, x = map(int, input().split())
        cabbage.append((x, y))
        graph[x][y] = 1

    for h in range(len(cabbage)):
        count = bfs(cabbage[h][0], cabbage[h][1], graph, count)

    print(count)