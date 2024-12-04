class BankAccount:
    def __init__(self, name, balance) -> None:
        if balance < 0:
            raise ValueError(f'Invalid initial balance {balance}')
        self.name = name
        self.balance = balance
        
    def deposit(self, amount):
        if amount <= 0:
            raise ValueError(f'Invalid deposit amount {amount}')
        self.balance += amount
        
    def withdraw(self, amount):
        if amount <= 0:
            raise ValueError(f'Invalid withdraw amount {amount}')
        if amount > self.balance:
            raise ValueError(f'Invalid withdrawal request. You have {self.balance} but you try to withdraw more than that - {amount}')
        self.balance -= amount
        
    def __str__(self) -> str:
        return f'Bank account name {self.name} and balance {self.balance}'
        
# test code
# account = BankAccount('Mick', 1000.0)
# account.withdraw(500.0)
# account.deposit(1500.0)
# print(account)

try:
    # account = BankAccount('Mick', -1)
    
    account = BankAccount('Mick', 1000)
    # account.deposit(-1)
    # account.withdraw(-1)
    # account.withdraw(1000.1)
    
except ValueError as e:
    print(f'Error - {e}')