def solution(nums):
    answer = 0
    pick = len(list(set(nums)))
    user = len(nums) // 2
    if pick >= user:
        answer = user
    else:
        answer = pick
    return answer