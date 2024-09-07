class Tenant:
    def __init__(self, name, industry, level, floot_location) -> None:
        self.name = name
        self.industry = industry
        self.level = level
        self.floor_location = floot_location
        
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