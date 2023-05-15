from collections import deque

def solution(s):
    answer = True
    
    q = deque()
    for i in range(len(s)):
        if len(q) == 0:
            q.append(s[i])
        else:
            if s[i] == "(":
                q.append(s[i])
            elif q[-1] == "(" and s[i] == ")":
                q.pop()
    
    if q:
        answer = False

    return answer