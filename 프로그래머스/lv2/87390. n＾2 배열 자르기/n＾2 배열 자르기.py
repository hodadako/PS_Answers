def solution(n, left, right):
    a = []
    for i in range(left, right + 1):
        y = i // n
        x = i % n
        if y >= x:
            a.append(y + 1)
        if y < x:
            a.append(x + 1)

    return a