def solution(N, stages):
    answer = []
    key = []
    failure = [0] * (N + 1)
    types = list(set(stages))
    types.sort(reverse = True)
    total = 0
    for i in range(len(failure), 0, -1):
        if i == len(failure):
            total += stages.count(i)
        elif i in types and i != len(failure):
            total += stages.count(i)
            failure[i] = stages.count(i) / total
        else:
            failure[i] = 0

    for i in range(1, N + 1):
        key.append([failure[i],i])

    key.sort(reverse = True, key = lambda x : [x[0], -x[1]])
    for i in range(N):
        answer.append(key[i][1])
    return answer

