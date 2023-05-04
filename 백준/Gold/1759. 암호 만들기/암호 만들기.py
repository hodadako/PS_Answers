from itertools import combinations as cb
from string import ascii_lowercase

l, c = map(int, input().split())
abc = list(map(str, input().split()))

vowels = ["a", "e", "i", "o", "u"]
consonants = list(ascii_lowercase)
v_list = []
c_list = []
for a in abc:
    if a in vowels:
        v_list.append(a)
    if a in consonants and a not in vowels:
        c_list.append(a)


pwd_pos = list(cb(abc, l))

result = []
for i in range(len(pwd_pos)):
    chars = []
    for j in range(l):
        chars.append(pwd_pos[i][j])
    chars.sort()
    v_count = 0
    c_count = 0
    for k in chars:
        if k in v_list:
            v_count += 1
        if k in c_list:
            c_count += 1
    
    if v_count > 0 and c_count > 1:
        result.append("".join(chars))

result.sort()
for i in range(len(result)):
    print(result[i])