import sys

x = list(sys.stdin.readline().strip('\n'))
y = list(sys.stdin.readline().strip('\n'))

x.insert(0,'0')
y.insert(0,'0')

m = len(x)
n = len(y)

c = [[0]* (n) for _ in range(m)]

for i in range(1,m):
    for j in range(1,n):
        if x[i] == y[j]:
            c[i][j] = 1 + c[i-1][j-1]
        else:
            c[i][j] = max(c[i-1][j], c[i][j-1])
        # elif c[i-1][j] > c[i][j-1]:
        #     c[i][j] = c[i-1][j]
        # else:
        #     c[i][j] = c[i][j-1]

print(c[m-1][n-1])