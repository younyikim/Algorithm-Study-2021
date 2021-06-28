# 실패율
# 5
# 2 1 2 6 2 4 3 3

def quick_sort(array):
    if len(array) <= 1:
        return array
    
    pivot = array[0] # 첫번째 원소 피봇
    tail = array[1:] # 나머지 꼬리 원소들

    left_side = [x for x in tail if x[2] > pivot[2]] # tail 에서 pivot 보다 작은거나 같은 원소 왼쪽으로
    right_side = [x for x in tail if x[2] <= pivot[2]] # 큰 원소는 오른쪽으로

    return quick_sort(left_side) + [pivot] + quick_sort(right_side) # 재귀

def solution(N, stages):
    answer = [0] * N

    array = list()
    for i in range(N):
        array.append([0,0,0,i+1]) # [클리어X, 스테이지 도달, 실패율, 스테이지번호]

    for s in stages:
        if s == N+1:
            for i in range(N):
                array[i][1] += 1
        else:
            for i in range(0, s):
                array[i][1] += 1
            array[s-1][0] += 1
    
    for i in range(N):
        if array[i][0] == 0:
            array[i][2] = 0
        else:
            array[i][2] = array[i][0] / array[i][1]

    array = quick_sort(array)
    
    for i in range(N):
        answer[i] = array[i][3]

    return answer

N = int(input()) # 전체 스테이지 수
stages = list(map(int, input().split())) # 멈춰있는 스테이지 번호

print(solution(N, stages))