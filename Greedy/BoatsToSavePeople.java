class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int heavy = people.length-1,light=0,count=0;
        while(heavy>=light){
            int heavyVal=people[heavy], lightVal=people[light];
            if(heavyVal+lightVal<=limit){
                heavy--;
                light++;
            }
            else{
                heavy--;
            }
            count++;
        }
        return count;
    }
}
/*
 * TC O(nlog(n)) (sort)
 * SC O(log (n) ) In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(log⁡n)
 */