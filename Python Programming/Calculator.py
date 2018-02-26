print("CALCULATOR" )
print("Operations: ")
print("Enter + for addition.")
print("Enter - for substraction.")
print("Enter * for multiplication.")
print("Enter / for division.")
print("Enter ** for expotentiation.")
print("Press Enter for result.")
print("Enter quit to quit the program.")
while True:
	userinput = input("Choose an operation from above: ")
	if userinput == "quit":
		break
	elif userinput == "+":
		num1 = float(input("Enter a number: "))
		num2 = float(input("Enter another number: "))
		result = str(num1 + num2)
		print("The answer is: "+ result)
	elif userinput == "-":
		num1 = float(input("Enter a number: "))
		num2 = float(input("Enter another number: "))
		result = str(num1 - num2)
		print("The answer is: " + result)
	elif userinput == "*":
		num1 = float(input("Enter a number: "))
		num2 = float(input("Enter another number: "))
		result = str(num1 * num2)
		print("The answer is: " + result)
	elif userinput == "/":
		num1 = float(input("Enter a number: "))
		num2 = float(input("Enter another number: "))
		if num2 == 0:
			print("Division by zero not possible")
		else:
			result = str(num1 / num2)
			print("The answer is: " +result)
	elif userinput == "**":
		num1 = float(input("Enter a number: "))
		num2 = float(input("Enter another number: "))
		result = str(num1 ** num2)
		print("The answer is: " + result)
	
	else :
                print("Error. Unknown input")
