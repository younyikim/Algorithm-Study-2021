def solution(N, stages):
    answer = []
    result = []

    for i in range(1, N+1):
        numerator = 0
        denominator = 0
        for j in stages:
            if i <= j:
                numerator += 1
            if i == j:
                denominator += 1
        # 스테이지 도전자 0일 경우 예외처리
        if numerator == 0 or denominator == 0:
            result.append([i, 0])
        else:
            result.append([i, denominator/numerator])

    result.sort(key=lambda x:x[1], reverse=True)
    for k in range(len(result)):
        answer.append(result[k][0])



    return answer


# print(solution(5,[2, 1, 2, 6, 2, 4, 3, 3]))