import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

class Karatsuba {
    private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);                // optimize this parameter
        
        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }

    public static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }
    public static void main(String[] args) {
        long start, stop, elapsed;
        Random random = new Random();
        // int N = 999999999;
        // BigInteger a = new BigInteger(N, random);
        // BigInteger b = new BigInteger(N, random);

        BigDecimal a=new BigDecimal("4325324532");
        BigDecimal b=new BigDecimal("9932232999");

        // start = System.currentTimeMillis(); 
        // //BigInteger c = karatsuba(a, b);
        // stop = System.currentTimeMillis();
        // System.out.println(stop - start);

        start = System.currentTimeMillis(); 
        BigDecimal c = a.multiply(b);
        BigDecimal d=sqrt(c);
        stop = System.currentTimeMillis();
        System.out.println(stop - start);

        System.out.println(d.toBigInteger().toString());
    }
}