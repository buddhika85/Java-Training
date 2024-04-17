nums = {1,2,3,4,5,5}
even_nums = {2,4}

print(nums)
print(f'Intersection {nums & even_nums}')
print(f'Union {nums | even_nums}')
print(f'Difference {nums - even_nums}')
print(f'Difference {even_nums - nums}')


class City:
    def __init__(self, name, country):
        self.name = name
        self.country = country

citiesDictionary = {
    "Sydney" : City("Sydney", "Australia"),
    "Melbourne" : City("Melbourne", "Australia"),
    "NewYork" : City("NewYork", "USA"),
    "Rome" : City("Rome", "Italy"),
}

for key in citiesDictionary.keys():
    print(citiesDictionary[key].name)