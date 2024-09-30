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

prime_members_id_set = set()
non_prime_members_id_set = set()
spend_gt_2000_id_set = set()
spend_gte1000_and_lte_2000_id_set = set()
spend_lt_1000_id_set = set()

for customer in amazon_data:
    if (customer['is_prime']):
        prime_members_id_set.add(customer['id'])
    else:
        non_prime_members_id_set.add(customer['id'])
    if (customer['monthly_spend'] > 2000):
        spend_gt_2000_id_set.add(customer['id'])
    elif (1000 <= customer['monthly_spend'] <= 2000):
        spend_gte1000_and_lte_2000_id_set.add(customer['id'])
    elif (customer['monthly_spend'] < 1000):
        spend_lt_1000_id_set.add(customer['id'])

print(f'Prime Ids => {prime_members_id_set}')
print(f'Non Prime Ids => {non_prime_members_id_set}')

print(f'Prime member and (monthly spend > $2000) = {len(prime_members_id_set & spend_gt_2000_id_set)}')
print(f'Prime member and ( $1000 <= monthly spend <= $2000) = {len(prime_members_id_set & spend_gte1000_and_lte_2000_id_set)}')
print(f'Prime member and  (monthly spend < $1000) = {len(prime_members_id_set & spend_lt_1000_id_set)}')

print(f'None Prime member and (monthly spend > $2000) = {len(non_prime_members_id_set & spend_gt_2000_id_set)}')
print(f'None Prime member and ( $1000 <= monthly spend <= $2000) = {len(non_prime_members_id_set & spend_gte1000_and_lte_2000_id_set)}')
print(f'None Prime member and  (monthly spend < $1000) = {len(non_prime_members_id_set & spend_lt_1000_id_set)}')