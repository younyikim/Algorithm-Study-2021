# 테트로미노
import sys
sys.setrecursionlimit(10**6)
N, M = map(int, input().split())
num = [list(map(int, input().split())) for _ in range(N)]

rd = [0, 1, 0, -1]
cd = [1, 0, -1, 0]
visited = [[False] * M for _ in range(N)]

def tetromino(r, c, cnt):
    result = num[r][c]

    if cnt == 3:
        return result
    max = 0
    for i in range(4):
        move_r = r + rd[i]
        move_c = c + cd[i]
        if move_c >= 0 and move_c < M and move_r >= 0 and move_r < N:
            flag = 0
            if not visited[move_r][move_c]:
                visited[move_r][move_c] = True
                temp = tetromino(move_r, move_c, cnt+1)
                if temp > max:
                    max = temp
                visited[move_r][move_c] = False
    return result + max

def exception(r, c):
    result = [0]
    r_sum = c_sum = 0
    if c >= 1 and c <= M-2:
        c_sum += num[r][c] + num[r][c-1] + num[r][c+1]
    if r >= 1 and r <= N-2:
        r_sum += num[r][c] + num[r+1][c] + num[r-1][c]

    if r_sum != 0:
        if c+1 < M: # ㅏ
            result.append(r_sum + num[r][c+1])
        if c-1 >= 0: # ㅓ
            result.append(r_sum + num[r][c-1])
    
    if c_sum != 0:
        if r+1 < N: # ㅜ
            result.append(c_sum + num[r+1][c])
        if r-1 >= 0: # ㅗ
            result.append(c_sum + num[r-1][c])

    return max(result)

arr = list()
for i in range(N):
    for j in range(M):
        visited[i][j] = True
        arr.append(tetromino(i, j, 0))
        arr.append(exception(i, j))
        visited[i][j] = False

print(max(arr))
        