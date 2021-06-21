def cal(numbers, num):
    if numbers == num:
        dis = 0
    elif numbers == 2:
        if num == 1 or num == 3 or num == 5:
            dis = 1
        elif num == 4 or num == 6 or num == 8:
            dis = 2
        elif num == 7 or num == 9 or num == 0:
            dis = 3
        else:
            dis = 4

    elif numbers == 5:
        if num == 2 or num == 4 or num == 6 or num == 8:
            dis = 1
        elif num == 1 or num == 3 or num == 7 or num == 9 or num == 0:
            dis = 2
        else:
            dis = 3

    elif numbers == 8:
        if num == 5 or num == 7 or num == 9 or num == 0:
            dis = 1
        elif num == 2 or num == 4 or num == 6 or num == -1:
            dis = 2
        else:
            dis = 3

    else:
        if num == -1 or num == 8:
            dis = 1
        elif num == 5 or num == 7 or num == 9:
            dis = 2
        elif num == 2 or num == 4 or num == 6:
            dis = 3
        else:
            dis = 4

    return dis


def solution(numbers, hand):
    answer = ''
    L = -1
    R = -1

    if hand == "right":
        hand = 'R'
    else:
        hand = 'L'

    for i in numbers:
        if i == 1 or i == 4 or i == 7:
            L = i
            answer = answer + 'L'
        elif i == 3 or i == 6 or i == 9:
            R = i
            answer = answer + 'R'
        else:
            # print('L: %d R: %d' %(L,R))
            dis_L = cal(i, L)
            dis_R = cal(i, R)

            if dis_L < dis_R:
                L = i
                answer = answer + 'L'
            elif dis_L > dis_R:
                R = i
                answer = answer + 'R'
            else:
                if hand == 'R':
                    R = i
                else:
                    L = i
                answer = answer + hand


    return answer



# print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))