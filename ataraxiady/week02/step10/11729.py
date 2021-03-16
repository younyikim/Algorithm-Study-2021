n = int(input())
def hanoi(n,a,b,c):
    if n == 1:
        print(a,c)
    else:
        hanoi(n-1,a,c,b)
        print(a,c)
        hanoi(n-1,b,a,c)
        
total = 1
for i in range(n-1):
    total = total * 2 + 1
print(total)
hanoi(n,1,2,3)