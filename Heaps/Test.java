public class Test {
    enum L{
        Python(10-10+10*10),
        Java(10+10*10-10);
        private int coders;
        L(int p){
            coders = p;
        }
        int getcoders(){
            return coders;
        }
    }
    public static void main(String args[]){
        L ap;
        for(L a: L.values())
        System.out.println(a+" "+ a.getcoders());
    }
}
