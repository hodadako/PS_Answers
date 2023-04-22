import sys
input = sys.stdin.readline

def solve(n, x, y):
    global w, b, k
    now = graph[x][y]
    flag = 0
    for i in range(x, x + n):
        for j in range(y, y + n):
            if graph[i][j] != now:
                flag = 1


    if flag == 1:
        s = n // 3
        solve(s, x, y)
        solve(s, x, y + s)
        solve(s, x, y + s * 2)
        solve(s, x + s, y)
        solve(s, x + s, y + s)
        solve(s, x + s, y + s * 2)
        solve(s, x + s * 2, y)
        solve(s, x + s * 2, y + s)
        solve(s, x + s * 2, y + s * 2)
    if flag == 0:
        if now == 1:
            w += 1
        elif now == 0:
            b += 1
        else:
            k += 1
    

w = 0
b = 0
k = 0
n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

solve(n, 0, 0)
print(k)
print(b)
print(w)