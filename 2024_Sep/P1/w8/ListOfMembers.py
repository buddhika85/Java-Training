# Start with no members (empty list)
members = []
while True:
    # 1. Get user input
    name = input('Name of member: ')
    # 2. Check if user typed in a name.
    #   - If so, add to 'members'
    #   - Otherwise, break
    if name == '':
        break
    else:
        members.append(name)

# Print out the 'members' list 
print(members)