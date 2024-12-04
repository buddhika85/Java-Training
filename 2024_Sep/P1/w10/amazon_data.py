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

prime_monthly_spend_gt_2000 = set()
prime_monthly_spend_1000_to_2000 = set()
prime_monthly_spend_lt_1000 = set()

none_prime_monthly_spend_gt_2000 = set()
none_prime_monthly_spend_1000_to_2000 = set()
none_prime_monthly_spend_lt_1000 = set()

for customer in amazon_data:
    if customer['monthly_spend'] > 2000:
        if customer['is_prime']:
            prime_monthly_spend_gt_2000.add(customer['id'])
        else:
            none_prime_monthly_spend_gt_2000.add(customer['id'])
    elif customer['monthly_spend'] <= 2000 and customer['monthly_spend'] >= 1000:
        if customer['is_prime']:
            prime_monthly_spend_1000_to_2000.add(customer['id'])
        else:
            none_prime_monthly_spend_1000_to_2000.add(customer['id'])
    else:
        if customer['is_prime']:
            prime_monthly_spend_lt_1000.add(customer['id'])
        else:
            none_prime_monthly_spend_lt_1000.add(customer['id'])

print(f'There are {len(prime_monthly_spend_gt_2000)} Prime members who spend > $2000')
print(f'There are {len(prime_monthly_spend_1000_to_2000)} Prime members who spend between $1000 and $2000')
print(f'There are {len(prime_monthly_spend_lt_1000)} Prime members who spend less than $1000')

print(f'There are {len(none_prime_monthly_spend_gt_2000)} none-Prime members who spend > $2000')
print(f'There are {len(none_prime_monthly_spend_1000_to_2000)} none-Prime members who spend between $1000 and $2000')
print(f'There are {len(none_prime_monthly_spend_lt_1000)} none-Prime members who spend less than $1000')