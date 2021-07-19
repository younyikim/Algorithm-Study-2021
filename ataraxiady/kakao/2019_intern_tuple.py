def solution(s):
    answer = []
    tokens=[]

    # 제일 바깥 {{}} 제거
    temp_token = s[2:-2]
    # 원소 별로 구분
    temp_token = temp_token.split("},{")

    for token in temp_token:
        temp = list(map(int,token.split(",")))
        tokens.append(temp)

    # 배열 크기 순 오름차순
    tokens = sorted(tokens, key = lambda x: len(x))

    # 배일 크기가 큰 순서부터 배열 속 숫자 하나하나를 중복되지 않도록 answer에 넣어준다.
    for token in tokens:
        for num in token:
            if num not in answer:
                answer.append(num)

    return answer



print(solution("{{123}}"))