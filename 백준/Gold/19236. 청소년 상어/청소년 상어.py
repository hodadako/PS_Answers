import sys
from copy import deepcopy
input = sys.stdin.readline

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]
graph = []
for i in range(4):
    graph.append([])
    a = list(map(int, input().strip().split()))
    for j in range(0, 8, 2):
        graph[i].append([a[j], a[j + 1]])

#상어의 번호는 17로 하자.
#상어가 고기를 먹고 물고기가 이동한다
#물고기 이동이 끝나면 상어가 이동할 수 있는데 
#물고기가 있는 칸으로만 이동할 수 있고 이동하는 와중에 마주치는 물고기는 먹지 않는다.

#구현해야할 것  1. 물고기 이동 2 상어 이동.

def alive(arr, index):
    for i in range(4):
        for j in range(4):
            if arr[i][j][0] == index:
                return (i, j)
    return None

def fish_next(arr, cur_x, cur_y):
    for i in range(1, 17):
        position = alive(arr, i)
        if position != None:
            x, y = position[0], position[1]
            index = arr[x][y][1]
            for step in range(index - 1, index + 7):
                if step > 7:
                    step %= 8
                nx = x + dx[step]
                ny = y + dy[step]
                if 0 <= nx < 4 and 0 <= ny < 4:
                    if not (nx == cur_x and ny == cur_y):
                        arr[x][y][1] = step + 1
                        arr[nx][ny], arr[x][y] = arr[x][y], arr[nx][ny]
                        break

def eat(arr, x, y):
    index = arr[x][y][1]
    pos_move = []
    for i in range(1, 4):
        nx = x + dx[index - 1] * i
        ny = y + dy[index - 1] * i
        if 0 <= nx < 4 and 0 <= ny < 4:
            if arr[nx][ny][0] != 17:
                pos_move.append((nx, ny))
                
    return pos_move

result = 0

def dfs(array, x, y, total):
    global result
    array = deepcopy(array)
    total += array[x][y][0]
    array[x][y][0] = 17
    
    fish_next(array, x, y)
    positions = eat(array, x, y)
    if len(positions) == 0:
        result = max(result, total)
        return
    for nx, ny in positions:
        dfs(array, nx, ny, total)

dfs(graph, 0, 0, 0)
print(result)
