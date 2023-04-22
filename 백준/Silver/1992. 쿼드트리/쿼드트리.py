import sys
input = sys.stdin.readline

def solve(n, x, y):
    now = graph[x][y]
    flag = 0
    for i in range(x, x + n):
        for j in range(y, y + n):
            if graph[i][j] != now:
                flag = 1


    if flag == 1:
        print("(", end = "")
        solve(n // 2, x, y)
        solve(n // 2, x, y + n// 2)
        solve(n // 2, x + n // 2, y)
        solve(n // 2, x + n // 2, y + n // 2)
        print(")", end = "")
    if flag == 0:
        print(now, end = '')
    
    return f'({answer})'


answer = []
n = int(input())
graph = []
for i in range(n):
    graph.append(list(str(input())))
    for j in range(n):
        graph[i][j] = int(graph[i][j])

solve(n, 0, 0)
