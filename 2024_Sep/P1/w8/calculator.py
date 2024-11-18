x = int(input('Enter a value x: '))
y = int(input('Enter a value y: '))

print(f'Sum: {x + y}')
print(f'Diff: {x - y}')
print(f'Product: {x * y}')
print(f'Quotient: {x / y}')

if x > y:
    temp = x
    x = y
    y = temp

for i in range(x, y + 1, 1):
    if i % 2 == 0:
        print(i)