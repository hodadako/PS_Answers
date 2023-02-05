from collections import deque

n = int(input())
k = int(input())

graph = [[0] * (n + 1) for _ in range(n + 1)]

for _ in range(k):
  a, b = map(int, input().split())
  graph[a][b] = 1

direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]

def turn(d, s):
  if s == 'D':
    d = (d + 1) % 4
  else:
    d = (d - 1) % 4
  
  return d
    
move = []
l = int(input())
for _ in range(l):
  x, c = input().split()
  move.append((int(x), c))

time = 0
d = 0
q = deque()
now = [1, 1]
q.append(now)
cnt = 0
current_dir = direction[d]

while True:
  loc = [q[0][0] + current_dir[0], q[0][1] + current_dir[1]]

  if loc[0] >= 1 and loc[1] >= 1 and loc[0] <= n and loc[1] <= n and loc not in q:
    a = q.pop()
    q.appendleft(loc)
    if graph[q[0][0]][q[0][1]] == 1:
      graph[q[0][0]][q[0][1]] = 0
      q.append(a)
    else:
      pass
  else:
    time += 1
    break

  time += 1
  if cnt < l and time == move[cnt][0]:
    d = turn(d, move[cnt][1])
    current_dir = direction[d]
    cnt += 1

print(time)