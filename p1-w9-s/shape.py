import math


class Shape:
    def __init__(self, name):
        self.name = name
    
    def getPerimeter(self):
        return 0.0
    
    def getArea(self):
        return 0.0
    
    def __str__(self) -> str:
        return self.name
    
class Rectangle(Shape):
    def __init__(self, name, width, height):
        super().__init__(name)
        self.width = width
        self.height = height
    
    def getPerimeter(self):
        return 2 * (self.height + self.width)
    
    def getArea(self):
        return self.height * self.width
    
    def __str__(self) -> str:
        return f'{self.name} with W: {self.width} H: {self.height}'

class Hexagon(Shape):
    def __init__(self, name, side_length):
        super().__init__(name)
        self.side_length = side_length
        
    def getPerimeter(self):
        return 6 * self.side_length
    
    def getArea(self):
        return ((3 * math.sqrt(3)) / 2) * self.side_length * self.side_length
    
    def __str__(self) -> str:
        return f'{self.name} with side: {self.side_length}'
    

rect = Rectangle('Rectangle 1', 2,3)
hex = Hexagon('Hexagon 1', 10)

print(f'{rect}')
print(f'Area: {rect.getArea()}')
print(f'Perimeter: {rect.getPerimeter()}')

print(f'\n{hex}')
print(f'Area: {hex.getArea()}')
print(f'Perimeter: {hex.getPerimeter()}')