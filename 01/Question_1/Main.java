import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>(); 
        char operation;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            array.add(scanner.nextInt());
        }

        Collections.sort(array);  // Sort cars
        System.out.println(array);

        System.out.print("Please enter your operation (+ - * /): ");
        operation = scanner.next().charAt(0);

        int answer1 = 1;
        int answer2 = 1;
        
        for (int i = 0; i < array.get(0); i++) {
            answer1 *= array.get(1);
        }

        switch(operation) {
            case '+':
                answer2 = array.get(1) + array.get(2);
                break;
            case '-':
                answer2 = array.get(1) - array.get(2);
                break;
            case '*':
                answer2 = array.get(1) * array.get(2);
                break;
            case '/':
                answer2 = array.get(1) / array.get(2);
                break;    
            default: 
                System.out.println("Operation not found");
                System.exit(0);
                break;
        }

        System.out.println("Answer 1: " + answer1);
        System.out.println("Answer 2: " + array.get(1) + " " +  operation  + " " + array.get(2) + " = " + answer2);
    }
}
