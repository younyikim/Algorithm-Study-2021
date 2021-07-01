# 뱀
import collections

n = int(input()) # 보드의 크기
board = list() # 보드 (n * n)
for _ in range(n):
    board.append([0]*n)

k = int(input()) # 사과의 개수
for _ in range(k):
    r, c = map(int, input().split()) # 행, 열
    board[r-1][c-1] = 1 # 사과의 위치 1로 표기


l = int(input()) # 뱀의 방향 변환 횟수
d_arr = list()
for _ in range(l):
    d_arr.append(list(map(str, input().split()))) # 초, 방향


d_index = 0 # 방향전환 인덱스
snake_direction = [1, 2, 3, 4] # 현재 뱀의 방향 (동 남 서 북)
sd_index = 0 # 뱀의 방향 인덱스

snake = collections.deque() # 뱀 표시
snake.append([0,0]) # 초기 위치
snake_len = 1 # 뱀의 몸길이
cnt_time = 0 # 초 카운트

while 1:

    # 초 증가
    cnt_time += 1

    # 몸길이 늘리기

    head_r = snake[snake_len-1][0]
    head_c = snake[snake_len-1][1]

    if snake_direction[sd_index] == 1: # 동
        snake.append([head_r, head_c+1]) # 머리 늘리기
        snake_len += 1

    elif snake_direction[sd_index] == 2: # 남
        snake.append([head_r+1, head_c]) # 머리 늘리기
        snake_len += 1

    elif snake_direction[sd_index] == 3: # 서
        snake.append([head_r, head_c-1]) # 머리 늘리기
        snake_len += 1

    elif snake_direction[sd_index] == 4: # 북
        snake.append([head_r-1, head_c]) # 머리 늘리기
        snake_len += 1


    head_r = snake[snake_len-1][0]
    head_c = snake[snake_len-1][1]

    # 벽에 부딪히면 break
    if head_r >= n or head_c >= n or head_r < 0 or head_c < 0:
        break

    # 자기자신과 부딪히면 break
    flag = 0
    print(snake_len)
    for i in range(snake_len-1):
        if head_r == snake[i][0] and head_c == snake[i][1]:
            flag = 1
    if flag == 1:
        break

    # 사과 없애기
    if board[head_r][head_c] == 1:
        board[head_r][head_c] = 0
    else:
        snake.popleft()
        snake_len -= 1
     
    head_r = snake[snake_len-1][0]
    head_c = snake[snake_len-1][1]
    
    # 방향 전환
    if d_index < l:
        if cnt_time == int(d_arr[d_index][0]):
            if  d_arr[d_index][1] == 'D':
                sd_index += 1
                sd_index %= 4
            elif d_arr[d_index][1] == 'L':
                sd_index -= 1
                if sd_index < 0:
                    sd_index += 4
            d_index += 1
    
print(cnt_time)