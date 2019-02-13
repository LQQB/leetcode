package com.example.solution;

import java.util.*;

public class SolutionEasy {


    private Map<Character, Character> keyword;
    public SolutionEasy() {
        this.keyword = new HashMap<>();
        this.keyword.put(']', '[');
        this.keyword.put('}', '{');
        this.keyword.put(')', '(');
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0; i < len; i++){
            Character charAt = s.charAt(i);
            if(!this.keyword.containsKey(charAt)) {
                Character popChar = stack.empty() ? '#':stack.pop();
                if(popChar != this.keyword.get(charAt))
                    return false;
            } else {
                stack.push(charAt);
            }
        }

        return stack.isEmpty();
    }


    /**
     * 从排序数组中删除重复项:
     *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     *   示例 1:  给定数组 nums = [1,1,2],
     *      函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *      你不需要考虑数组中超出新长度后面的元素。
     *   示例 2:
     *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int number = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[number] != nums[i]) {
                number ++;
                nums[number] = nums[i];
            }
        }
        return number+1;
    }

    /**
     *  买卖股票的最佳时机 II
     *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     *    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *     示例 1:
     *          输入: [7,1,5,3,6,4]  输出: 7
     *       解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *       随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *     示例 2:
     *          输入: [1,2,3,4,5]    输出: 4
     *        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *        注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *        因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *     示例 3:
     *          输入: [7,6,4,3,1]     输出: 0
     *        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int price = 0;
        for(int i=0; i < prices.length-1; i++){
            if(prices[i] < prices[i+1]) {
                price += (prices[i+1] - prices[i]);
            }
        }
        return price;
    }


    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *      示例 1:
     *          输入: [1,2,3,4,5,6,7] 和 k = 3
     *          输出: [5,6,7,1,2,3,4]
     *      解释:
     *          向右旋转 1 步: [7,1,2,3,4,5,6]
     *          向右旋转 2 步: [6,7,1,2,3,4,5]
     *          向右旋转 3 步: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 ) {
            throw new IllegalArgumentException();
        }
        k = k%len;  // 防止 k>n,右移k位跟右移k%n位的结果一样
        if(len == k ) {
            return;
        }

        int[] temp = new int[k];
        System.arraycopy(nums, len-k, temp, 0 , k);
        for(int i=len-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0 , k);

    }

    /*
     给定一个整数数组，判断是否存在重复元素。
        如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
        示例 1:
        输入: [1,2,3,1]
        输出: true
    */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // 存储重复数字
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],nums[i]);
        }
        return false;
    }

    /*
        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        说明：
        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
        示例 1:
            输入: [2,2,1]
            输出: 1
    */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // 存储重复数字
        int total = 0;
        for(int i=0; i < nums.length ;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> m: map.entrySet()) {
            if(m.getValue() == 1) return m.getKey();
        }
        throw new IllegalArgumentException();
    }


    /*
        给定两个数组，编写一个函数来计算它们的交集。
        示例 1:
        输入: nums1 = [1,2,2,1], nums2 = [2,2]
        输出: [2,2]
        说明：

        输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
        我们可以不考虑输出结果的顺序。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] resoult = new int[index];
        int i =0, j = 0 , k = 0; // k 为输出数组长度
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                resoult[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if(nums1[i] >= nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(resoult, k );
    }



    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
        如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
        注意你不能在买入股票前卖出股票。
        示例 1:

        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    */
    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int min = prices[0];    // 设置最小值为起始值
        int price=0;            // 利润
        for (int i=1; i<prices.length; i++) {
            if(min > prices[i])  min = prices[i];
            if(prices[i]-min > price) price = prices[i]-min;
        }
        return price;
    }

   /*
    编写一个函数，其作用是将输入的字符串反转过来
    */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length -1;
        while (i < j ) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    /*
        给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。
        示例 1:
            输入: [1,2,3]
            输出: [1,2,4]
            解释: 输入数组表示数字 123。
    */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] = digits[len-1] + 1;
        if(digits[len-1] != 10) return digits;
        for(int i=len-1; i>=0; i--) {
            if(digits[i] != 10 ) return digits;
            digits[i] = 0;
            if(i-1 < 0) {
                int[] resout = new int[len+1];
                resout[0] = 1;
                System.arraycopy(resout,1, digits, 0, len);
                return resout;
            };
            digits[i-1] = digits[i-1]+1;
        }
        throw new IllegalArgumentException();
    }



    /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        示例:
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]

        // 71ms(可优化)
     */
    public void moveZeroes(int[] nums) {
        int zeroIndex=nums.length-1; // 零的位置
        int index = 0;              // 下标的位置
        while (index<nums.length) {
            if(index == zeroIndex ) return ;
            if(nums[index] == 0 ) {
                for(int j=index; j<zeroIndex; j++)  nums[j] = nums[j+1];
                nums[zeroIndex] = 0;
                zeroIndex--;
                index = 0;
                continue;
            }
            index++;
        }
    }


    /*
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
        示例:
            给定 nums = [2, 7, 11, 15], target = 9
            因为 nums[0] + nums[1] = 2 + 7 = 9
            所以返回 [0, 1]
    */
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length;i++) {
            for(int j=nums.length-1; j>0 && j!=i; j--) {
                if(nums[i] == target - nums[j])
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException();
    }

    /*
     *   旋转图像
     *   给定一个 n × n 的二维矩阵表示一个图像。
     *   将图像顺时针旋转 90 度。
     *   说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
     *   给定 matrix =
     *       [[1,2,3],
     *       [4,5,6],
     *       [7,8,9]]
     *   原地旋转输入矩阵，使其变为:
     *   [[7,4,1],
     *     [8,5,2],
     *     [9,6,3]]
     **/
    public void rotate(int[][] matrix) {
        // 旋转对角:  1:(0,0)=>(0, 2)  3:(0, 2)=>(2,2)  9:(2,2)=>(2,0)   7:(2,0)=>(0,0)
        //          2:(0,1)=>(1, 2)   6:(1,2)=>(2,1)  8:(2,1)=>(1,0)  4:(1,0)=>(0,1)
        int N = matrix.length;
        for(int i=0; i < N/2;i++) {
            for(int j=i; j<N-1-i; j++) {

                System.out.print(matrix[i][j] + " ");
                System.out.print(matrix[j][N - 1 - i] + " ");
                System.out.print( matrix[N - 1 - i][N - 1 - j] + " ");
                System.out.print(matrix[N - 1 - j][i] + " ");

                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = temp;

            }
            System.out.println();
        }
    }


    /*
        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
            案例:
            s = "leetcode"
            返回 0.
            s = "loveleetcode",
            返回 2

        注意事项：您可以假定该字符串只包含小写字母。
    */
    public int firstUniqChar(String s) {
        // indexOf  获得 string 第一次出现的位置，否则为 -1
        // lastIndexOf 获得 string 最后一个出现的位置，否则为 -1
       int resout = -1;
       for(char ch='a'; ch<='z'; ch++) {
            int index = s.indexOf(ch);
            if(index != -1 && index==s.lastIndexOf(ch) ) {
                resout = (resout == -1 || resout >index) ? index : resout;
            }
       }
       return resout;
    }


    /*
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
        示例 1:
        输入: s = "anagram", t = "nagaram"
        输出: true

        说明:
        你可以假设字符串只包含小写字母。
     */
    public boolean isAnagram_1(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return  true;
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        return String.valueOf(s_char).equals(String.valueOf(t_char));
    }

    public boolean isAnagram_2(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return  true;
        Map<Character, Integer> map = new HashMap<>();
        for(char s_ch: s.toCharArray()) {
            map.put(s_ch, map.getOrDefault(s_ch, 0)+1);
        }
        for(char t_ch: t.toCharArray()) {
            Integer count = map.get(t_ch);
            if(null==count) {
                return false;
            } else if(count-1==0) {
                map.remove(t_ch);
            } else {
                map.put(t_ch, count-1);
            }
         }
         return map.isEmpty();
    }
    public boolean isAnagram_3(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return  true;
        char[] x = new char[26];
        char[] y = new char[26];
        for(char s_char: s.toCharArray()) x[s_char-'a']++;
        for(char t_char: t.toCharArray()) y[t_char-'a']++;
        for(int i=0; i<26;i++) {
            if(x[i] != y[i]) return false;
        }
        return true;
    }

    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if("".equals(needle) ) return 0;
        char[] haysCharArr = haystack.toCharArray();
        char[] needleCharArr = needle.toCharArray();
        int index = 0;
        int needIndex = 0;
        while (index <= haystack.length()) {
            if(index == haystack.length()
                    && needIndex != needle.length()) {
                return -1;
            }
            if(needIndex == needle.length()) {
                return index-needIndex;
            } else if(haysCharArr[index] == needleCharArr[needIndex]) {
                needIndex++;
            } else if(haysCharArr[index] != needleCharArr[needIndex]) {
                index = index-needIndex;
                needIndex=0;
            }
            index++;

        }
        return -1;
    }

    /**
     * 有效数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *  数字 1-9 在每一行只能出现一次。
     *  数字 1-9 在每一列只能出现一次。
     *  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            int[] rowUnit = new int[9];  // 用来校验行的数组
            int[] colUnit = new int[9];  // 用来校验列的数组
            int[] cueUnit = new int[9];  // 用来校验宫的数组
            for(int j=0; j<9; j++) {

                // 宫
//                i : 0                        1                       2                       3
//                j : 0 1 2   3 4 5   6 7 8    0 1 2   3 4 5   6 7 8   0 1 2   3 4 5   6 7 8   0 1 2  3 4 5  6 7 8
//                i : 0       1       2        3       4       5       6       7       8       0      1      2
//                j : 0 1 2   0 1 2   0 1 2    0 1 2   0 1 2   0 1 2   0 1 2   0 1 2   0 1 2   3 4 5  3 4 5  3 4 5
                if(board[i][j]!='.') {
                    if(rowUnit[board[i][j]-'1'] == 1) {      // 每一列
                        return false;
                    } else {
                        rowUnit[board[i][j]-'1'] += 1;
                    }
                }

                if(board[j][i] != '.' ) {
                    if(colUnit[board[j][i]-'1'] == 1) {      // 每一行
                        return false;
                    } else {
                        colUnit[board[j][i]-'1'] += 1;
                    }
                }

                int cX = 3 * (i/3) + j/3;
                int cY = 3 * (i%3) + j%3;
                if(board[cX][cY] != '.') {
                    if(cueUnit[board[cX][cY]-'1'] == 1) {    // 每一宫
                        return false;
                    } else {
                        cueUnit[board[cX][cY]-'1'] += 1;
                    }
                }


//                System.out.print(board[cX][cY]);
//                System.out.print(",  ");
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        char[] chars = s.toLowerCase().toCharArray();
        int l_index = 0;
        int r_index = chars.length-1;
        while (l_index <= r_index && l_index < chars.length-1) {
            char head = chars[l_index];
            char tail = chars[r_index];
            if( ! ((head >= 'a' &&  head <= 'z') || (head >= '0' && head <= '9')) ) {
                l_index++;
                continue;
            }
            if( ! ((tail >= 'a' && tail <= 'z') || (tail >= '0' && tail <= '9')) )  {
                r_index--;
                continue;
            }
            if(head != tail) {
                return false;
            }
            l_index++;
            r_index--;
        }
        return true;
    }



}
