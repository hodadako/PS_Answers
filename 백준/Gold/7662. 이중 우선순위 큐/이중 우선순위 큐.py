from heapq import heappop, heappush
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    k = int(input())
    max_heap = []
    min_heap = []
    visited = [False] * (1000001)
    for i in range(k):
        char, n = map(str, input().split())
        n = int(n)
        if char == "I":
            heappush(min_heap, (n, i))
            heappush(max_heap, (-n, i))
            visited[i] = True
        else:
            if n == -1:
                while min_heap and not visited[min_heap[0][1]]:
                    heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = False
                    heappop(min_heap)
            else:
                while max_heap and not visited[max_heap[0][1]]:
                    heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = False
                    heappop(max_heap)
    
    while min_heap and not visited[min_heap[0][1]]: 
        heappop(min_heap)
    while max_heap and not visited[max_heap[0][1]]:
        heappop(max_heap)

    if min_heap and max_heap:
        print(-max_heap[0][0], min_heap[0][0])
    else:
        print("EMPTY")