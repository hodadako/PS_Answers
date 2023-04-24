from heapq import heappush, heappop
import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def find_distance(a, b):
    cost = min(abs(a[0] - b[0]), abs(a[1] - b[1]), abs(a[2] - b[2]))
    return (cost, a[3], b[3])

planets = []
n = int(input().rstrip())
for i in range(n):
    x, y, z = map(int, input().rstrip().split())
    id = i
    planets.append((x, y, z, id))

planets_1 = sorted(planets, key = lambda x : (int(x[0])))
planets_2 = sorted(planets, key = lambda x : (int(x[1])))
planets_3 = sorted(planets, key = lambda x : (int(x[2])))

parent = [0] * (n + 1) 
for i in range(1, n + 1):
    parent[i] = i

result = 0
bridges = n - 1
distances = []
for i in range(n - 1):
    heappush(distances, find_distance(planets_1[i], planets_1[i + 1]))
    heappush(distances, find_distance(planets_2[i], planets_2[i + 1]))
    heappush(distances, find_distance(planets_3[i], planets_3[i + 1]))

for i in range(len(distances)):
    cost, a, b = heappop(distances)
    if find_parent(parent, a) != find_parent(parent, b) and bridges != 0:
        union_parent(parent, a, b)
        result += cost
        bridges -= 1
    if bridges == 0:
        break

print(result)