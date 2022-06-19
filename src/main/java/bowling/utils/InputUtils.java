package bowling.utils;

import java.util.Scanner;

public class InputUtils {
//    private static final Scanner scanner = new Scanner(System.in);
//    private static final String NEW_LINE_CHARACTER = "[\\r\\n]+";

    private InputUtils() {
        throw new AssertionError();
    }

    public static String scan(String inputText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputText);
        return scanner.nextLine();
    }

    public static int scanNumber(String inputText) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(inputText);
        return scanner.nextInt();
    }
}