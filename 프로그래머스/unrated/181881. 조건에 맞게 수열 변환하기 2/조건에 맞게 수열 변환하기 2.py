def get_num(n):
    count = 0
    while (n >= 50 and n % 2 == 0) or (n < 50 and n % 2 != 0):
        if n >= 50 and n % 2 == 0:
            n //= 2
        else:
            n = n * 2 + 1
        count += 1
    
    return count

def solution(arr):
    dp = {}
    for i in range(101):
        dp[i] = get_num(i)
    
    answer = []
    for i in range(len(arr)):
        answer.append(dp[arr[i]])

    return max(answer)