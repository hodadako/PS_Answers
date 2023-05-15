from heapq import heappush, heappop
from collections import deque

def solution(priorities, location):
    n = len(priorities)
    answer = [0] * n
    q = deque()
    heap = []
    for i in range(n):
        heappush(heap, -priorities[i])
        q.append(i)
    
    for i in range(n):
        cur = - heappop(heap)
        for _ in range(n):
            if priorities[q[0]] == cur:
                answer[q.popleft()] = i + 1
                break
            else :
                q.append(q.popleft())
    
    return answer[location]