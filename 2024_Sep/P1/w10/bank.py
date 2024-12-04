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

class Bank:
    def __init__(self) -> None:
        self.accounts = {}

    def add_account(self, name, balance):
        self.accounts[name] = BankAccount(name, balance)
    
    def transfer(self, sender_name, recipient_name, amount):
        if self.accounts[sender_name] != None and self.accounts[recipient_name] != None:            
            self.accounts[sender_name].withdraw(amount)
            self.accounts[recipient_name].deposit(amount)
            print(f'Success - Transferred {amount} from {sender_name} to {recipient_name}')
        else:
            print('Error - sender/receivers bank accounts does not exist')
        
    def __str__(self) -> str:
        str = 'Bank Accounts list\n'
        for account_name in self.accounts.keys():
            str += f'\t{self.accounts[account_name]}\n'
        return str
        
# Lab    
# test code
# account = BankAccount('Mick', 1000.0)
# account.withdraw(500.0)
# account.deposit(1500.0)
# print(account)

# try:
#     # account = BankAccount('Mick', -1)
    
#     account = BankAccount('Mick', 1000)
#     # account.deposit(-1)
#     # account.withdraw(-1)
#     # account.withdraw(1000.1)
    
# except ValueError as e:
#     print(f'Error - {e}')

# TB
try:
    bank = Bank()
    bank.add_account("Ellen", 800)  
    bank.add_account("Sophie", 2000.0)  
    bank.transfer('Ellen', 'Sophie', 800)
    print(bank)
except ValueError as e:
    print(f'Error - {e}')