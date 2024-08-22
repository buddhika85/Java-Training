class BankAccount:
    def __init__(self, name, balance) -> None:
        if (balance < 0):
            raise ValueError('Initial balance cannot be negative')
        self.name = name
        self.balance = balance
    
    def deposit(self, amount):
        if (amount < 0):
            raise ValueError('Cannot deposit non postive amount of funds')
        self.balance += amount

    def withdraw(self, amount):
        if (amount > self.balance):
            raise ValueError(f'Cannot withdraw this amount, as your balance is ${self.balance}')
        self.balance -= amount
    
    def __str__(self) -> str:
        return f'Bank Account owner {self.name} balance is ${self.balance}'
    
# test code - working
# account = BankAccount('Mick', 1000.0)
# account.withdraw(500.0)
# account.deposit(1500.0)
# print(account)

# exceptions
try:
    # account = BankAccount('John', -1)
    account = BankAccount('John', 100)
    # account.deposit(-1)
    # account.withdraw(101)
except ValueError as e:
    print(f'Error: {e}')