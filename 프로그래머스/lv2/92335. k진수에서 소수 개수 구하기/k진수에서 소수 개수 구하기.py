import math

def check(s):
    a = int(math.sqrt(s)) + 1
    flag = True
    for i in range(2, a):
        if s % i == 0:
            flag = False
            break
    if s == 1:
        flag = False
    return flag

def numberToBase(n, b):
    if n == 0:
        return 0
    digits = []
    while n:
        digits.append(str(n % b))
        n //= b
    return "".join(digits[::-1])

def solution(n, k):
    new = numberToBase(n, k)
    answer = 0
    tmp = new.split("0")
    for i in tmp:
        if i != "":
            if check(int(i)):
                answer += 1
                

    return answer