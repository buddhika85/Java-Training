class Artist:
    def __init__(self, name, num_of_members, genre, year_founded):
        self.name = name
        self.num_of_members = num_of_members
        self. genre = genre
        self.year_founded = year_founded
    
    def __str__(self):
        return f'{self.name} with {self.num_of_members} members on {self.genre} was founded in {self.year_founded}'

# test code
artist_one = Artist('Iron Maiden', 5, 'Rock', 1965)
artist_two = Artist('Micheal Jack', 1, 'Pop', 1980)
artists = [artist_one, artist_two]
for artist in artists:
    print(artist)