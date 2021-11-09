import java.util.Scanner;
import java.text.DecimalFormat;

public class BMI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("***************************************************************");
        System.out.println("This program is to calculate the BMI Using the Metric Form !!");
        System.out.println("This program is created by Mohammed Rasheed M ©");
        System.out.println("***************************************************************");
        System.out.println();
        System.out.print("Enter your height (Cm) : ");
        double height = sc.nextDouble();
        System.out.print("Enter your weight (Kg) : ");
        double weight = sc.nextDouble();
        sc.close();
        BMICalc(height, weight);

    }

    private static void BMICalc(double height, double weight) {
        double BMI = ((weight / height / height) * 10000);
        DecimalFormat d = new DecimalFormat("0.0");
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("BMI : " + d.format(BMI));
        System.out.println("----------------------------");
        Info(BMI);

    }

    private static void Info(double BMI) {
        if(BMI<18.5);{
            System.out.println("Under Weight !!");
        }
        else if(BMI >=18.5 && BMI<24.9){
            System.out.println("Normal Weight !!");
        }
        else if(BMI >=24.9 && BMI<29.9){
            System.out.println("Over Weight !!");
        }
        else if(BMI> 29.9){
            System.out.println("Obesity !!");
        }
    }
}
