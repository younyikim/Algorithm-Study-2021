# 신규 아이디 추천
def solution(new_id):
    answer = ''

    # 1, 2단게
    new_id = new_id.lower()
    print("1",new_id)

    for s in new_id:
        if s.islower() or s.isdigit() or s == '-' or s == '_' or s == '.':
            answer += s

    print("2",answer)

    # 3단계
    flag = 0
    l = len(answer)
    temp = ""
    for i in range(l):
        if answer[i] == ".":
            flag = 1
        else:
            if flag == 1:
                flag = 0
                temp += "."
                temp += answer[i]
            else:
                temp += answer[i]
    answer = temp
    print("3",answer)

    # 4단계
    answer = answer.strip('.')
    print("4",answer)

    # 5단계
    if answer == "":
        answer += "a"
    print("5",answer)

    #6단계
    if len(answer) >= 16:
        answer = answer[:15]

    answer = answer.strip('.')
    print("6",answer)

    #7단계
    length = len(answer)

    for _ in range(3 - length):
        answer += answer[length-1]

    return answer

id = input()
print(solution(id))