def solution(bridge_length, weight, truck_weights):
    answer = 0
    n = len(truck_weights)
    bridge = [0] * bridge_length
    visited = [False] * n
    total = sum(truck_weights)
    
    index = 0
    cur = 0
    passed = 0
    left = True
    ## 2 10 [7, 7, 7, 7]과 같은 최악의 경우에 걸리는 시간은 (다리의 길이) X (총 트럭의 수) + 1이다.
    for i in range(bridge_length * n + 1):
        #이미 지나간 트럭의 무게와 총 트럭의 무게가 같으면
        if passed == total:
            break
        # 현재 다리 위에 아무것도 없고 남은 차량이 있다면
        if cur == 0 and left and visited[index] == False :
            bridge[bridge_length - 1] = truck_weights[index]
            cur += truck_weights[index]
            visited[index] = True
            # 마지막 차량보다 앞에 있는 순서의 차량일 경우
            if index < n - 1: 
                index += 1
        #다리 위에 트럭이 있으면
        else:
            tmp = bridge[0] #나가야할 차량을 내보내고
            if tmp > 0:
                cur -= tmp
                passed += tmp
            for i in range(1, bridge_length):
                bridge[i - 1] = bridge[i]
            bridge[bridge_length - 1] = 0
            # 다음에 들어올 차량의 무게와 현재 다리위에 있는 차량들의
            # 무게의 합이 다리가 견딜 수 있는 총 중량보다 작거나 같으면
            if cur + truck_weights[index] <= weight:
                #남은 차량이 있다면
                if left and visited[index] == False:
                    bridge[bridge_length - 1] = truck_weights[index]
                    cur += truck_weights[index]
                    visited[index] = True
                    if index < n - 1:
                        index += 1
                        
        #시간 재기
        answer += 1
        
        #마지막 차량이 다리위에 올라왔으면 남은 차량 없음
        if visited[n - 1]:
            left = False

    return answer