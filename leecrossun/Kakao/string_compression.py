# 문자열 압축
def zip(s, n):
    size = len(s)
    word = []
    for i in range(n, size+1, n):
        word.append(s[i-n:i])
        if i + n > size and s[i:] != '':
            word.append(s[i:])
    print(word)

    pre = ''
    cnt = 1
    result = ''
    for w in word:
        if pre == w:
            cnt += 1
        else:
            if cnt > 1:
                result += str(cnt) + pre
            else:
                result += pre
            pre = w
            cnt = 1
    if cnt > 1:
        result += str(cnt) + pre
    else:
        result += pre
    return result

def solution(s):
    answer = len(s)
    arr = []
    size = len(s)
    for i in range(1, size//2+1):
        arr.append(zip(s, i))
    
    for a in arr:
        l = len(a)
        if answer > l:
            answer = l

    return answer

s = input()
print(solution(s))