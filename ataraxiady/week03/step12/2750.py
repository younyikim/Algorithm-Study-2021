import sys

n = int(sys.stdin.readline())
nums = []
for i in range(n):
    nums.append(int(sys.stdin.readline()))

def insertionsort(nums):
    for i in range(1,len(nums)):
        key = nums[i]
        j = i-1
        while j >= 0 and key < nums[j]:
            nums[j+1] = nums[j]
            j = j - 1
        nums[j + 1] = key


insertionsort(nums)
for i in nums:
    print(i)