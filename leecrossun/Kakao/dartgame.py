# 다트 게임
def solution(dartResult):
    answer = 0
    # 1) 영역 - S, D, T : 1제곱, 2제곱, 3제곱
    # 2) 옵션 - * (2배) / # (마이너스)
    point = []
    size = len(dartResult)
    score = ''
    index = -1
    for s in dartResult:
        if s in ['S', 'D', 'T']:
            index += 1
            if s == 'S':
                point.append(int(score))
            elif s == 'D':
                point.append(int(score)**2)
            else:
                point.append(int(score)**3)
            score = ''
        elif s in ['*', '#']:
            if s == '*':
                point[index] *= 2
                if index > 0:
                    point[index-1] *= 2

            else:
                point[index] *= -1
        else:
            score += s    
    for p in point:
        answer += p
    return answer

dartResult = input()
print(solution(dartResult))
