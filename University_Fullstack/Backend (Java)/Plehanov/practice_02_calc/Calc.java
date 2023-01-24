import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        double result;
        //a = 2;
        //b = 3;
        System.out.println("Arithmetic operation (use comma) ");
        System.out.print("enter A = ");
        Scanner in = new Scanner(System.in);
        var a = in.nextDouble();
        
        System.out.print("enter B = ");
        var b = in.nextDouble();

        System.out.printf("entered data: A = %.2f; B = %.2f \n", a, b);
        
        result = a + b;
        System.out.printf("sum(%.2f + %.2f) = %.2f \n", a, b, result);
        
        result = a - b;
        System.out.printf("difference (%.2f + %.2f)  = %.2f \n", a, b, result);

        result = a * b;
        System.out.printf("multiplication (%.2f * %.2f) = %.2f \n", a, b, result);

        result = a / b;
        System.out.printf("division (%.2f / %.2f) = %.2f \n", a, b, result);
    }
}