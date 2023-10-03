n = str(input())
dict = {}
for i in range(len(n)):
    if n[i] == "6" or n[i] == "9":
        if "11" in dict:
            dict["11"] += 1
        else:
            dict["11"] = 1
    else:    
        if n[i] in dict:
            dict[n[i]] += 1
        else:
            dict[n[i]] = 1

m = 0
now = 0
for i in range(12):
    if str(i) in dict and dict[str(i)] > m:
        m = dict[str(i)]
        now = i

if now == 11:
    if m % 2 == 0:
        print(m // 2)
    else:
        print(m // 2 + 1)
else:
    print(m)