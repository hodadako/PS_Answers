from collections import deque
import sys
input = sys.stdin.readline

t = int(input().strip())
for _ in range(t):
    n = int(input().strip())
    last_rank = list(map(int, input().strip().split()))
    graph = [[False] * (n + 1) for _ in range(n + 1)]
    indegree = [0] * (n + 1)

    # 등수가 더 뒤에 있으면 진입차수에 1을 더하고 가는 경로를 True로 만든다.
    for i in range(n):
        for j in range(i + 1, n):
            graph[last_rank[i]][last_rank[j]] = True
            indegree[last_rank[j]] += 1
    
    m = int(input().strip())
    for j in range(m):
        a, b = map(int, input().strip().split())
    
    # a의 등수가 더 뒤에 있다면
        if graph[a][b]:
            graph[a][b] = False
            graph[b][a] = True
            indegree[a] += 1
            indegree[b] -= 1
        else:
            graph[a][b] = True
            graph[b][a] = False
            indegree[a] -= 1
            indegree[b] += 1
            
    
    result = []
    q = deque()
    for i in range(1, n + 1):
        if indegree[i] == 0:
            q.append(i)

    certain = True
    cycle = False

    for i in range(n):
        if len(q) == 0:
            cycle = True
            break
        if len(q) >= 2:
            certain = False
            break
        now = q.popleft()
        result.append(now)
        for j in range(1, n + 1):
            if graph[now][j]:
                indegree[j] -= 1
                if indegree[j] == 0:
                    q.append(j)
        
    
    if cycle:
        print("IMPOSSIBLE")
    elif not certain:
        print("?")
    else:
        for i in range(len(result)):
            print(result[i], end = " ")
        print()

        
