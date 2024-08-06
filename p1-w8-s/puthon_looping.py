# Write a for loop that prints out all integers from 12 to 25 inclusive 
for num in range(12, 26, 1):
    print(num)
    
# for loop that prints out all integers starting from 13 down to 0 inclusive
print('\n')
for num in range(13, -1, -1):
    print(num)
    
# for loop that prints out all even integers from 20 to 50 inclusive.
print('\n')
for num in range(20, 51, 1):
    if num % 2 == 0:
        print(f'{num} is EVEN')
    else:
        print(f'{num} is ODD')