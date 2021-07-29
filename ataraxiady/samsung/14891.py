import sys

def rotate(n,d):
    isRotate = [False for i in range(4)]
    direction = [0 for i in range(4)]
    isRotate[n] = True
    direction[n] = d
    tempn = n
    tempd = d

    # 변경 톱니바퀴 오른쪽 톱니바퀴들 체크
    for i in range(n + 1, 4):
        if status[tempn][2] != status[i][6]:
            isRotate[i] = True
            tempd = -tempd
            direction[i] = tempd
            tempn = i
        else:
            break

    # 변경 톱니바퀴 왼쪽 톱니바퀴 변경
    tempn = n
    tempd = d
    for i in range(n - 1, -1, -1):
        if status[tempn][6] != status[i][2]:
            isRotate[i] = True
            tempd = -tempd
            direction[i] = tempd
            tempn = i
        else:
            break

    # rotate 결과 반영 리스트
    for i in range(4):
        if isRotate[i]:
            if direction[i] == 1:
                temp = status[i].pop()
                status[i] = [temp] + status[i]
            else:
                temp = status[i][0]
                del status[i][0]
                status[i].append(temp)

status = []
for i in range(4):
    status.append(list(sys.stdin.readline().strip()))

k = int(sys.stdin.readline())
rotation = []
for i in range(k):
    num, direction = map(int, sys.stdin.readline().split())
    rotation.append([num-1, direction])

for n, d in rotation:
    rotate(n,d)

# 점수 계산
result = 0
for i in range(4):
    if status[i][0] == "1":
        result += 2 ** i
print(result)