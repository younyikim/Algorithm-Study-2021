n = (int)(input())

arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))

max_num = max(map(max,arr))

if n == 1:
    print(arr[0][0])

def right_btn():
    # 오른쪽 버튼
    for i in range(n):
        for j in range(n-1,0,-1):
            if arr[i][j] == arr[i][j-1] and arr[i][j] != 0:
                arr[i][j] += arr[i][j-1]
                arr[i][j-1] = 0

                tmp = j - 1
                # 남은 것들 옮겨오기
                while tmp > 0:
                    arr[i][tmp] = arr[i][tmp-1]
                    tmp -= 1
                arr[i][tmp] = 0

        flag = 0
        # 앞으로 땡겨주기
        for j in range(n):
            if arr[i][j] != 0:
                flag = 1
                break

        if flag == 1:
            while arr[i][n-1] == 0:
                tmp = n-1
                while tmp > 0:
                    arr[i][tmp] = arr[i][tmp - 1]
                    tmp -= 1
                arr[i][tmp] = 0

    print(arr)



def left_btn():
    # 왼쪽 버튼
    for i in range(n):
        for j in range(0,n-1):
            if arr[i][j] == arr[i][j+1] and arr[i][j] != 0:
                arr[i][j] += arr[i][j+1]
                arr[i][j+1] = 0

                tmp = j + 1
                # 남은 것들 옮겨오기
                while tmp < n-1:
                    arr[i][tmp] = arr[i][tmp + 1]
                    tmp += 1
                arr[i][tmp] = 0


        flag = 0
        # 앞으로 땡겨주기
        for j in range(n):
            if arr[i][j] != 0:
                flag = 1
                break

        if flag == 1:
            # 앞으로 땡겨주기
            while arr[i][0] == 0:
                tmp = 0
                while tmp < n-1:
                    arr[i][tmp] = arr[i][tmp + 1]
                    tmp += 1
                arr[i][tmp] = 0

    # print(arr)



def down_btn():
    # 아래 버튼
    for j in range(n):
        for i in range(n-1, 0, -1):
            if arr[i][j] == arr[i-1][j]:
                arr[i][j] += arr[i-1][j]
                arr[i-1][j] = 0

                tmp = i - 1
                # 남은 것들 옮겨오기
                while tmp > 0:
                    arr[tmp][j] = arr[tmp-1][j]
                    tmp -= 1
                arr[tmp][j] = 0

        flag = 0
        # 앞으로 땡겨주기
        for i in range(n):
            if arr[i][j] != 0:
                flag = 1
                break

        if flag == 1:
            while arr[n-1][j] == 0:
                tmp = n-1
                while tmp > 0:
                    arr[tmp][j] = arr[tmp - 1][j]
                    tmp -= 1
                arr[tmp][j] = 0

    print(arr)


def up_btn():
    # 위 버튼
    for j in range(n):
        for i in range(0, n-1):
            if arr[i][j] == arr[i+1][j]:
                arr[i][j] += arr[i+1][j]
                arr[i+1][j] = 0

                tmp = i + 1
                # 남은 것들 옮겨오기
                while tmp < n-1:
                    arr[tmp][j] = arr[tmp+1][j]
                    tmp += 1
                arr[tmp][j] = 0

        flag = 0
        # 앞으로 땡겨주기
        for i in range(n):
            if arr[i][j] != 0:
                flag = 1
                break

        if flag == 1:
            while arr[0][j] == 0:
                tmp = 0
                while tmp < n-1:
                    arr[tmp][j] = arr[tmp + 1][j]
                    tmp += 1
                arr[tmp][j] = 0

    # print(arr)

def control(key):

    if key == 1:
        right_btn()
    elif key == 2:
        left_btn()
    elif key == 3:
        down_btn()
    elif key == 4:
        up_btn()


def answer(key, total, max_num):

    tmp = max(map(max, arr))
    if tmp > max_num:
        max_num = tmp

    if total > 5:
        return max_num

    if key == 1:
        right_btn()
    elif key == 2:
        left_btn()
    elif key == 3:
        down_btn()
    elif key == 4:
        up_btn()

    a = answer(1, total + 1, max_num)
    #b = answer(2, total + 1, max_num)
    c = answer(3, total + 1, max_num)
    #d = answer(4, total + 1, max_num)

    return max(a,c)

print(answer(0,0,max_num))



