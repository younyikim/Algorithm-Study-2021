import sys

N = (int)(input())
matrix = []

white_num, blue_num = 0,0

for _ in range(N):
    matrix.append(list(map(int, sys.stdin.readline().strip().split())))

print(matrix)

def cut(x, y, n):
    color = matrix[x][y]
    global white_num
    global blue_num

    for i in range(x,x+n):
        for j in range(y,y+n):
            if matrix[i][j] != color:
                cut(x,y,n//2)
                cut(x,y+n//2,n//2)
                cut(x+n//2,y,n//2)
                cut(x+n//2,y+n//2,n//2)
                return

    if color == 1:
        blue_num += 1
    else:
        white_num += 1

cut(0,0,N)
print(white_num, blue_num)