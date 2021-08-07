public class printStringReverse {
    static void printReverse(String text){
        recursivePrint(0,text);
    }
    static void recursivePrint(int index,String text){
        if(text==null||index>=text.length())
            return;
        recursivePrint(index+1,text);
        System.out.print(text.charAt(index));

    }
    public static void main(String[] args) {
        printReverse("Hello World");
        printReverse("");
    }
}
