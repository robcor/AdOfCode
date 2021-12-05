from collections import deque

from aoclib.file_aoc import load_file_aoc
from aoclib.list_aoc import sum_list_aoc


def calc(file_name):
    lines = load_file_aoc(file_name)
    count = 0
    windows_queue = deque([])
    previous_value: int = 0
    for line in lines:
        input_value = int(line)
        windows_queue.append(input_value)
        data = list(windows_queue)
        if len(windows_queue) == 4:
            previous_value = sum_list_aoc(data, 0, 2)
            current_value = sum_list_aoc(data, 1, 3)
            if current_value > previous_value:
                count += 1
            windows_queue.popleft()
    return count


print(f'number increase {calc("input1.txt")}')
