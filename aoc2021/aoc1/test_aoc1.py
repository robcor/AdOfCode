import unittest

from aoc1.second import calc


class TestAoc1(unittest.TestCase):
    def test_second(self):
        result = calc("test_aoc1_2.txt")
        self.assertEqual(result, 5)


if __name__ == '__main__':
    unittest.main()
