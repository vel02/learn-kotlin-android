package interoperability.java;

import interoperability.kotlin.MyCustomKotlinFileName;

public class Main {

    public static void main(String[] args) {

        int sum = MyCustomKotlinFileName.add(3, 4);
        System.out.println("Printing sum from Java file: " + sum);

    }

    public static int getArea(int l, int b) {
        return l * b;
    }

}
