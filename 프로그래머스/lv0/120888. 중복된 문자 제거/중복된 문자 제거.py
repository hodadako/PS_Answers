def solution(my_string):
    answer = []
    a = list(my_string)
    for i in a:
        if i not in answer:
            answer.append(i)
    
    
    
    return "".join(answer)