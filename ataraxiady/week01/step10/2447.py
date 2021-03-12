n = int(input())

stars = [['*' for i in range(n)] for i in range(n)]

def print_stars(n,stars):
    a = n // 3
    if n == 3:
        stars[1][1] = ' '
    else:
        print_stars(a,stars)
        # print('n=', n)
        # for i in range(n):
        #      for j in range(n):
        #         if i%3 == 1 and j%3 == 1:
        #             stars[i][j] = ' '


        #전체 큰 구멍(작은구멍 커버x)
        for i in range(n):
            for j in range(n):
                if (a <= i < a * 2) and (a <= j < a * 2):
                    # print('i=',i,'j=',j)
                    stars[i][j] = ' '

        for i in range(n // 3):
            for j in range(n // 3):
                if stars[i][j] == ' ':
                    stars[i][j + n // 3] = ' '
                    stars[i][j + 2 * n // 3] = ' '
                    stars[i + n // 3][j] = ' '
                    stars[i + n // 3][j + 2 * n // 3] = ' '
                    stars[i + 2 * n // 3][j] = ' '
                    stars[i + 2 * n // 3][j + n // 3] = ' '
                    stars[i + 2 * n // 3][j + 2 * n // 3] = ' '

print_stars(n,stars)

for i in range(n):
    for j in range(n):
        print(stars[i][j], end="")
    print()
