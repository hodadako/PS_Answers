n = int(input())
x_cors = list(map(int, input().split()))

x_cor_types = list(set(x_cors))

x_cor_types.sort(reverse = True)

key = {}
for i in range(len(x_cor_types)):
    key[x_cor_types[i]] = len(x_cor_types) - (i + 1)

answer = []
for x_cor in x_cors:
    answer.append(key[x_cor])

for i in range(n):
    print(answer[i], end = " ")