class Tenant:
    def __init__(self, name, industry, level, floor_location) -> None:
        self.name = name
        self.industry = industry
        self.level = level
        self.floor_location = floor_location
        
class OfficeBuilding:
    def __init__(self, tenants) -> None:
        self.tenants = tenants                  # list of tenants
    
    def number_of_tenants(self):
        return len(self.tenants)
    
    def number_of_levels(self):
        levels_set = set()
        for tenant in self.tenants:
            levels_set.add(tenant.level)
        return len(levels_set)
    
    def print_tenants(self, industry):
        for tenant in self.tenants:
            if tenant.industry == industry:
                print(f'{tenant.name} => industry {tenant.industry}')
                
# test code
print('Test Code')
tenants = [ Tenant('Fusion Food', 'Food', 1, 1),  Tenant('Epic', 'Gaming', 1, 2),  Tenant('Medlab', 'Medical', 1, 3) ]
tenants.append(Tenant('Westpac', 'Finance', 2, 1))
tenants.append(Tenant('NovaTech', 'IT', 3, 1))
tenants.append(Tenant('JB Hi Fi', 'Retial', 3, 2))
office_building = OfficeBuilding(tenants)

print(f'Num of Tenants : {office_building.number_of_tenants()}')
print(f'Num of levels : {office_building.number_of_levels()}')

office_building.print_tenants('IT')