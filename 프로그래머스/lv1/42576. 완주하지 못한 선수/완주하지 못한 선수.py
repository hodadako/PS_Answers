from collections import Counter

def solution(participant, completion):
    answer = ''
    new_dict = Counter(participant)
    for c in completion:
        new_dict[c] -= 1
    
    for i in new_dict:
        if new_dict[i] == 1:
            answer = i
            break
    return answer