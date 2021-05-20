
def func(num, arr, memo, k):
    arr[k] = num

    if num == 1:
        print('up',k+1)
        for i in range(k+1):
            print(arr[i], end=' ')
        print()
        return

    if memo[num] == 0:
        memo[num] = 1

        if num % 3 == 0:
            func(num // 3, arr, memo, k+1)
        if num % 2 == 0:
            func(num // 2, arr, memo, k+1)
        func(num-1, arr, memo, k+1)


n = int(input())

memo = [0 for _ in range(100001)]
arr = [0 for _ in range(100001)]

func(n, arr, memo, 0)
