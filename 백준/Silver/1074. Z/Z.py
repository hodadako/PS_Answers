def solve(n, x, y):
    global result
    if n == 2:
        for i in range(x, x + 2):
            for j in range(y, y + 2):
                if i == r and j == c:
                    print(result)
                result += 1
    else:
        temp = n // 2
        if x <= r < x + temp and y <= c < y + temp:
            solve(temp, x, y)
        elif x <= r < x + temp and y + temp <= c < y + n:
            result += temp * temp
            solve(temp, x, y + temp)
        elif x + temp <= r < x + n and y <= c < y + temp:
            result += temp * temp * 2
            solve(temp, x + temp, y)
        else:
            result += temp * temp * 3
            solve(temp, x + temp, y + temp)
    

N, r, c = map(int, input().split())
result = 0
solve(2**N, 0, 0)