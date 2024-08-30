# C4
# name = input('Enter Name: ')
# age = int(input('Enter age: '))
# print(f"Hi {name}, I'm {age + 10} years old!")


# C7
# x = int(input('Enter x: '))
# y = int(input('Enter y: '))
# print(f'{x * x + y * y}')

# C8
# i = 1
# while i <= 5:
# 	mark = int(input('Mark ?'))
# 	if 100 >= mark >= 90:
# 		print('A')
# 	elif 89 >= mark >= 80:
# 		print('B')
# 	else:
# 		print('C')
# 	i += 1

# C9
class Circle:
	def __init__(self, radius):
		self.radius = radius

	def print_area(self):
		print(f'Area : {3.14 * self.radius * self.radius}')

circle = Circle(10)
circle.print_area()