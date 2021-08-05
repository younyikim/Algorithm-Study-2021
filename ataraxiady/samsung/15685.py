import sys


# (0,1,2,3 규칙에서)전 세대들에 1을 더 하고 뒤집어준 방향으로 간다는 공통점이 있음.
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
n = int(sys.stdin.readline())
s = [[0] * 101 for i in range(101)]
for i in range(n):
    y, x, d, g = map(int, sys.stdin.readline().split())
    s[x][y] = 1
    temp = [d]
    q = [d]
    for _ in range(g + 1):
        for k in q:
            x += dx[k]
            y += dy[k]
            s[x][y] = 1
        q = [(i + 1) % 4 for i in temp]
        q.reverse()
        temp = temp + q
result = 0
for i in range(100):
        for j in range(100):
            if s[i][j] and s[i][j + 1] and s[i + 1][j] and s[i + 1][j + 1]:
                result += 1
print(result)