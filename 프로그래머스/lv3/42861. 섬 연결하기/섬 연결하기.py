parent = [0] * 101

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, costs):
    answer = 0
    for i in range(101):
        parent[i] = i
    costs.sort(key = lambda x : (int(x[2])))
    for i in range(len(costs)):
        a, b, cost = costs[i]
        if find_parent(a) != find_parent(b):
            union_parent(a, b)
            answer += cost
    return answer