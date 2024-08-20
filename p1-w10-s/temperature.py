def celsius_to_fahrenheit(celsius):
    return celsius * 9/5 + 32


def fahrenheit_to_celsius(fahrenheit):
    return (fahrenheit - 32) * 5/9

try:
    temperature = float(input('Please enter temperature: '))
    input_unit = input('Input unit ["C" for Celsius and "F" for Fahrenheit]: ').upper()
    output_unit = input('Output unit ["C" for Celsius and "F" for Fahrenheit]: ').upper()

    if input_unit != 'F' and input_unit != 'C':        
        raise ValueError('Invalid input unit. Enter C for celsius or F for Fahrenheit.')
    elif output_unit != 'F' and output_unit != 'C':
        raise ValueError('Invalid output unit. Enter C for celsius or F for Fahrenheit.')
    elif input_unit == output_unit:
        print(f'{temperature}{input_unit} is {temperature}{output_unit}, duh')
    elif output_unit == 'F':
        print(f'{temperature}C = {celsius_to_fahrenheit(temperature)}F')
    elif output_unit == 'C':
        print(f'{temperature}F = {fahrenheit_to_celsius(temperature)}C')
except ValueError as error:
    print(f'An error occurred: {error}')
