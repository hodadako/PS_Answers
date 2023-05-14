def solution(clothes):
    answer = 1
    types = {}
    for i in range(len(clothes)):
        if clothes[i][1] not in types:
            types[clothes[i][1]] = 1
        else :
            types[clothes[i][1]] += 1
            
    for key in types:
        answer *= types[key] + 1
    
    answer -= 1

    return answer