def solution(new_id):
    answer = new_id

    # 1단계 (대문자->소문자)
    answer = answer.lower()
    # 2단계 (불필요한 문자 제거)
    answer = answer.replace('!','')
    answer = answer.replace('@','')
    answer = answer.replace('#','')
    answer = answer.replace('$','')
    answer = answer.replace('%','')
    answer = answer.replace('^','')
    answer = answer.replace('&','')
    answer = answer.replace('*','')
    answer = answer.replace('(','')
    answer = answer.replace(')','')
    answer = answer.replace('=','')
    answer = answer.replace('+','')
    answer = answer.replace('[','')
    answer = answer.replace('{', '')
    answer = answer.replace(']', '')
    answer = answer.replace('}', '')
    answer = answer.replace(':', '')
    answer = answer.replace('?', '')
    answer = answer.replace(',', '')
    answer = answer.replace('<', '')
    answer = answer.replace('>', '')
    answer = answer.replace('/', '')
    answer = answer.replace('~', '')

    # 3단계 (마침표 개수 줄이기)
    while '..' in answer:
        answer = answer.replace('..','.')

    # 4단계 (마침표 위치)
    if len(answer) != 0:
        while answer[0] == '.':
            if len(answer) <= 1:
                answer = ''
                break
        # if answer[0] == '.':
            answer = answer[1:]

    if len(answer) != 0:
        while answer[len(answer)-1] == '.':
            if len(answer) <= 1:
                answer = ''
        # if answer[len(answer)-1] == '.':
            answer = answer[:len(answer)-1]

    # 5단계 (빈문자열에 a 대입)
    if len(answer) == 0:
        answer = 'a'
    # 6단계 (길이조정)
    if len(answer) >= 16:
        answer = answer[:15]
        while answer[len(answer)-1] == '.':
        # if answer[14] == '.':
            answer = answer[:len(answer)-1]
    # 7단계 (길이조정)
    while len(answer) <= 2:
        answer = answer + answer[len(answer)-1]


    return answer



# print(solution('......a......a......a....'))
