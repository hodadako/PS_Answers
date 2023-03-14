from heapq import heappush, heappop
n = int(input())
answer = 0
cards = []
for _ in range(n):
    heappush(cards, int(input()))


if n == 1:
    pass
else:
    while True:
        a = heappop(cards)
        b = heappop(cards)
        answer += a + b
        heappush(cards, a + b)
        if len(cards) == 1:
            break
print(answer)