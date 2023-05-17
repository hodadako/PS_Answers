from heapq import heappop, heappush

def solution(operations):
    visited = [False] * 1000001
    max_heap = []
    min_heap = []
    for i in range(len(operations)):
        key, num = operations[i].split(" ")
        num = int(num)
        if key == "I":
            heappush(max_heap, (-num, i))
            heappush(min_heap, (num, i))
            visited[i] = True
        else:
            if num == -1:
                while min_heap and not visited[min_heap[0][1]]:
                    heappop(min_heap)
                if min_heap and visited[min_heap[0][1]]:
                    visited[min_heap[0][1]] = False
                    heappop(min_heap)
            else:
                while max_heap and not visited[max_heap[0][1]]:
                    heappop(max_heap)
                if max_heap and visited[max_heap[0][1]]:
                    visited[max_heap[0][1]] = False
                    heappop(max_heap)
                    
    while min_heap and not visited[min_heap[0][1]]:
        heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heappop(max_heap)
    if min_heap and max_heap:
        answer = [-max_heap[0][0], min_heap[0][0]]
    else:
        answer = [0, 0]
    return answer