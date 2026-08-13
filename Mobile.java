import java.util.ArrayList;

public class Mobile {
    public static void main(String[] args) {
        String number = "+91-";
        for (int i = 0; i < 10; i++) {
            int num =(int) (Math.random() * 9 )+ 1;
            number += num;
        }
        System.out.println(number);
        System.out.println(number.getClass());
    }
}
