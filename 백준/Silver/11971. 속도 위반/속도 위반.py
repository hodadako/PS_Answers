limits = [0] * 100
speeds = [0] * 100

n, m = map(int, input().split())
current = 0
for i in range(n):
    length, speed = map(int, input().split())
    for i in range(current, length + current):
        limits[i] = speed
    current += length

nextcur = 0
for i in range(m):
    length, speed = map(int, input().split())
    for i in range(nextcur, length + nextcur):
        speeds[i] = speed
    nextcur += length

answer = 0
for i in range(100):
    if speeds[i] > limits[i]:
        answer = max(answer, abs(speeds[i] - limits[i]))

print(answer)