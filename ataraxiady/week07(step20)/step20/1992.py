import sys

n = int(sys.stdin.readline())
quadTree = []

for _ in range(n):
    quadTree.append(list(map(int,sys.stdin.readline().strip())))

def check(n, i, j):

    s = quadTree[i][j]

    for ii in range(i, i + n):
        for jj in range(j, j + n):
            if quadTree[ii][jj] != s:
                print('(',end='')
                check(n // 2, i, j)
                check(n // 2, i, j + (n // 2))
                check(n // 2, i + (n // 2), j)
                check(n // 2, i + (n // 2), j + (n // 2))
                print(')',end='')
                return
    if s == 0:
        print('0', end='')
        return
    else:
        print('1', end='')
        return


check(n, 0, 0)
