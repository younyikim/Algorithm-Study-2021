import re

# (\d+) : 정수 (10이상도 찾아줌)
# ([SDT]) : 'SDT' 인 문자
# ([*#]?) : '*#' 문자를 찾는데, ? -> 없을 수도 있음

def solution(dartResult):
    bonus = {'S' : 1, 'D' : 2, 'T' : 3}
    option = {'' : 1, '*' : 2, '#' : -1}

    p = re.compile('(\d+)([SDT])([*#]?)')
    dart = p.findall(dartResult)

    for i in range(len(dart)):
        if dart[i][2] == '*' and i > 0:
            dart[i-1] *= 2
        dart[i] = int(dart[i][0]) ** bonus[dart[i][1]] * option[dart[i][2]]

    answer = sum(dart)
    return answer