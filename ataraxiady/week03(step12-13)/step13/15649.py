import sys
n,m = map(int, sys.stdin.readline().split())

# 배열에 요소들을 저장해두는 것이 아니라 길이가 맞다면 바로 출력하는 코드
def permutation(s):
    # 리스트의 길이가 조건과 같다면 출력
    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(1, n + 1):
        if i in s:
            continue
        permutation(s + [i])

permutation([])

# 함수사용하여 풀기
# from itertools import permutations
# perm = permutations(range(1,n+1),m)
#
# for i in perm:
#     print(' '.join(map(str,i)))