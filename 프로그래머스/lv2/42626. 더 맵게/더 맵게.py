from heapq import heappush, heappop, heapify

def solution(scoville, K):
    answer = 0
    heapify(scoville)
    while scoville[0] < K:
        lowest = heappop(scoville)
        second_lowest = heappop(scoville)
        new_spicy = lowest + second_lowest * 2
        heappush(scoville, new_spicy)
        answer += 1
        if len(scoville) == 1 and scoville[0] < K:
            answer = -1
            break
            
    return answer