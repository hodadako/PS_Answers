import sys

def count_presses(cur_num, target_num):
    return abs(target_num - cur_num) + len(str(cur_num))

def is_possible(num, broken_buttons):
    for b in str(num):
        if int(b) in broken_buttons:
            return False
    return True

def find_minimum_presses(target_num, broken_buttons):
    cur_num = 100
    answer = abs(target_num - cur_num)

    for i in range(1, 7):
        for j in range(10 ** i):
            if is_possible(j, broken_buttons):
                answer = min(answer, count_presses(j, target_num))
    return answer

if __name__ == "__main__":
    target_num = int(sys.stdin.readline().rstrip())
    num_of_broken_buttons = int(sys.stdin.readline().rstrip())

    if num_of_broken_buttons != 0:
        broken_buttons = list(map(int, sys.stdin.readline().rstrip().split()))
    else:
        broken_buttons = []

    answer = find_minimum_presses(target_num, broken_buttons)
    print(answer)
