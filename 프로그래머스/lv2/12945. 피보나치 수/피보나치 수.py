dp = [0] * (100001)

def solution(n):
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    for i in range(3, 100001):
        dp[i] = dp[i - 1] + dp[i - 2]
    answer = dp[n] % 1234567
    return answer