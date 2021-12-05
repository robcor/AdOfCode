from aoclib.file_aoc import load_file_aoc


lines = load_file_aoc("input1.txt")

count = 0
previous_value: int = 10000000000
for line in lines:
    cur_value = int(line)
    if cur_value > previous_value:
        count += 1
    previous_value = cur_value

print(f'number increase {count}')
