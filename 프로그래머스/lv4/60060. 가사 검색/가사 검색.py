from bisect import bisect_left, bisect_right

def count_by_range(a, left, right):
    right_index = bisect_right(a, right)
    left_index = bisect_left(a, left)
    return right_index -left_index

words_list = []
reversed_words_list = []
for i in range(10001):
    words_list.append([])
    reversed_words_list.append([])

def solution(words, queries):
    answer = []

    for word in words:
        words_list[len(word)].append(word)
        reversed_words_list[len(word)].append(word[::-1])

    for i in range(10001):
        words_list[i].sort()
        reversed_words_list[i].sort()
    
    for query in queries:
        n = len(query)
        if query[0] == "?":
            result = count_by_range(reversed_words_list[n], query[::-1].replace("?", "a"), query[::-1].replace("?", "z"))
        else:
            result = count_by_range(words_list[n], query.replace("?", "a"), query.replace("?", "z"))

        answer.append(result)

    return answer