class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Pair[] pairArr = new Pair[costs.length];
        for(int i=0;i<costs.length;i++){
            pairArr[i] = new Pair(costs[i][0],costs[i][1],costs[i][0]-costs[i][1], i);
        }
        Arrays.sort(pairArr,Comparator.comparing(Pair::getDiff1over2));
        int totalCost=0;
        for(int i=0;i<pairArr.length;i++){
            if(i<pairArr.length/2)
                totalCost+=pairArr[i].cost1;
            else
                totalCost+=pairArr[i].cost2;
        }
        return totalCost;
    }
    class Pair{
        int cost1, cost2, differenceCost1OverCost2, index;
        Pair(int cost1,int cost2,int differenceCost1OverCost2, int index){
            this.cost1 = cost1;
            this.cost2 = cost2;
            this.differenceCost1OverCost2 = differenceCost1OverCost2;
            this.index = index;
        }
        public int getDiff1over2(){
            return differenceCost1OverCost2;
        }
    }
}

/*
 * The solution can be solved using the greedy algorithm. From the statement, we know each person spends a certain amount of the company's
 *  money to travel to city A and City B. We have to divide people evenly among the cities so that the company has to spend a minimum amount of money. 
 * In any case, sending a person to city A will have cost A, and sending a person to city B will have cost B. 
 * For every decision, the company would bear an overall cost of cost A - cost B , which might be positive or negative.

The intuition we will use is to send maximum savings to city A and the remaining to city B. To do this, we will initialize a difference array 
that will store the difference of cost to send people to city A compared to city B. We'll do this by storing cost A - cost B for each person
 at its respective index in the difference array. Then, we will sort this array in
  ascending order and minimize the overall cost by sending the first n persons to city A and the remaining to city B.


  Time Complexity
We only traverse the array once but since we use sorting, the time complexity of the solution becomes O(nlogn).

Space Complexity
The space complexity of our solution is O(n+m)
, where n
n
 represents the number of elements we added into our difference array, and m
m
 represents the memory required to sort this array. Python uses a combination of merge sort and insertion sort which can sort the array in O(m)
O(m)
 but this can differ for other languages like Java or C++.
 */