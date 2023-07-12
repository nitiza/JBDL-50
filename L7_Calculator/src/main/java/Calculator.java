import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Main main = new Main();

        switch (input) {
            case 1: // invoke add function of L5 project
                System.out.println(main.add(a, b));
                break;
            case 2: // invoke subtract function of L5 project
                System.out.println(main.subtract(a, b));
                break;
            case 3: // invoke multiply function of L5 project
                System.out.println(main.multiply(a, b));
                break;
            case 4: // invoke divide function of L5 project
                System.out.println(main.divide(a ,b));
                break;
            case 5:
                System.out.println(main.power(a, b));
                break;
            default:
                throw new Exception("Invalid input found");
        }
    }
}
