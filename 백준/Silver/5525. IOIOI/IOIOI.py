import sys
input = sys.stdin.readline

n = int(input().rstrip())
m = int(input().rstrip())
s = str(input().rstrip())

p_1 = "I"
for i in range(n):
    p_1 += "OI"

result = 0
for i in range(m - len(p_1) + 1):
    if s[i:i + len(p_1)] == p_1:
        result += 1

print(result)