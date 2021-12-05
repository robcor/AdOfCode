from aoclib.file_aoc import load_file_aoc


def calc(file_name):
    lines = load_file_aoc(file_name)
    x, y = 0, 0
    return x, y


x, y = calc("input3.txt")
print(f'x {x} y {y} result = {x * y}')
