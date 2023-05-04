import sys
input = sys.stdin.readline

# 상어는 냄새를 뿌린다. 상하좌우로만 이동할 수 있고, 이동하면 k - 1, 이동한 칸에 냄새를 뿌림,
# 이동 방향은 1. 아무 냄새도 없는 칸, 2. 자신의 냄새가 있는 칸. 경우의 수가 여러가지면 특정한 우선순위에 따름.
# 모든 상어가 이동한 다음에 여러마리 상어가 한 칸에 있으면 가장 작은 번호를 가진 상어를 제외하고 모두 쫓겨남
# 방금 이동한 방향이 보고 있는 방향이 된다.

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n, m, k = map(int, input().strip().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().strip().split())))
smell = [[[0, 0] for _ in range(n)] for _ in range(n)]

directions = list(map(int, input().strip().split()))

priorities = [[] for _ in range(m)]
for i in range(m):
    for j in range(4):
        priorities[i].append(list(map(int, input().strip().split())))

def shark_check(arr):
    check = True
    for i in range(n):
        for j in range(n):
            if arr[i][j] > 1:
                check = False
    return check

def update_smell(arr):
    for i in range(n):
        for j in range(n):
            if smell[i][j][1] > 0:
                smell[i][j][1] -= 1
            if arr[i][j] != 0:
                smell[i][j] = [arr[i][j], k]

def move():
    new_array = [[0] * n for _ in range(n)]
    for x in range(n):
        for y in range(n):
            if graph[x][y] != 0:
                direction = directions[graph[x][y] - 1]
                found = False
                for index in range(4):
                    nx = x + dx[priorities[graph[x][y] -1][direction - 1][index] - 1]
                    ny = y + dy[priorities[graph[x][y] -1][direction - 1][index] - 1]
                    if 0 <= nx < n and 0 <= ny < n:
                        if smell[nx][ny][1] == 0:
                            directions[graph[x][y] - 1] = priorities[graph[x][y] - 1][direction - 1][index]
                            if new_array[nx][ny] == 0:
                                new_array[nx][ny] = graph[x][y]
                            else:
                                new_array[nx][ny] = min(new_array[nx][ny], graph[x][y])
                            found = True
                            break
                if found:
                    continue
                for index in range(4):
                    nx = x + dx[priorities[graph[x][y] -1][direction - 1][index] - 1]
                    ny = y + dy[priorities[graph[x][y] -1][direction - 1][index] - 1]
                    if 0 <= nx < n and 0 <= ny < n:
                        if smell[nx][ny][0] == graph[x][y]:
                            directions[graph[x][y] - 1] = priorities[graph[x][y] - 1][direction - 1][index]
                            new_array[nx][ny] = graph[x][y]
                            break
    
    return new_array

time = 0
while True:
    update_smell(graph)
    new_array = move()
    graph = new_array
    time += 1

    if shark_check(graph):
        print(time)
        break
    if time >= 1000:
        print(-1)
        break
    