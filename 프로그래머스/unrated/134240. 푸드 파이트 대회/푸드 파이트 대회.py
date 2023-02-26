def solution(food):
    answer = ''
    for i in range(1, len(food)):
        for j in range(food[i]//2):
            answer += str(i)
    length = len(answer) + 1
    a = "0" + answer[-1:-length:-1]
    b = answer + a
        
    return b