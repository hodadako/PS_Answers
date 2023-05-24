from itertools import product as pr

def total(users, discount, emoticons):
    count, price = 0, 0
    
    for i in range(len(users)):
        cur_total = 0
        for j in range(len(emoticons)):
            if users[i][0] <= discount[j]:
                cur_total += emoticons[j] / 100 * (100 - discount[j])
        
        if cur_total >= users[i][1]:
            count += 1
        else:
            price += cur_total
    
    return [count, price]

def solution(users, emoticons):
    answer = [0, 0]
    types = [10, 20, 30, 40]
    a = list(pr(types,repeat=len(emoticons)))
    
    for i in range(len(a)):
        discount = a[i]
        tmp = total(users, discount, emoticons)
        if tmp[0] > answer[0]:
            answer = tmp
        elif tmp[0] == answer[0]:
            if tmp[1] > answer[1]:
                answer = tmp

    answer[1] = int(answer[1])
    return answer