from sys import stdin

input = stdin.readline
m = int(input())

bitmask = 0
for i in range(m): 
    b = list(input().rstrip().split())
    k = 0 
    oper = b[0]
    if len(b) == 2:
        k = int(b[1])
    
    if oper == "add":
        bitmask |= (1 << k)
    elif oper == "remove":
        bitmask &= ~(1 << k)
    elif oper == "check":
        print(1 if bitmask & (1 << k) else 0)
    elif oper == "toggle":
        bitmask ^= (1 << k)
    elif oper == "all":
        bitmask = (1 << 21) - 1
    elif oper == "empty":
        bitmask = 0