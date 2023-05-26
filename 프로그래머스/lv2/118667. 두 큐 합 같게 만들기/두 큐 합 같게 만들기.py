from collections import deque

def even_q(q1, q2, target, cur, n):
    count = 0
    while cur != target:
        if cur > target:
            tmp1 = q1.popleft()
            q2.append(tmp1)
            cur -= tmp1
            count += 1
        elif cur < target:
            tmp2 = q2.popleft()
            q1.append(tmp2)
            cur += tmp2
            count += 1
        
        if count >= 600000:
            count = -1
            break
    
    return count
    
def solution(queue1, queue2):
    answer = 0
    q1 = deque(queue1)
    q2 = deque(queue2)
    q3 = deque(queue1)
    q4 = deque(queue2)
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    target = (sum1 + sum2) / 2
    n = len(queue1)
    
    n1 = even_q(q1, q2, target, sum1, n)
    n2 = even_q(q4, q3, target, sum2, n)
    
    if n1 == -1 and n2 == -1: 
        answer = -1 
    else:
        if n1 == -1:
            answer = n2
        elif n2 == -1:
            answer = n1
        else:
            answer = min(n1, n2)
    return answer