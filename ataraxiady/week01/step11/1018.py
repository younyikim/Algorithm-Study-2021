n, m = map(int,input().split())
board = list()
num = list()
for _ in range(n):
    board.append(input())


for i in range(n-7):
    for j in range(m-7):
        w = 0
        b = 0
        for k in range(i, i+8):
            for l in range(j, j+8):
                if (k + l) % 2 == 0:
                    if board[k][l] != 'W':
                        w = w + 1
                    if board[k][l] != 'B':
                        b = b + 1
                else:
                    if board[k][l] != 'W':
                        b = b + 1
                    if board[k][l] != 'B':
                        w = w + 1
        num.append(w)
        num.append(b)
print(min(num))
