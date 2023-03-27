n, k = map(int, input().split())
bags = []
for _ in range(n):
    w, v = map(int, input().split())
    bags.append((w, v))

wt = []
val = []
bags.sort()
for i in range(len(bags)):
    wt.append(bags[i][0])
    val.append(bags[i][1])

dp = [[0] * (k + 1) for _ in range(n + 1)]


for i in range(1, n + 1):
    for j in range(1, k + 1):
        if wt[i - 1] <= j:
            dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j])
        else:
            dp[i][j] = dp[i - 1][j]

print(dp[n][k])