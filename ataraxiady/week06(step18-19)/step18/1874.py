import sys

n = int(sys.stdin.readline())
stack = []
op = []
count = 1
temp = True

for _ in range(n):
    num = int(sys.stdin.readline())
    while count <= num:
        stack.append(count)
        op.append('+')
        count = count + 1
    if stack[-1] == num:
        stack.pop()
        op.append('-')
    else:
        temp = False

if temp == False:
    print('NO')
else:
    for i in op:
        print(i)