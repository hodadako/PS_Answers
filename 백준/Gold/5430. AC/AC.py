t = int(input())
for i in range(t):
    oper = str(input())
    n = int(input())
    string = str(input()).replace("[", "").replace("]","")
    nums = list(map(str, string.split(",")))
    status = 1
    remove_index = 0
    r_count = 0
    for i in range(len(oper)):
        if oper[i] == "R":
            if remove_index == 0:
                remove_index = -1
            else:
                remove_index = 0 
            r_count += 1
        else :
            if n == 0 or len(nums) == 0:
                status = 0
            else:
                nums.pop(remove_index)

    if status == 0:
        print("error")
    else:
        if r_count % 2 == 0:
            pass
        else:
            nums.reverse()
        answer = "["
        answer += ",".join(nums)
        answer += "]"
        print(answer)