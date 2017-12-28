from numpy.random import normal

count = 0

while count < 100:
    num = int(normal(loc=7, scale=4))

    if num > 0:
        print('%d'%num)
        count += 1
