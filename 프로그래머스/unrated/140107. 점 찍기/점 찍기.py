import math

def solution(k, d):
    answer = 0
    for i in range(0, d + 1, k):
        y = math.sqrt(d ** 2 - i ** 2)
        answer += math.floor(y / k) + 1
    return answer