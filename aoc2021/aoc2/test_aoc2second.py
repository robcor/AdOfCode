import unittest

from aoc2.second import calc


class TestAoc1(unittest.TestCase):
    def test_second(self):
        x, y = calc("test_first.txt")
        self.assertEqual(x, 15)
        self.assertEqual(y, 60)


if __name__ == '__main__':
    unittest.main()
