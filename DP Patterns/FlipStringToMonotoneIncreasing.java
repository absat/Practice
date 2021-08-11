class Solution {
    public int minFlipsMonoIncr(String s) {
        int counterOne=0,counterFlip=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                counterOne++;
            else
                counterFlip++;
            counterFlip=Math.min(counterOne,counterFlip);
        }
        return counterFlip;
    }
}
/*
When '1' comes, no more flip should be applied, since '1' is appended to the tail of the original string.
When '0' comes, things become a little bit complicated. There are two options for us: flip the newly appended '0' to '1', after counter_flip flips for the original string; or flip counter_one '1' in the original string to '0'. Hence, the result of the next step of DP, in the '0' case, is std::min(counter_flip + 1, counter_one);.
source: https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C%2B%2B-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination.
*/