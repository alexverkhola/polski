#Count useful strings in file
import sys

fileName = sys.argv[1]
counter = 0
file = open(fileName)

line = file.readline()

for line in file:
    if line == "\n" or line.startswith("//") or line.startswith("#"):
        pass
    else:
        counter += 1

print("The file contents " + str(counter) + " lines")