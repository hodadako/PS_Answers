def solution(n):
    a = [0 for i in range(n + 1)]
    a[2] = 3
    a[4] = 11
    for i in range(5, n + 1):
        if i == 0:
            pass
        elif i % 2 == 0:
            a[i] = a[i - 2] * 4 - a[i - 4]
        else:
            a[i] = 0
    return a[n] % 1000000007