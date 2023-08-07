def solution(sequence, k):
    sequence.append(int(1e6))
    n = len(sequence)
    
    interval_sum = 0
    s, e = 0, 0
    k_seq = []
    
    while e < n:
        if interval_sum >= k:
            interval_sum -= sequence[s]
            s += 1
        elif interval_sum < k:
            interval_sum += sequence[e]
            e += 1
        
        if interval_sum == k:
            k_seq.append((s, e - 1, e - s))
    
    k_seq.sort(key = lambda x : int(x[2]))
    return [k_seq[0][0], k_seq[0][1]]