import sys

while(True):
    s = sys.stdin.readline().rstrip('\n')
    stack = []
    check = 0
    if s == '.':
        False
        break
    else:
        for c in s:
            if c == '(' or c == '[':
                stack.insert(0,c)
            elif c == ')' or c == ']':
                if len(stack) == 0:
                    check = 1
                else:
                    ch = stack[0]
                    stack.pop(0)
                    if (ch == '(' and c != ')') or (ch == '[' and c != ']'):
                        check = 1
        if len(stack) != 0 or check == 1:
            print('no')
        elif len(stack) == 0 and check == 0:
            print('yes')
