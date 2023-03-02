def solution(cap, n, deliveries, pickups):
    answer = 0
    give = 0
    get = 0

    for i in range(n-1, -1, -1):
        if deliveries[i] != 0 or pickups[i] != 0:
            cnt = 0
            while give < deliveries[i] or get < pickups[i]:
                cnt +=1
                give += cap
                get  += cap
            give -= deliveries[i]
            get  -= pickups[i]
            answer += (i + 1) * cnt * 2
    
    return answer