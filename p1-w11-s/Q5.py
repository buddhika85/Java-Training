start = int(input("Enter a starting integer: "))
end = int(input("Enter an ending integer: "))
total = 0
for n in range(start, end):
    total += n
print(total / 3)