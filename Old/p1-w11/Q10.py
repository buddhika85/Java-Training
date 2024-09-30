class BankAccount:
	def __init__(self, cusomter_name , balance, annual_interest_rate):
		self.cusomter_name = cusomter_name
		self.balance = balance
		self.annual_interest_rate = annual_interest_rate
	
	def deposit(self, amount):
		if amount > 0:
			self.balance += amount
	
	def withdraw(self, amount):
		if amount > 0 and self.balance >= amount:
			self.balance -= amount
		else:
			print(f'Error - Amount {amount} is invalid') 
			
	def monthly_interest(self):
		self.balance += self.balance * (self.annual_interest_rate / 12)
		
	def __str__(self):
		return f'{self.cusomter_name}, balance: {self.balance}, annual interest: {self.annual_interest_rate}'

# test code
bank_account = BankAccount('John', 90, 0.12)
print(bank_account)	
bank_account.deposit(-1)
print(bank_account)		
bank_account.deposit(20)
print(bank_account)	
bank_account.withdraw(111)	
print(bank_account)	
bank_account.withdraw(10)	
print(bank_account)		
bank_account.monthly_interest()
print(bank_account)	