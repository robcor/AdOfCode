import unittest

from aoclib.list_aoc import sum_list_aoc
from collections import deque


class TestSum(unittest.TestCase):
    def test_list_int(self):
        data = [1, 2, 3]
        result = sum_list_aoc(data, 0, 2)
        self.assertEqual(result, 3)

    def test_list_2(self):
        data = [1, 2, 3]
        result = sum_list_aoc(data, 1, 3)
        self.assertEqual(result, 5)

    def test_list_dequeue(self):
        windows_queue = deque([])
        windows_queue.append(1)
        windows_queue.append(2)
        windows_queue.append(3)

        data = list(windows_queue)
        result = sum_list_aoc(data, 1, 3)
        self.assertEqual(result, 5)


if __name__ == '__main__':
    unittest.main()
