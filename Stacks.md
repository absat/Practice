### Valid Parantheses

# Intuition
case 1: "{" map is not empty in the end
case 2: "{)" not matching brackets
case 3: ")" stack is empty, no opening brackets
# Code
```java []
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            } else {
                if(stack.empty() || map.get(stack.pop())!=c){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
```


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Maintain 2 stacks, 1 for minimum only and 1 for normal stack
1. push element to minimum stack only if it is less than or equal to top of minimum stack.
2. Similarly at time of popping, if top of stack equals(top of minimum stack), remove number from minimum stack too.
3. getMin and top() are trivial, just get top of min and normal stack respectively

Question
But we dont store all elements in min stack? Wont we miss some elements after we start popping elements from main stack?

Answer: no, since we can pop elements only from one end in stack data structure.Every minimum element in min stack will be the minimum for all elements on top of it on the main stack

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
o(1)

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
o(n) for 2 stacks

# Code
```java []
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
    }

    
    public void pop() {
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();       
    }
    
    public int getMin() {
        return minStack.peek();       
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

### Palindrome Linkedlist

unoptimised: traverse linkedlist twice, insert into stack once on second traverse compare