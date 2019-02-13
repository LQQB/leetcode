package com.example.solutiontest;

import com.example.solution.SolutionEasy;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SolutionEasyTest {

	private SolutionEasy solution;

	@Before
	public void init(){
		solution = new SolutionEasy();
	}


	@Test
	public void contextLoads() {
		solution.isValid("{}");
	}

	@Test
	public void removeDuplicatesTest() {
		int[] args = {0,0,1,1,1,2,2,3,3,4,4};
		int len = solution.removeDuplicates(args);
		for(int i=0;  i<len; i++) {
			System.out.println(args[i]);
		}
	}

	@Test
	public void maxProfitTest() {
		int[] arr = {7,1,5,3,6,4};
		solution.maxProfit(arr);
	}

	@Test
	public void rotateTest() {
		int[] arr = {-1,2,4};
		solution.rotate(arr, 2);
		for(int a: arr) {
			System.out.println(a);
		}
	}

	@Test
	public void containsDuplicateTest() {
		int[] arr = {1,2,3,1};
		boolean bool = solution.containsDuplicate(arr);
		Assert.assertEquals(true, bool);
	}

	@Test
	public void singleNumberTest() {
		int[] arr = {2,2,1};
		int index = solution.singleNumber(arr);
		Assert.assertEquals(1, index);
	}

	@Test
	public void reverseStringTest() {
		String str = "A man, a plan, a canal: Panama";
		solution.reverseString(str);
	}

	@Test
	public void intersectTest() {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		solution.intersect(nums1, nums2);

	}

	@Test
	public void plusOneTest() {
		int[] nums = {9,9,9};
		int[] pass = {1,0,0,0};
		Assert.assertArrayEquals(pass, solution.plusOne(nums));
	}

	@Test
	public void moveZeroesTest() {
		int[] nums = {1,1,0,1, 0, 0,1};
		solution.moveZeroes(nums);
		int[] pass = {1,1,1,1, 0, 0, 0};
		Assert.assertArrayEquals(pass, nums);
	}


	@Test
	public void twoSum() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] resoult = solution.twoSum(nums, target);
		int[] pass = {0, 1};
		Assert.assertArrayEquals(pass, resoult);
	}

	@Test
	public void rotateTan90() {
		int[][] nums = {{7,4,1}, {8,5,2}, {9,6,3}};
		solution.rotate(nums);
	}

	@Test
	public void firstUniqCharTest() {
		String str = "loveleetcode";
		Assert.assertEquals(2, solution.firstUniqChar(str));
	}

	@Test
	public void isAnagramTest_1() {
		String s = "rat", t = "cat";
		Assert.assertEquals(true, solution.isAnagram_1(s, t));
	}

	@Test
	public void isAnagramTest_2() {
		String s = "anagram", t = "nagaram";
		Assert.assertEquals(true, solution.isAnagram_2(s, t));
	}


	@Test
	public void isAnagramTest_3() {
		String s = "a", t = "b";
		Assert.assertEquals(false, solution.isAnagram_3(s, t));
	}

	@Test
	public void strStrTest() {
		String a = "aaaaa";
		String b = "bba";
		Assert.assertEquals(-1, solution.strStr(a, b));
	}


	@Test
	public void isValidSudokuTest() {
		char[][] board = {
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','3','.','.','.','.'},
				{'.','9','8','.','.','2','.','.','1'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','.'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
//		solution.isValidSudoku(board);
		Assert.assertEquals(false, solution.isValidSudoku(board));
	}

	@Test
	public void rotate2Test() {
		int[][] matrix = {  {1,2,3,4},
				            {4,5,6,5},
				            {7,8,9,7},
							{4,5,7,4}};

		solution.rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}


	@Test
	public void isPalindromeTest() {

		Assert.assertEquals(true, solution.isPalindrome("A man, a plan, a canal: Panama"));
		Assert.assertEquals(false, solution.isPalindrome("race a car"));
		Assert.assertEquals(true, solution.isPalindrome(" "));
		Assert.assertEquals(true, solution.isPalindrome("ABA"));
	}



}
