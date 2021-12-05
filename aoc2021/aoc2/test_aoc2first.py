import unittest

from aoc2.first import calc


class TestAoc1(unittest.TestCase):
    def test_second(self):
        x, y = calc("test_first.txt")
        self.assertEqual(x, 15)
        self.assertEqual(y, 10)


if __name__ == '__main__':
    unittest.main()
