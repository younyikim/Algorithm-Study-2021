def solution(info, query):
    answer = []

    for j in range(len(info)):
        i = info[j]
        i = i.split(" ")
        i = list(map(lambda x: int(x) if x.isnumeric() else x[0], i))
        info[j] = i

    for k in range(len(query)):
        q = query[k]
        q = q.replace(' and', '')
        q = q.split(' ')
        q = list(map(lambda x: int(x) if x.isnumeric() else x[0], q))
        query[k] = q

    for q in query:
        match_count = 0
        for i in info:
            condition_flag = False
            for j in range(4):  # 5개 조건
                if q[j] != '-' and q[j] != i[j]:
                    break
                if j == 3:
                    condition_flag = True
            if condition_flag and i[4] >= int(q[4]):
                match_count += 1
        answer.append(match_count)

    return answer



print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],
               ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))