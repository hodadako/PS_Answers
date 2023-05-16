from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0;
    bridge = deque([0] * bridge_length)
    trucks = deque(truck_weights)
    
    cur = 0
    while trucks:
        cur += bridge[-1]
        cur -= bridge[0]
        if trucks[0] + cur <= weight:
            bridge.append(trucks.popleft())
            bridge.popleft()
            answer += 1
        else:
            bridge.append(0)
            bridge.popleft()
            answer += 1
    
    answer += bridge_length
    return answer