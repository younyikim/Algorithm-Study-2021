import sys
from collections import Counter

n = int(sys.stdin.readline())
nums = []
for i in range(n):
    nums.append(int(sys.stdin.readline()))

# 중앙값을 위해, 또 최빈값이 여러 개 일시 두 번째 작은 값을 찾기위해 정렬한다.
nums.sort()
def mode(nums):
    # (숫자,카운팅)으로 이뤄진 튜플이 생성된다.
    # 카운팅의 큰 순서대로 나열되며 같은 카운팅이 있을시 원래 배열의 순서대로 나열된다.
    mode_num = Counter(nums).most_common()
    if len(nums) > 1:
        # 최빈값 top2를 비교한다.
        if mode_num[0][1] == mode_num[1][1]:
            # 두가지의 최빈값이 같을 시 두 번째 작은 값을 출력한다.
            mod = mode_num[1][0]
        # 최빈 값이 하나이다.
        else:
            mod = mode_num[0][0]
    else:
        mod = mode_num[0][0]
    return mod

print(round(sum(nums)/n))
print(nums[n//2])
print(mode(nums))
print(max(nums)-min(nums))