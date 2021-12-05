from aoclib.file_aoc import load_file_aoc


def calc(file_name):
    lines = load_file_aoc(file_name)

    x = 0
    y = 0
    aim = 0
    for curLine in lines:
        split = curLine.split()

        command = split[0]
        value = int(split[1])
        if command == "forward":
            y += aim * value
            x += value
        if command == "down":
            aim += value
        if command == "up":
            aim -= value
        print(f"{x},{y},{aim}")
    return x, y


x, y = calc("input2.txt")
print(f'x {x} y {y} result = {x * y}')

#https://github.com/rcorda/AdOfCode.git