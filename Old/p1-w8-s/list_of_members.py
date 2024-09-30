# # Start with no members (empty list)
# members = []
# while True:
#     # 1. Get user input
#     name = input('Name of member: ')
#     # 2. Check if user typed in a name.    
#     #   - If so, add to 'members'
#     #   - Otherwise, break
#     if name !=  '':
#         members.append(name)
#     else:
#         break

# # Print out the 'members' list
# print(f'Members: {members}')


# Start with no members (empty list)
members = []
count = int(input('Enter maximum number of members:'))
if count <= 0:
    print('Error - Please provide a valid input greater than 0')
else:
    while count > 0:
        # 1. Get user input
        name = input('Name of member: ')
        # 2. Check if user typed in a name.    
        #   - If so, add to 'members'
        #   - Otherwise, break
        if name !=  '':
            members.append(name)
        else:
            break
        count -= 1

# Print out the 'members' list
print(f'Members: {members}')