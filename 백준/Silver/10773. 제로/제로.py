import sys

n = int(sys.stdin.readline().rstrip())
stack = []

for i in range(n):
    num = int(sys.stdin.readline().rstrip())
    if not num:
        stack.pop()
    else:
        stack.append(num)

print(sum(stack))