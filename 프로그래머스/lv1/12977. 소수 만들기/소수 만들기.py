from itertools import combinations as cb

def check(n):
    flag = True
    for i in range(2, n):
        if n % i == 0:
            flag = False
            break
    
    return flag

def solution(nums):
    answer = 0
    a = list(cb(nums, 3))
    for i in range(len(a)):
        x, y, z = a[i]
        if check(x + y + z):
            answer += 1
    return answer