# 수식 최대화
import re, itertools, copy
def operate(n1, n2, op):
    n1 = int(n1)
    n2 = int(n2)
    if op == '+':
        return n1 + n2
    elif op == '-':
        return n1 - n2
    elif op == '*':
        return n1 * n2

def calc(ops, op, numbers):
    size = len(ops)
    for i in range(size):
        if ops[i] == op:
            numbers[i+1] = operate(numbers[i], numbers[i+1], op)
            numbers[i] = " "
            ops[i] = " "

    while " " in numbers:
        numbers.remove(" ")
    while " " in ops:
        ops.remove(" ")
    


def solution(expression):
    answer = 0
    ops = re.findall('\W+' , expression)
    numbers = re.split('\W+' , expression)

    temp_o = copy.deepcopy(ops)
    temp_n = copy.deepcopy(numbers)
    order = (list(map(''.join, itertools.permutations(['*', '+', '-']))))

    for o in order:
        for op in o:
            calc(temp_o, op, temp_n)
        temp = temp_n[0]
        temp_n = copy.deepcopy(numbers)
        temp_o = copy.deepcopy(ops)

        answer = max(answer, abs(int(temp)))
    return answer

print(solution("100-200*300-500+20"))
print(solution("50*6-3*2"))