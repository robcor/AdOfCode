from aoclib.file_aoc import load_file_aoc


def calc5(file_name):
    lines = load_file_aoc(file_name)

    count1 = 0
    count2 = 0
    count3 = 0
    count4 = 0
    count5 = 0
    for cur_line in lines:
        v1 = int(cur_line[0:1])
        v2 = int(cur_line[1:2])
        v3 = int(cur_line[2:3])
        v4 = int(cur_line[3:4])
        v5 = int(cur_line[4:5])

        count1 += v1
        count2 += v2
        count3 += v3
        count4 += v4
        count5 += v5

    vgamma1, vgamma2, vgamma3, vgamma4, vgamma5 = 0, 0, 0, 0, 0
    vepsilon1, vepsilon2, vepsilon3, vepsilon4, vepsilon5 = 0, 0, 0, 0, 0

    count_all = len(lines)
    # gamma more common
    if count1 > count_all - count1:
        vgamma1 = 16
    if count2 > count_all - count2:
        vgamma2 = 8
    if count3 > count_all - count3:
        vgamma3 = 4
    if count4 > count_all - count4:
        vgamma4 = 2
    if count5 > count_all - count5:
        vgamma5 = 1

    # epsilon less common
    if count1 <= count_all - count1:
        vepsilon1 = 16
    if count2 <= count_all - count2:
        vepsilon2 = 8
    if count3 <= count_all - count3:
        vepsilon3 = 4
    if count4 <= count_all - count4:
        vepsilon4 = 2
    if count5 <= count_all - count5:
        vepsilon5 = 1

    gamma = vgamma1 + vgamma2 + vgamma3 + vgamma4 + vgamma5
    epsilon = vepsilon1 + vepsilon2 + vepsilon3 + vepsilon4 + vepsilon5

    return gamma, epsilon


def calc(file_name, input_len):
    lines = load_file_aoc(file_name)

    count_list = []
    for i in range(0, input_len ):
        count_list.append(0)
    for cur_line in lines:
        cur_parsed = []
        for i in range(0, input_len ):
            cur_parsed.append(int(cur_line[i:i + 1]))
        for i in range(0, input_len ):
            count_list[i] += cur_parsed[i]

    count_all = len(lines)
    num_len = len(count_list)
    epsilon = 0
    gamma = 0
    # gamma more common
    for i in range(0, num_len):
        if count_list[i] > count_all - count_list[i]:
            gamma = gamma + pow(2, num_len - i - 1)

    # epsilon less common
    for i in range(0, num_len):
        if count_list[i] <= count_all - count_list[i]:
            epsilon = epsilon + pow(2, num_len - i - 1)

    return gamma, epsilon


gamma, epsilon = calc("input3.txt", 12)
print(f'gamma {gamma} epsilon {epsilon} result = {gamma * epsilon}')
