def sum_list_aoc_all(list_input):
    sum_value: int = 0
    for value in list_input:
        sum_value += value
    return sum_value


def sum_list_aoc(list_input, start, end):
    sum_value: int = 0
    sub_list = list_input[start: end]
    for value in sub_list:
        sum_value += value
    return sum_value
