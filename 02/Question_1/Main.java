import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public void swap(ArrayList<Double> array, int i, int j) {
        double temp = array.get(j);
        array.set(j, array.get(j + 1));
        array.set(j + 1, temp);
    }
    
    public static void boubleSort(ArrayList<Double> array) {
        boolean flag = true;
        int size = array.size();
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    double temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pleae enter size of array: ");
        int n = scanner.nextInt();
        ArrayList<Double> array = new ArrayList<Double>();
        
        double number;
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ": ");
            number = scanner.nextDouble();
            array.add(number);
        }

        System.out.println(array);
        boubleSort(array);
        System.out.println(array);
    }
}