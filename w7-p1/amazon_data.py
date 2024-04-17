amazon_data = [
    {"id": 100, "is_prime": False, "monthly_spend": 800.0},
    {"id": 101, "is_prime": True, "monthly_spend": 1500.0},
    {"id": 102, "is_prime": False, "monthly_spend": 1000.0},
    {"id": 103, "is_prime": True, "monthly_spend": 2350.0},
    {"id": 104, "is_prime": False, "monthly_spend": 1100.0},
    {"id": 105, "is_prime": True, "monthly_spend": 900.0},
    {"id": 106, "is_prime": False, "monthly_spend": 2300.0},
    {"id": 107, "is_prime": True, "monthly_spend": 1050.0},
    {"id": 108, "is_prime": False, "monthly_spend": 950.0},
    {"id": 109, "is_prime": True, "monthly_spend": 1250.0},
    {"id": 110, "is_prime": False, "monthly_spend": 1150.0},
    {"id": 111, "is_prime": True, "monthly_spend": 1400.0},
    {"id": 112, "is_prime": False, "monthly_spend": 1000.0},
    {"id": 113, "is_prime": True, "monthly_spend": 1100.0},
    {"id": 114, "is_prime": False, "monthly_spend": 950.0},
    {"id": 115, "is_prime": True, "monthly_spend": 1200.0},
    {"id": 116, "is_prime": False, "monthly_spend": 4444.0},
    {"id": 117, "is_prime": True, "monthly_spend": 4300.0},
    {"id": 118, "is_prime": False, "monthly_spend": 1400.0},
    {"id": 119, "is_prime": True, "monthly_spend": 900.0}
]

prime_set = set()
non_prime_set = set()
gt_2000 = set()
between_1000_2000 = set()
lt_1000 = set()

for customer in amazon_data:
    if customer["is_prime"]:
        prime_set.add(customer["id"])
    else:
        non_prime_set.add(customer["id"])
    if customer["monthly_spend"] > 2000:
        gt_2000.add(customer["id"])
        
# for customer in prime_set:
#     print(customer)

print(f'There are {len(prime_set & gt_2000)} Prime members who spend > $2000')