# 뉴스 클러스터링
def solution(str1, str2):
    answer = 0
    str1 = str1.upper()
    str2 = str2.upper()

    list1 = list()
    list2 = list()

    size = len(str1)
    for i in range(size-1):
        s = str1[i:i+2]
        if s.isalpha():
            list1.append(s)

    size = len(str2)
    for i in range(size-1):
        s = str2[i:i+2]
        if s.isalpha():
            list2.append(s)
    
    intersection = 0
    union = len(list1) + len(list2) # 합집합 크기 (마지막에 합집합 뺴주기)

    for s in list1:
        try:
            s_index = list2.index(s)
            list2[s_index] = " "
            intersection += 1
        except:
            continue

    union -= intersection

    if intersection == 0 and union != 0:
        return 0
        
    if union == 0:
        return 65536
    
    answer = int((intersection/union) * 65536)
    return answer

print(solution("FRANCE", "french"))
print(solution("handshake", "shake hands"))
print(solution("aa2+aa2", "AAAA12"))
print(solution("E=M*C^2", "e=m*c^2"))