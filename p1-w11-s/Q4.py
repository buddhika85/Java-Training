class Point:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z
    def __str__(self):
        return  f'({self.x}, {self.y}, {self.z})'
    
# test code
point = Point(10,20,30)
print(point)

points = [Point(1, 2, 3),
Point(4, 5, 6),
Point(2, 3, 4)]
sum = 0
for p in points:
    sum += p.y
print(f"The sum is {sum}")