import util.RomanArabicConverter;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        int value1 = 0;
        int value2 = 0;
        String operation = null;
        boolean isArabic = true;

        System.out.println("Input: ");
        Scanner scanner = new Scanner(System.in);
        String scan1 = scanner.next();
        operation = scanner.next();
        String scan2 = scanner.next();

        Boolean isArabic1 = isDigit(scan1);
        boolean isArabic2 = isDigit(scan2);

        // Проверка на аутентичность арабских или римских букв
        if (isArabic1.equals(isArabic2)) {
            value1 = getInt(isArabic1, scan1);
            value2 = getInt(isArabic2, scan2);

            // Проверка, что введённые числа от 1 до 10
            if (value1 < 1 || value1 > 10 || value2 < 1 || value2 > 10) {
                throw new RuntimeException("Incorrect numbers entered!");
            }

            if (isArabic1 != true && isArabic2 != true) isArabic = false;
        } else {
            throw new RuntimeException("The numbers are different!");
        }

        int num = calc(value1, value2, operation);
        String result = isArabic ? String.valueOf(num) : RomanArabicConverter.arabicToRoman(num);

        System.out.println("Output: " + result);

    }

    // Получение int из римких цифр
    public static int getInt(boolean isArabic, String scan){
        return isArabic ? Integer.parseInt(scan) :
                RomanArabicConverter.romanToArabic(scan);
    }

    // Калькулятор
    public static int calc(int num1, int num2, String operation) {
        int result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new RuntimeException("Arithmetic operation not recognized.");
        }
        return result;
    }

    // Проверка арабские или римские цифры
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
