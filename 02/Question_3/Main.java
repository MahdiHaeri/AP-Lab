import java.util.Scanner;

class Main {
    public static void decimalToBinary(int to, int number) {
        String answer = "";
        while (number != 0) {
            answer  = answer + (number % to);
            number /= to;
        }
        String reverseAnswer = "";
        for (int i = 0; i < answer.length(); i++) {
            reverseAnswer = answer.charAt(i) + reverseAnswer;
        }
        System.out.println(reverseAnswer);
    }

    public static void binaryToDecimal(String number) {
        int answer = 0;
        int value = 1;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(number.substring(i, i + 1));
            if (digit != 1 && digit != 0) {
                System.out.println("Invalid binary number!");
		return;
            }
            answer += (value * digit);
            value *= 2;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. bainry to decimal");
            System.out.println("2. decimal to bainry");
            System.out.println("3. exit");
            
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            
            switch(input) {
                case 1:
                    System.out.print("Enter Decimal number: ");
                    int decimalNumber = scanner.nextInt();
                    decimalToBinary(2, decimalNumber);
                    break;
                case 2:
                    System.out.print("Enter Decimal number: ");
                    scanner.nextLine();
                    String binaryNumber = scanner.nextLine();
                    binaryToDecimal(binaryNumber);
                    break;
                case 3: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
