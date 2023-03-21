n = int(input())
m = int(input())
INF = 100000000
graph = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(m):
    a, b, cost = map(int, input().split())
    if graph[a][b] > 0:
        graph[a][b] = min(cost, graph[a][b])
    else:
        graph[a][b] = cost

for i in range(1, n + 1):
    graph[i][i] = 0

for i in range(1, n + 1):
    for j in range(1, n + 1):
        for k in range(1, n + 1):
            graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if graph[i][j] == INF:
            graph[i][j] = 0 
        print(graph[i][j], end = " ")
    print()