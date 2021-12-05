from aoclib.file_aoc import load_file_aoc


def calc(file_name):
    lines = load_file_aoc(file_name)

    x = 0
    y = 0
    for curLine in lines:
        split = curLine.split()

        command = split[0]
        value = int(split[1])
        if command == "forward":
            x += value
        if command == "down":
            y += value
        if command == "up":
            y -= value
    return x, y


x, y = calc("input3.txt")
print(f'x {x} y {y} result = {x * y}')
