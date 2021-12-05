def load_file(file_name):
    with open(file_name) as f:
        lines = f.readlines()
    return lines


lines = load_file("inputfile3.txt")
print(f'result: {lines}')