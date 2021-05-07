import sys

n = int(sys.stdin.readline())

for _ in range(n):
    stack = []
    check = 0
    p = sys.stdin.readline()
    for i in p:
        if i == '(':
            stack.insert(0,i)
        elif i == ')':
            if len(stack) == 0:
                check = 1
                break
            else:
                stack.pop(0)

    if len(stack) != 0 or check == 1:
        print('NO')
    elif len(stack) == 0 and check == 0:
        print('YES')