class App:
	def __init__(self, name, min_age):
		self.name = name
		self.min_age = min_age
	
	def __str__(self):
		return f'App: {self.name} min age: {self.min_age}'

class SubcriptionApp(App):
	def __init__(self, name, min_age, monthly_price):
		super().__init__(name, min_age)
		self.monthly_price = monthly_price
	
	def annual_cost(self):
		return self.monthly_price * 12

	def weekly_cost(self):
		return self.monthly_price / 4

	def __str__(self):
		return f'Subscription {super().__str__()} monthly price: {self.monthly_price}'
	
# test
subcriptionApp = SubcriptionApp('Netflix', 15, 20)
print(f'{subcriptionApp}, annual cost: {subcriptionApp.annual_cost()}, weekly cost: {subcriptionApp.weekly_cost()}')