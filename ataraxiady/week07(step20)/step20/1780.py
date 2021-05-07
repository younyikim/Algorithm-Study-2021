import sys

n = int(sys.stdin.readline())
paper = []
zero = 0
positive_one = 0
negative_one = 0

for _ in range(n):
    paper.append(list(map(int,sys.stdin.readline().split())))

def check(n,i,j):
    global zero, positive_one, negative_one
    s = paper[i][j]

    for ii in range(i, i + n):
        for jj in range(j, j + n):
            # 분할 지점 (Divide)
            if paper[ii][jj] != s:
                check(n // 3, i, j)
                check(n // 3, i + (n // 3), j)
                check(n // 3, i + 2 * (n // 3), j)
                check(n // 3, i, j + (n // 3))
                check(n // 3, i + (n // 3), j + (n // 3))
                check(n // 3, i + 2 * (n // 3), j + (n // 3))
                check(n // 3, i, j + 2 * (n // 3))
                check(n // 3, i + (n // 3), j + 2 * (n // 3))
                check(n // 3, i + 2 * (n // 3), j + 2 * (n // 3))
                return
    if s == 0:
        zero += 1
        return
    elif s == 1:
        positive_one += 1
        return
    else:
        negative_one += 1
        return


check(n,0,0)
print(negative_one)
print(zero)
print(positive_one)
