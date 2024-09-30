class Users:
    def __init__(self):
        self.casual_users = set()
        self.moderate_users = set()
        self.heavy_users = set()

    def add_user(self, name, number_of_minutes_played):
        if number_of_minutes_played < 60:
            self.casual_users.add(name)
        elif number_of_minutes_played <= 120:
            self.moderate_users.add(name)
        else:
            self.heavy_users.add(name)
    
    def display(self):
        print(f"There are {len(self.casual_users | self.moderate_users)} casual or moderate users", )
        print(f"There are {len(self.moderate_users | self.heavy_users)} moderate or heavy users", )

# Create an instance of UserStatistics
users = Users()
# Add users and categorize them based on playtime
users.add_user("Alice", 45)
users.add_user("Bob", 90)
users.add_user("Charlie", 150)
users.add_user("Eve", 30)
# Display user categories
users.display()