def solution(genres, plays):
    answer = []
    
    playlist = []
    visited = [False] * len(genres)
    for i in range(len(genres)):
        playlist.append((genres[i], plays[i], i))
    
    playlist.sort(key = lambda x : -int(x[1]))
    
    total_plays = {}
    for i in range(len(plays)):
        if genres[i] in total_plays:
            total_plays[genres[i]] += plays[i]
        else :
            total_plays[genres[i]] = plays[i]
    
    orders = []
    for key in total_plays:
        orders.append((key, total_plays[key]))
    
    orders.sort(key = lambda x : -int(x[1]))
    
    for i in range(len(orders)):
        count = 2
        cur_genre = orders[i][0]
        for j in range(len(plays)):
            if playlist[j][0] == cur_genre and visited[j] == False:
                visited[j] = True
                answer.append(playlist[j][2])
                count -= 1
                if count == 0:
                    break
                    
    return answer