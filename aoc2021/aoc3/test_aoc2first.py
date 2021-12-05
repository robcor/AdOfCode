import unittest

from aoc3.first import calc5
from aoc3.first import calc


class TestAoc1(unittest.TestCase):
    def test_first5(self):
        gamma, epsilon = calc5("test_first.txt")
        self.assertEqual(22, gamma)
        self.assertEqual(9, epsilon)

    def test_first(self):
        gamma, epsilon = calc("test_first.txt", 5)
        self.assertEqual(22, gamma)
        self.assertEqual(9, epsilon)


if __name__ == '__main__':
    unittest.main()
