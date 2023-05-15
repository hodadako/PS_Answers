from collections import deque
import math

def solution(progresses, speeds):
    answer = []
    q = deque()
    days = []
    for i in range(len(progresses)):
        days.append(math.ceil((100 - progresses[i]) / speeds[i]))
    
    count = 0
    for i in range(len(days)):
        if len(q) == 0:
            q.append(days[i])
            count += 1
        elif len(q) > 0:
            if q[0] >= days[i]:
                count += 1
            else:
                q.pop()
                answer.append(count)
                count = 0
                q.append(days[i])
                count += 1

    
    if count > 0:
        answer.append(count)
    print(days)
    return answer