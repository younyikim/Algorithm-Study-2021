# 퀵 정렬 기본 (더 빠름)
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(start, end, array):
    if start >= end:
        return
    
    pivot = start
    left = start + 1
    right = end

    while left <= right:
        # pivot 보다 큰 데이터를 가리킬 때까지 left 증가
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # pivot 보다 작은 데이터를 가리킬 때까지 right 감소
        while right > start and array[right] >= array[pivot]:
            right -= 1
        
        
        if left > right: # 만약 둘이 엇갈렸으면 -> right 이랑 pivot이랑 교체
            array[right], array[pivot] = array[pivot], array[right]
        else: # 아니면 -> right 랑 left 랑 교체
            array[left], array[right] = array[right], array[left]
        
        quick_sort(start, right-1, array)
        quick_sort(right+1, end, array)

quick_sort(0, len(array)-1, array)
print(array)