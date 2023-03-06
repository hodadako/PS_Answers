def right(string):
    while "()" in string:
        string = string.replace("()",  "")
    if len(string) == 0:
        return True
    else:
        return False
    
def balanced(string):
    count = 0
    for i in range(len(string)):
        if string[i] == "(":
            count += 1
        else:
            count -= 1
        if count == 0:
            return i

def solution(p):
    answer = ""
    if p == "" :
        return answer
    index = balanced(p)
    u = p[:index + 1]
    v = p[index + 1:]
    if right(u):
        answer = u + solution(v)
    else:
        answer += "("
        answer += solution(v)
        answer += ")"
        b = list(u[1:-1])
        for i in range(len(b)):
            if b[i] == "(":
                b[i] = ")"
            else:
                b[i] = "("
        answer += "".join(b)
    return answer