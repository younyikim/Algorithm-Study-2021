from collections import deque

def solution(n, k, cmd):
    answer = ["O"] * n
    delete = deque()

    for c in cmd:
        # print("command : ", c)
        # print(answer)
        if c == "C":
            answer[k] = "X"
            delete.append(k)

            flag = 0
            for i in range(k+1,n):
                if answer[i] == 'O':
                    k = i
                    flag = 1
                    break
            if flag == 0: # 선택할 행이 없는 경우
                for j in range(k-1, -1, -1):
                    if answer[j] == "O":
                        k = j
                        break
        elif c == "Z":
            update = delete.pop()
            answer[update] = "O"
        else:
            c1, c2 = c.split(" ")
            if c1 == "D":
                cnt = int(c2)
                while 1:
                    k += 1
                    cnt -= 1
                    if answer[k] == 'X':
                        cnt += 1
                    if cnt == 0:
                        break
            elif c1 == "U":
                cnt = int(c2)
                while 1:
                    k -= 1
                    cnt -= 1
                    if answer[k] == 'X':
                        cnt += 1
                    if cnt == 0:
                        break

        # print("k : ", k)
        # print(delete)

    return ''.join(answer)


n1, k1, cmd1 = 8, 2, ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
n2, k2, cmd2 = 8, 2, ["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]
table = ["O"] * n1
#print(solution(n1, k1, cmd1))
print(solution(n2, k2, cmd2))

# n : 행개수 / k : 처음 행 / cmd : 명령어