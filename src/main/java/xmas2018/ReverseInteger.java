package xmas2018;

public class ReverseInteger{
    public int reverse(int x) {
        int abs = Math.abs(x);
        int symbol = abs/x;
        int left = abs;
        StringBuilder builder = new StringBuilder();
        while(left!=0){
            builder.append(left%10);
            left = left/10;
        }
        return (int)(Integer.parseInt(builder.toString())*symbol);
    }
    // avoids situation of overflow, and quicker
    public int reverseSmart(int x){
        int sum = 0;
        int leftout = x;
        int lastSum = 0;
        while(leftout!=0){
            int digit = leftout%10;
            sum = sum*10 + digit;
            if( (sum-digit )/10 != lastSum)
                return 0;
            lastSum = sum;
            leftout = leftout/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        //System.out.println(new ReverseInteger().reverse(-2147483648));

        System.out.println(new ReverseInteger().reverseSmart(-2147483648));
    }
}