import sys
n = int(sys.stdin.readline())
# 입력 숫자 따로 리스트에 저장
n_list = [i for i in str(n)]
# 내장함수를 이용한 오름차순 정렬
n_list.sort()
# 내장함수를 이용하여 배열을 뒤집은 결과는 내림차순 정렬과 같다
n_list.reverse()
print(''.join(n_list))