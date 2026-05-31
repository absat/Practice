# Two pointers

## Overview
Whenever there’s a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind.

## Pattern Check
1. Linear data structure: The input data can be traversed in a linear fashion, such as an array, linked list, or string.

2. Process pairs: Process data elements at two different positions simultaneously.

3. Dynamic pointer movement: Both pointers move independently of each other according to certain conditions or criteria. In addition, both pointers might move along the same or two different data structures.

### Q Reverse string/array in place
```
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left<right){
           char temp = s[left];
           s[left] = s[right];
           s[right]=temp;
           left++;
           right--;  
        }
    }
}
```

### Q Two Sum II, Input array is sorted
```
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low=0,high=numbers.length-1,sum=0;
        while(low<high){
            sum = numbers[low]+numbers[high];
            if(sum == target)
                break;
            else if(sum>target){
                high--;
            } else {
                low++;
            }   
        }
        return new int[]{low+1,high+1};
    }
}
```

### Q Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

**Solution**:
```
class Solution {
    public boolean isPalindrome(String s) {
        int low=0,high=s.length()-1;
        while(low<high){
            while(low<high && !Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
             while(low<high && !Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }
            if(Character.toLowerCase(s.charAt(low))!=Character.toLowerCase(s.charAt(high))){
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
```
### Q 3sum

Given an array, find unique triplets that sum to zero
```
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        //nums[i]<=0, why? since array is sorted and we have a positive number as first element, we will never find complements lesser than it that bring the total triplet sum to 0
        for(int i=0;i<nums.length && nums[i]<=0;i++){
            //do duplicate check with immediately previous number
            if(i==0 || nums[i]!=nums[i-1]){
                solve(i,nums,list);
            }
        }
        return list;
    }

    private void solve(int index, int[] nums, List<List<Integer>> list){
        int low=index+1, high= nums.length-1;
        while(low<high){
            int sum = nums[index]+nums[low]+nums[high];
            if(sum<0){
                low++;
            } else if(sum>0){
                high--;
            } else{
                list.add(List.of(nums[index],nums[low],nums[high]));
                low++;
                high--;
                while(low<high && nums[low]==nums[low-1]){
                    low++;
                }
            }
        }
    }
}
```

- Time complexity:
O(nlogn +n^2), so O(n^2)
- Space complexity:
O(n), for sorting

### Q 3 sum smaller 

Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 

Example 1:

Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]

```
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int low=i+1,high=nums.length-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if(sum<target){
                    count+=high-low;
                    low++;
                }
                else if(sum>=target){
                    high--;
                }
            }
        }
        return count;
    }
}
```
### 3 Sum closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

```
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int low=i+1, high=nums.length-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                int diff = Math.abs(sum-target);
                closestSum = Math.abs(closestSum-target)>diff?sum:closestSum;
                if(sum<target){
                    low++;
                } else if(sum>target){
                    high--;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }
}
```