n = int(input())
result = 0
for i in range(1,n+1):
    num = list(map(int,str(i)))
    result = i + sum(num)
    if result == n:
        print(i)
        #처음 발견되는 생성자가 가장 작은 생성자. 여기서 브레이크 가능
        break
    #끝까지 다 체크했으나 생성자가 없는 경우
    if i == n:
        print(0)