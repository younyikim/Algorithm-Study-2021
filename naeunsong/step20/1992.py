import sys

N = (int)(input())
matrix = []

for _ in range(N):
    matrix.append(list(map(int, input())))

def compress(x,y,n):
    color = matrix[x][y]

    for i in range(x, x+n):
        for j in range(y, y+n):
            if matrix[i][j] != color:
                print('(',end='')
                compress(x,y,n//2)
                compress(x,y+n//2,n//2)
                compress(x+n//2,y,n//2)
                compress(x+n//2,y+n//2,n//2)
                print(')',end='')
                return
    
    if color == 1:
        print(1, end='')
    else:
        print(0, end='')

compress(0,0,N)
print('\n')