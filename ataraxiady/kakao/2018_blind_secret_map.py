def solution(n, arr1, arr2):
    answer = []
    map1 = []
    map2 = []

    for i in arr1:
        bin = format(i, 'b')
        while len(bin) != n:
            bin = '0' + bin
        map1.append(bin)
    for i in arr2:
        bin = format(i, 'b')
        while len(bin) != n:
            bin = '0' + bin
        map2.append(bin)


    for i in range(n):
        code = ''
        for j in range(n):
            if map1[i][j] == '1' or map2[i][j] == '1':
                code += '#'
            else:
                code += ' '
        answer.append(code)

    return answer


# print(solution(5,	[9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))