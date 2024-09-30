a = { 10, 20, 30, 40}
b = { 20, 40}

print(a & b) # intersection (AND)  20,40
print(a | b) # union (OR) 10,20,30,40

# dictionaries
top_performers = {
    'HD': 10,
    'D': 13
}

remaining = {
    'C': 23,
    'P': 40,
    'F': 9
}

print(f'There are {top_performers['HD']} students with HD, and {top_performers['D']} students with D')
print(f'There are {remaining['C']} students with C, {remaining['P']} with P and {remaining['F']} with F')

total_top = 0
for key in top_performers:
    total_top += top_performers[key]
    
print(f'There are {total_top} top performers')


total_remaining = 0
for key in remaining:
    total_remaining += remaining[key]
    
print(f'There are {total_remaining} reaming')
print(f'Total: {total_top + total_remaining}')

combined = {}
for key in top_performers.keys():
    combined[key] = top_performers[key]
for key in remaining.keys():
    combined[key] = remaining[key]

print(combined)
combined['HD'] = combined['HD'] -3
combined['D'] = combined['D'] +3
print(combined)