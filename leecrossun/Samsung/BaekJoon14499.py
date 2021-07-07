# 주사위 굴리기
N, M, x, y, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
commands = list(map(int, input().split()))
dx, dy = (0, 0, -1, 1), (1, -1, 0, 0)
dice, temp = [0]*6, [0]*6
direction = [
    (2, 0, 5, 3, 4, 1),
    (1, 5, 0, 3, 4, 2),
    (4, 1, 2, 0, 5, 3),
    (3, 1, 2, 5, 0, 4)
]

for command in commands:
    command -= 1
    x, y = x + dx[command], y + dy[command]
    if x < 0 or x >= N or y < 0 or y >= M:
        x, y = x - dx[command], y - dy[command]
        continue
    for idx in range(6):
        temp[idx] = dice[idx]
    for idx in range(6):
        dice[idx] = temp[direction[command][idx]]
    if board[x][y]:
        dice[5] = board[x][y]
        board[x][y] = 0
    else:
        board[x][y] = dice[5]
    print(dice[0])