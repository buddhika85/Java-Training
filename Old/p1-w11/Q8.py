def print_grade():
	mark = -1		# indicates unknown
	while True:
		mark = int(input('Please enter mark: '))
		if (mark >= 0 and mark <= 100):
			break
		else:
			print('\tInvalid - 0 to 100')
	if mark >= 90 and mark <= 100:
		print('A')
	elif mark >= 80 and mark <= 89:
		print('B')
	else:
		print('C')
		
# test code
print_grade()