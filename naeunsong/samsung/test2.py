main_q = deque()

for i in range(n):
    main_q.append(i)

for i in range(len(cmd)):
    if cmd[i][0] == 'D':
        select += int(cmd[i][2])

    elif cmd[i][0] == 'U':
        num = int(cmd[i][2])

        select -= num
    elif cmd[i][0] == 'C':
        answer[main_q[select]] = 'X'
        q.append(main_q[select])
        del main_q[select]

        if select == len(main_q):
            select -= 1

    elif cmd[i][0] == 'Z':
        pop_idx = q.pop()
        answer[pop_idx] = 'O'

        if pop_idx > max(main_q):
            main_q.append(pop_idx)
        else:
            for i in range(len(main_q)):
                if main_q[i] > pop_idx:
                    main_q.insert(i, pop_idx)
                    if i <= select:
                        select += 1
                    break