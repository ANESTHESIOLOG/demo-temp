import java.util.Scanner;

public class StringCalc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        String[] str = stringInput.split("\""); //режем строку на массив, по ковычкам
        calculator(str);
    }

        public static void calculator(String[] str) throws Exception {
            String a = null, op = null, b = null;
            int numberB = 0;

            if (str.length > 3) {
                a = str[1];
                op = str[2];
                if (op.contains("/")) {
                    throw new Exception("Нельзя делить строку на строку!");
                }
                if (op.contains("*")) {
                    throw new Exception("Нельзя умножать строки!");
                }
                b = str[3];
                if (a.length()>10 || b.length()>10) {
                    throw new Exception("Строки должны быть менее 11-ти символов");
                }
            } else {
                if (str[0].contains(" ")) {
                    throw new Exception("Ввод вычисления всегда начинается со строки в кавычках");
                }
                a = str[1];
                if (a.length()>10) {
                    throw new Exception("Строки должны быть менее 11-ти символов");
                }
                op = str[2];
                String[] op2 = op.split(" ");
                op = op2[1];
                b = op2[2];
                numberB = Integer.parseInt(b);
                if (numberB>10 || numberB<0) {
                    throw new Exception("Цифры и числа должны быть в диапазоне от 1 до 10");
                }
            }
            if (op.equals(" + ")) {
                summa(a, b);
                System.out.println(summa(a, b));
            } else if (op.equals(" - ")) {
                subtraction(a, b);
                System.out.println(subtraction(a, b));
            } else if (op.equals("*")) {
                multiplication(a, numberB);
                System.out.println(multiplication(a, numberB));
            } else if (op.equals("/")) {
                division(a, numberB);
                System.out.println(division(a, numberB));
            }
        }
            public static String summa(String a, String b) {
                String result = a+b;
                return quotationMarks(result);
            }
            public static String subtraction(String a, String b) {
                String result = a.replaceAll(b, "");
                return quotationMarks(result);
            }
            public static String multiplication (String a, int b) throws Exception {
                String result = a.repeat(b);
                if (result.length()>=40) {
                    result = result.substring(0, 40) + "...";
                }
                return quotationMarks(result);
            }
            public static String division (String a, int b) throws Exception {
                String result = null;
                int dlinnaStringA = a.length();
                char[] massivA = a.toCharArray();
                int delenie = dlinnaStringA/b;
                char[] resultat = new char[delenie];
                for (int i = 0; i < delenie; i++) {
                    resultat[i] = massivA[i];
                }
                result = result.copyValueOf(resultat);
                return quotationMarks(result);
            }

            public static String quotationMarks (String a) {
                a = "\"" + a + "\"";
                return a;
            }
    }


