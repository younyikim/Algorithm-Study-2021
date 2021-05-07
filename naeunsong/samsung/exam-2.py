def answer_func(arr, idx):
    len_arr = len(arr)

    for std_idx in range(1, len_arr):

        if idx - std_idx >= 0 and idx - std_idx < len_arr:
            if arr[idx - std_idx] > arr[idx]:
                return idx - std_idx
        if idx + std_idx >= 0 and idx + std_idx < len_arr:
            if arr[idx + std_idx] > arr[idx]:
                return idx + std_idx

    return -1


def solution(array):
    answer = []

    for i in range(len(array)):
        answer.append(answer_func(array, i))

    return answer

solution([1,2,3,4,5])