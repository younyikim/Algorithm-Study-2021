import sys

N = (int)(input())
matrix = []

for _ in range(N):
    matrix.append(list(map(int, sys.stdin.readline().split())))

one_count = 0
zero_count = 0
minus_count = 0

def cut(x,y,n):
    number = matrix[x][y]

    global one_count, zero_count, minus_count
    
    for i in range(x, x+n):
        for j in range(y, y+n):
            if matrix[i][j] != number:
                cut(x,y,n//3)
                cut(x,y+n//3,n//3)
                cut(x,y+2*n//3,n//3)
                cut(x+n//3,y,n//3)
                cut(x+n//3,y+n//3,n//3)
                cut(x+n//3,y+2*n//3,n//3)
                cut(x+2*n//3,y,n//3)
                cut(x+2*n//3,y+n//3,n//3)
                cut(x+2*n//3,y+2*n//3,n//3)                
                return

    if number == 1:
        one_count += 1
    elif number == 0:
        zero_count += 1
    else:
        minus_count += 1

cut(0,0,N)

print(minus_count)
print(zero_count)
print(one_count)