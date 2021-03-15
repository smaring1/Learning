#TODO: Modify this



instr = {
  "LDA": "1011",
  "ADD": "0101",
  "SUB": "1100",
  "MUL": "0100",
  "DIV": "0010",
  "CALL": "1010",
  "GOTO": "1101",
  "RETURN": "1001",
  "OPC1": "1111",
  "OPC2": "0111",
  "OUT": "0110",
  "HLT": "0001",
  "ADC": "0011"
}


reg = {
  "R0": "11111111",
  "R1": "11111111",
  "R2": "11111111",
  "R3": "11111111",
  "R4": "11111111",
  "R5": "11111111",
  "R6": "11111111",
  "R7": "11111111",
  "R8": "11111111",
  "R9": "11111111",
  "RA": "11111111",
  "RB": "11111111",
  "RC": "11111111",
  "RD": "11111111",
  "RE": "11111111",
  "RF": "11111111"
}

print("Define some values, press enter twice when you finish ej. RA 5\n")

while True:
  mem_added = input()
  
  if (mem_added == ""):
    break
  
  slices = mem_added.split(" ")
  if (len(slices) != 2):
    print("Remember format! ej. RB 21")
    continue
  reg[slices[0]] = format(int(slices[1]), '08b')

print("Completed!")
print("Now, write your program at order to execute:\n")
i = 0

while True:
  mem_added = input()
  
  if (mem_added == ""):
    break
  
  if (mem_added == "RETURN" or mem_added == "OUT" or mem_added == "HLT" or mem_added == "OPC1" or mem_added == "OPC2" or mem_added == "ADC"):
    reg["R" + format(i, '0x').upper()] = instr[mem_added] + "0000"
    i = i + 1
    continue

  slices = mem_added.split(" ")
  
  if (len(slices) != 2):
    print("Remember format! ej. LDA RB")
    continue
  
  if(len(slices[1]) != 2):
    print("Remember format! ej. LDA RB")
    continue

  hex_position = slices[1][1]
  position = format(int(hex_position, 16), '04b')
  
  reg["R" + format(i, '0x').upper()] = instr[slices[0]] + position
  i = i + 1

sort_orders = sorted(reg.items(), key=lambda x: x[0])

print("Binario:")
for i in sort_orders:
	print(i[0], i[1])

print()

print("Hexadecimal:")
for i in sort_orders:
	print(i[0], format(int(i[1],2), "04x"))