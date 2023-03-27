def solution(my_string):
    answer = ["a", "e", "i", "o", "u"]
    for v in answer:
        my_string = my_string.replace(v, "")
    return my_string