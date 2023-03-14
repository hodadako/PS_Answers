n = int(input())
answer = []
score = []
for i in range(n):
    score.append(list(map(str, input().split())))

score = sorted(score, key = lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in range(len(score)):
    print(score[i][0])

