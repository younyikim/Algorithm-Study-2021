import sys
n = int(sys.stdin.readline())
#빈칸으로 배열 만들어두기
stars = [[' ' for i in range(n)] for i in range(n)]

def print_star(x,y,n,s):
    # size는 큰 9*9배열의 한 칸에 몇개의 작은 칸들이 들어가는지 계산하는 것이다.
    size = n // 3
    # 재귀의 끝. 더 이상 쪼갤 수 없는 블록일 때 빈칸대신 *을 넣어준다. 
    if n == 1:
        s[x][y] = '*'
        return
    # [0,0]칸
    print_star(x, y, size, s)
    # [0,1]칸
    print_star(x, y + size, size, s)
    # [0,2]칸
    print_star(x, y + size + size, size, s)

    # [1,0]칸
    print_star(x + size, y, size, s)
    # [1,1]칸은 늘 빈칸이므로 진행하지 않는다.

    # [1,2]칸
    print_star(x + size, y + size + size, size, s)

    # [2,0]칸
    print_star(x + size + size, y, size, s)
    # [2,1]칸
    print_star(x + size + size, y + size, size, s)
    # [2,2]칸
    print_star(x + size + size, y + size + size, size, s)

print_star(0,0,n,stars)

for i in range(n):
   print(''.join(stars[i]))

#
# def print_stars(n,stars):
#     a = n // 3
#     if n == 3:
#         stars[1][1] = ' '
#     else:
#         print_stars(a,stars)
#         # print('n=', n)
#         # for i in range(n):
#         #      for j in range(n):
#         #         if i%3 == 1 and j%3 == 1:
#         #             stars[i][j] = ' '
#
#
#         #전체 큰 구멍(작은구멍 커버x)
#         for i in range(n):
#             for j in range(n):
#                 if (a <= i < a * 2) and (a <= j < a * 2):
#                     # print('i=',i,'j=',j)
#                     stars[i][j] = ' '
#
#         for i in range(n // 3):
#             for j in range(n // 3):
#                 if stars[i][j] == ' ':
#                     stars[i][j + n // 3] = ' '
#                     stars[i][j + 2 * n // 3] = ' '
#                     stars[i + n // 3][j] = ' '
#                     stars[i + n // 3][j + 2 * n // 3] = ' '
#                     stars[i + 2 * n // 3][j] = ' '
#                     stars[i + 2 * n // 3][j + n // 3] = ' '
#                     stars[i + 2 * n // 3][j + 2 * n // 3] = ' '
#
# print_stars(n,stars)
#
# for i in range(n):
#     for j in range(n):
#         print(stars[i][j], end="")
#     print()
