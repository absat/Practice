class Test {
    static long calcRepeatDigit( int d, int repeat) {
        long sum = 0;
        for(int i=1;i<=repeat;i++){
            int num=d;
            for(int j=1;j<=i;j++){
                if(j>1){
                    num*=10;
                    num+=d;
                }
            }
            sum+=num;
        }
        return sum;
    }
    public static void main(String[] args){
        long answer = calcRepeatDigit(3,0);
        System.out.println(answer);
    }
}
