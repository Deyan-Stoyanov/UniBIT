import java.util.Scanner;

public class QuadraticFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Въведете а: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Въведете b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Въведете c: ");
        double c = Double.parseDouble(scanner.nextLine());
        double discriminant = Math.pow(b, 2) - (4 * a * c);
        if(discriminant > 0){
            double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("Уравнението има 2 реални корена: x1 = %.2f и x2 = %.2f \n", x1, x2);
            if(a > 0 ){
                System.out.printf("Функцията е положителна от -∞ до %.2f, отрицателна от %.2f до %.2f, и положителна от %.2f до +∞ \n", x1, x2, x2, x1);
            } else {
                System.out.printf("Функцията е отрицателна от -∞ до %.2f, положителна от %.2f до %.2f, и отрицателна от %.2f до +∞ \n", x1, x2, x2, x1);
            }
        }else if(discriminant == 0){
            double x = -b / (2 * a);
            System.out.printf("Уравнението има 1 реален корен: x = %.2f \n", x);
            if(a > 0 ){
                System.out.printf("Функцията е положителна от -∞ до %.2f , и от %.2f до +∞ \n", x, x);
            } else {
                System.out.printf("Функцията е отрицателна от -∞ до %.2f, и от %.2f до +∞ \n", x, x);
            }
        } else {
            System.out.println("Уравнението няма реални корени \n");
        }
    }
}
