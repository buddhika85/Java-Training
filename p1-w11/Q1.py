total = 0
str = '0'
for num in range(34, 58, 1):
    total += num
    str = f'{str}+{num}'
print(f'{str}={total}')