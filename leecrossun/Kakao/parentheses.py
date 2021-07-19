# 괄호변환
def correct(s):
    cnt = 0
    for i in s:
        if i == '(':
            cnt += 1
        else :
            cnt -= 1
            if cnt < 0 : return False
    return True

def balance(s):
    cnt = 0
    for i in s:
        if i == '(':
            cnt += 1
        else :
            cnt -= 1

    if cnt == 0:
        return True
    else:
        return False

def convert(s):
    ans = ''
    for i in s:
        if i == '(':
            ans += ')'
        else :
            ans += '('

    return ans
            

def solution(p):
    u = ''
    v = ''
    answer = ''
    
    if correct(p):
        return p

    for i in range(2, len(p)+1):
        if balance(p[:i]):
            u = p[:i]
            v = p[i:]
            break

    if correct(u):
        answer = u + solution(v)

    else :
        answer = ''
        answer += '('
        answer += solution(v)
        answer += ')'
        answer += convert(u[1:-1])

    return answer