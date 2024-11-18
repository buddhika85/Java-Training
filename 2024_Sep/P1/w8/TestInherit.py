class Parent1:
    def method(self):
        print("Method from Parent1")

class Parent2:
    def method(self):
        print("Method from Parent2")

class Child(Parent2, Parent1):
    pass

child = Child()
child.method() 