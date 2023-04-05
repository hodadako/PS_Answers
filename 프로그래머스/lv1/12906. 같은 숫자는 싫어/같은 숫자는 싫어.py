def solution(arr):
    answer = []
    now = arr[0]
    answer.append(now)
    for i in range(1, len(arr)):
        if now != arr[i]:
            answer.append(arr[i])
            now = arr[i]
    return answer