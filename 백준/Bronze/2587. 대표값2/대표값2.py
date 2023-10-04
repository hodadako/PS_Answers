a = []
total = 0
for i in range(5):
    b = int(input())
    total += b
    a.append(b)
    
a.sort()
print(total // 5)
print(a[2])