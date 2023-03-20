n = int(input())
dx = [1, 1]
dy = [0, 1]

graph = [["*"] * n for _ in range(n)]
for i in range(n):
    nums = list(map(int, input().split()))
    for j in range(len(nums)):
        graph[i][j] = nums[j]

for x in range(n - 2, -1, -1):
    for y in range(n):
        if graph[x][y] == "*":
            continue
        else:
            prev_max = 0
            for i in range(2):
                nx = x + dx[i]
                ny = y + dy[i]
                prev_max = max(prev_max, graph[nx][ny])
            graph[x][y] += prev_max

print(graph[0][0])