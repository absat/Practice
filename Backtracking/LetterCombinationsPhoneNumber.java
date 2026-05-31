class Solution {
    private List<String> combinations = new ArrayList();
    private String phoneDigits;
    Map<Character,String> letters = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",
                                        '7',"pqrs",'8',"tuv",'9',"wxyz");
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return combinations;
        phoneDigits = digits;
        solve(0,new StringBuilder());
        return combinations;
    }

    private void solve(int index, StringBuilder currentCombination){
        if(currentCombination.length()==phoneDigits.length()){
            combinations.add(currentCombination.toString());
            return;
        }
        String lettersPossible = letters.get(phoneDigits.charAt(index));
        for(char c: lettersPossible.toCharArray()){
            currentCombination.append(c);
            solve(index+1,currentCombination);
            currentCombination.deleteCharAt(currentCombination.length()-1);
        }

    }
}
