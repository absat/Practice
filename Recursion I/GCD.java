public class GCD {
    public static void main(String[] args){
        int[][] tests = new int[][]{{156,36},{2,3}};
        for(int[] test: tests){
            int x = Math.min(test[0],test[1]), y = Math.max(test[0],test[1]);
            System.out.println("gcd = "+getGCD(x,y));
        }
    }

    private static int getGCD(int x, int y){
        return x==0 ? y : getGCD(y%x,x);
    }
}
