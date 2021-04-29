n = int(input())

arr = list(map(str, input().split()))



m = int(input())

a, b = map(int, input().split())
a -=1
b -=1
mid = (a+b)//2

strA = "".join(arr[b:mid:-1])
print(strA)
strB = "".join(arr[a:mid])
print(strB)

# for i in range(m):
#     a, b = map(int, input().split())
#     mid = (a+b)//2
#
#     flg = 0
#     for i in range(a,mid):
#         if arr[i-1] != arr[b-i]:
#             print(0)
#             flg = 1
#             break
#     if flg == 0:
#         print(1)
