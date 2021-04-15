n = input()
if int(n) < 10:
    n = '0'+n
a = int(n[0])
b = int(n[1])
plus = a+b
splus = str(plus)
if plus < 10:
    splus = '0'+splus
new = n[1]+splus[1]
i = 1
while(n != new):
    a = int(new[0])
    b = int(new[1])
    plus = a + b
    splus = str(plus)
    if plus < 10:
        splus = '0' + splus
    new = new[1] + splus[1]
    i = i + 1
print(i)