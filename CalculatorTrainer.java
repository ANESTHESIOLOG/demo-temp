import java.util.*;

public class CalculatorTrainer {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите пример для вычисления (все символы вводятся через пробел): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String calc = calc(input);
        System.out.println("Ответ выражения: " + calc);
    }

    public static String calc(String input) throws Exception {
        String[] romanMas = new String[]{"0", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
                "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
                "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
                "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI",
                "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        List<String> romanMasList = new ArrayList<>(Arrays.asList(romanMas));
        String[] arabianMas = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
                "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38",
                "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53",
                "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67",
                "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81",
                "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96",
                "97", "98", "99", "100"};
        List<String> arabianMasList = new ArrayList<>(Arrays.asList(arabianMas));

        String[] token = input.split(" ");
        if (token.length != 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (arabianMasList.contains(token[0]) != arabianMasList.contains(token[2])) {
            throw new Exception("Числа должны быть в одной системе исчисления");
        }
        if (romanMasList.contains(token[0]) != romanMasList.contains(token[2])) {
            throw new Exception("Числа должны быть в одной системе исчисления");
        }
        String result = null;

        if (arabianMasList.contains(token[0])) {
            int a = Integer.parseInt(token[0]);
            if (a < 1 || a > 10) {
                throw new Exception("Вы должны ввести данные от 1 до 10");
            }
            if (arabianMasList.contains(token[2])) {
                int b = Integer.parseInt(token[2]);
                if (b < 1 || b > 10) {
                    throw new Exception("Вы должны ввести данные от 1 до 10");
                }
                if (token[1].length() > 1) {
                    throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                int result1 = switch (token[1]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                result = Integer.toString(result1);
            }
        }

        int a = 0;
        if (romanMasList.contains(token[0])) {
            for (int i = 0; i < romanMas.length; i++) {
                if (Objects.equals(romanMas[i], token[0])) {
                    a = i;
                    if (a > 10 || a < 1) {
                        throw new Exception("Вводимые цифры могут быть от I до X");
                    }
                }
            }
            int b = 0;
            if (romanMasList.contains(token[2])) {
                for (int i = 0; i < romanMas.length; i++) {
                    if (Objects.equals(romanMas[i], token[2])) {
                        b = i;
                        if (b > 10 || b < 1) {
                            throw new Exception("Вводимые цифры могут быть от I до X");
                        }
                    }
                }
            }
            if (token[1].length() > 1) {
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            int result1 = switch (token[1]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> 0;
            };
            if (result1 < 0) {
                throw new Exception("Отрицательных числел нет в римском алфавите");
            }
            if (result1 == 0) {
                throw new Exception("0 нет в римском исчислении");
            }
            result = romanMas[result1];

        } return result;
    }
}










