import sys

n = int(sys.stdin.readline())
paper = []
w = 0
b = 0

for _ in range(n):
    paper.append(list(map(int,sys.stdin.readline().split())))

def check(n,i,j):
    global w,b
    s = paper[i][j]

    for ii in range(i, i + n):
        for jj in range(j, j + n):
            # 분할 지점 (Divide)
            if paper[ii][jj] != s:
                check(n // 2, i, j)
                check(n // 2, i, j + (n // 2))
                check(n // 2, i + (n // 2), j)
                check(n // 2, i + (n // 2), j + (n // 2))
                return
    if s == 0:
        w = w + 1
        return
    else:
        b = b + 1
        return


check(n,0,0)
print(w)
print(b)
