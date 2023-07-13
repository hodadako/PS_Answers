s = input()
s_check = [-1 for _ in range(120)]

for i in range(len(s)):
    if s_check[ord(s[i])-97] == -1:
        s_check[ord(s[i])-97] = i

for j in range(26):
    if j != 25:
        print(s_check[j],end=' ')
    else:
        print(s_check[j])