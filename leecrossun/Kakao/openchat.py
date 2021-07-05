# 오픈채팅방
def solution(record):
    answer = []
    command = []
    enter = "님이 들어왔습니다."
    leave = "님이 나갔습니다."
    user = {}
    for r in record:
        command.append(r.split())
    
    for c in command:
        if c[0] in ["Enter", "Change"]:
            user[c[1]] = c[2]
    
    for c in command:
        if c[0] == "Enter":
            answer.append(user[c[1]] + enter)
        elif c[0] == "Leave":
            answer.append(user[c[1]] + leave)

    return answer

record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
print(solution(record))