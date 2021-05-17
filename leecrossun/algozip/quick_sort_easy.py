# 퀵 정렬 이해하기 쉬움

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    if len(array) <= 1:
        return array
    
    pivot = array[0] # 첫번째 원소 피봇
    tail = array[1:] # 나머지 꼬리 원소들

    left_side = [x for x in tail if x < pivot] # tail 에서 pivot 보다 작은거나 같은 원소 왼쪽으로
    right_side = [x for x in tail if x >= pivot] # 큰 원소는 오른쪽으로

    return quick_sort(left_side) + [pivot] + quick_sort(right_side) # 재귀

print(quick_sort(array))


