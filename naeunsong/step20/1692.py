a, b, c = map(int, input().split())

def multi(x, y, z):
    if y == 1:
        return x % z
    else:
        tmp = multi(x,y//2,z)
        if y % 2 == 0:
            return  (tmp * tmp) % z
        else:
            return ((tmp * tmp) * x) % z

print(multi(a,b,c))