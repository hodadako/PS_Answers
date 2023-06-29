import math

def solution(r1, r2):
    big = 0
    for i in range(0, r2 + 1):
        y2 = math.sqrt(r2 ** 2 - i ** 2)
        big += math.floor(y2) + 1
        # for j in range(int(y2) + 1):
        #     print(i, j)
    
    # print("_____________________________")
    
    small = 0
    for i in range(1, r1):
        y1 = math.sqrt(r1 ** 2 - i ** 2)
        small += math.floor(y1) + 1
        # print(int(y1))
        # print(i)
        if (int(y1)) ** 2 + i ** 2 == r1 ** 2:
            small -= 1
        # for j in range(math.floor(y1) + 1):
        #     if (j) ** 2 + i ** 2 == r1 ** 2:
        #         pass
        #     else:
        #         print(i, j)
    
    s_total = (small) * 4 + 1
    b_total = (big - 1 - r2) * 4 + 1 
    print(s_total)
    return b_total - s_total