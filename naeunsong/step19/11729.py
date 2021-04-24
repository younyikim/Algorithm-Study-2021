
n = int(input())

# 1 3 7 15
def hanoi(k, from_, tmp, to_):

    if k == 1:
        print(from_, to_)
    else:
        hanoi(k-1, from_, to_, tmp)
        print(from_,to_)
        hanoi(k-1, tmp, from_, to_)

print(2 ** n - 1)
hanoi(n,1,2,3)
