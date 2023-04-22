import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

for i in range(1, n + 1):
    for j in range(1, n + 1):
        for k in range(1, n + 1):
            if graph[j][i] > 0 and graph[i][k] > 0:
                if graph[j][k] == 0:
                    graph[j][k] = graph[j][i] + graph[i][k]
                else:
                    graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k])
                
answer = n + 2
min_i = 1000000000
for i in range(1, n + 1):
    k = 0
    for j in range(1, n + 1):
        if i != j:
            k += graph[i][j]
    if min_i > k:
        answer = i
    min_i = min(min_i, k)
        

print(answer)