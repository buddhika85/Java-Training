bools = [True, False, True, True, True,
         True, True, True, True, False, True, True,
         True, True, True,
         
         False, True, True, True,
         True, False, False, True, True, True, True,
         True, True, False, False, False, False, True,
         True, False, True, False, True, True, False,
         True, False, True, True, True, True, False,
         False, False, True, False, True, False, False,
         True, False, True, False, True, False, False,
         False, False, False, False, False, True, False,
         True, True, True, True, False, True, False, False,
         False, False, False, False, False, True, True,
         False, False, False, True, False, True, False,
         True, False, False, True, False, False, False,
         True, True, True, False, False, True, False,
         True, True, False, False, True, True, True, False,
         False, True, True, True, True, True, False, False,
         False, False, False, True, True, True, True, True,
         False, False, False, True, False, True, True, False,
         True, True, False, False, True, False, True, True,
         False, True, True, True, True, False, False, False,
         True, False, False, True, True, False, False, False,
         True, False, False, False, False, False, True, True,
         False, False, False, True, True, False, False, True,
         False, True, True, True, False, False, False, False,
         True, False, False, True, False, False, True, True,
         True, False, False, True, True, True, True, False]

true_count = 0
false_count = 0
for value in bools:
    if value:
        true_count +=1
    else:
        false_count += 1

print(f'True=> {true_count} False=> {false_count}')


num_elements = int(input('Enter # elements to process: '))
index = 0
true_count = 0
to_process = num_elements
while to_process > 0 and index < len(bools):
    if bools[index]:
        true_count += 1
    index += 1
    to_process -= 1
print(f"There are {true_count} 'true' values in first {num_elements} of the list")