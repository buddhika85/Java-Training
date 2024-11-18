member_count = int(input('Enter maximum number of members: '))
if member_count <= 0:
    print(f'Error - invalid member count {member_count}')
else:
    members = []
    while member_count > 0:
        name = input('Name of member: ')
        if name == '':
            break
        members.append(name)
        member_count -= 1
    print(members)