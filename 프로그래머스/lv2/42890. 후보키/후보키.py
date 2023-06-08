from itertools import combinations as cb

candidate_key = []

def find_key(relation, n):
    a = [i for i in range(len(relation[0]))]
    keys = list(cb(a, n))
    for key in keys:
        temp = []
        for i in range(len(relation)):
            b = []
            for j in key:
                if relation[i][j] not in b:
                    b.append(relation[i][j])
            if b not in temp:
                temp.append(b)
        if len(temp) == len(relation):
            add = True
            for ckey in candidate_key:
                count = 0
                for k in range(len(ckey)):
                    if ckey[k] in key: 
                        count += 1
                if count == len(ckey):
                    add = False
            
            if add:
                candidate_key.append(key)


def solution(relation):
    for i in range(1, len(relation[0]) + 1):
        find_key(relation, i)
    return len(candidate_key)

