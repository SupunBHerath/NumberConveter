

import java.util.Scanner;

/**
 *
 * @author supun
 */
public class NCSystem {

    public static Scanner sc = new Scanner(System.in);

    public static void displayHeader(String title) {
        int totalLength = 43;
        System.out.println("\n+-------------------------------------------+");
        int titleLength = title.length();
        int leftPadding = (totalLength - titleLength) / 2;
        System.out.printf("|%" + leftPadding + "s%s%" + (totalLength - leftPadding - titleLength) + "s|\n", "", title, "");
        System.out.println("+-------------------------------------------+\n");
    }

    public static void returnHome(String X) {
        System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
        char ans = sc.next().toUpperCase().charAt(0);
        switch (ans) {
            case 'Y' ->
                Home();
            default -> {
                switch (X) {
                    case "D" ->
                        Decimal();
                    case "B" ->
                        Binary();
                    case "H" ->
                        Hexadecimal();
                    case "O" ->
                        Octal();
                    case "DR" ->
                        DRConverter();
                    default ->
                        RDConverter();
                }
            }
        }
    }

    public static void Decimal() {
        try {
            displayHeader("Decimal Converter ");
            System.out.print("\nEnter a Decimal number: ");
            int num = sc.nextInt();
            if (num < 0) {
                System.out.println("\t\tInvalid Input...\n");
                System.out.print("Do you want Input number again (Y/N) ->  ");
                char ans = sc.next().toUpperCase().charAt(0);
                switch (ans) {
                    case 'Y' ->
                        Decimal();
                    case 'N' ->
                        Home();
                    default ->
                        Decimal();
                }
            }

            String binary = Integer.toBinaryString(num);
            System.out.println("\n\tBinary Number: " + binary);

            String octal = Integer.toOctalString(num);
            System.out.println("\tOctal Number : " + octal);

            String hex = Integer.toHexString(num);
            System.out.println("\tHexadecimal Number : " + hex);

            returnHome("D");

        } catch (Exception e) {
            System.out.println("Enter a valid Value ..\n ");
            Decimal();
        }
    }

    public static void Binary() {
        try {
            displayHeader("Binary Converter ");
            System.out.print("\nEnter a Binary number: ");
            String binaryInput = sc.next();

            if (!binaryInput.matches("[01]+")) {
                System.out.println("\t\tInvalid Input... ");
                System.out.print("Do you want Input number again (Y/N) ->  ");
                char ans = sc.next().toUpperCase().charAt(0);
                switch (ans) {
                    case 'Y' -> Binary();
                    case 'N' -> Home();
                    default -> throw new AssertionError();
                }
            }

            int num = Integer.parseInt(binaryInput, 2);

            System.out.println("\n\tDecimal Number: " + num);

            String octal = Integer.toOctalString(num);
            System.out.println("\tOctal Number : " + octal);

            String hex = Integer.toHexString(num);
            System.out.println("\tHexadecimal Number : " + hex);

            returnHome("B");

        } catch (Exception e) {
            System.out.println("Enter a valid value ..\n ");
            Binary();
        }
    }

    public static void Octal() {
        try {
            displayHeader("Octal Converter ");
            System.out.print("\nEnter a Octal number: ");
            String octalInput = sc.next();

            if (!octalInput.matches("[0-7]+")) {
                System.out.println("\t\tInvalid Input... ");
                System.out.print("Do you want Input number again (Y/N) -> ");
                char ans = sc.next().toUpperCase().charAt(0);
                switch (ans) {
                    case 'Y' -> Binary();
                    case 'N' -> Home();
                    default -> throw new AssertionError();
                }
            }

            int num = Integer.parseInt(octalInput, 8);

            System.out.println("\n\tDecimal Number: " + num);

            String binary = Integer.toBinaryString(num);
            System.out.println("\n\tBinary Number: " + binary);

            String hex = Integer.toHexString(num);
            System.out.println("\tHexadecimal Number : " + hex);

            returnHome("O");

        } catch (Exception e) {
            System.out.println("Enter a valid value ..\n ");
            Octal();
        }

    }

    public static void Hexadecimal() {
        try {

            displayHeader("HexaDecimal Converter ");

            System.out.print("\nEnter a Hexadecimal number: ");
            String hexInput = sc.next();

            if (!hexInput.matches("[0-9A-Fa-f]+")) {
                System.out.println("\t\tInvalid Input...");
                System.out.print("Do you want Input number again (Y/N) ->  ");
                char ans = sc.next().toUpperCase().charAt(0);
                switch (ans) {
                    case 'Y' -> Hexadecimal();
                    case 'N' -> Home();
                    default -> throw new AssertionError();
                }
            }

            int num = Integer.parseInt(hexInput, 16);

            System.out.println("\n\tDecimal Number: " + num);

            String binary = Integer.toBinaryString(num);
            System.out.println("\tBinary Number : " + binary);

            String octal = Integer.toOctalString(num);
            System.out.println("\tOctal Number : " + octal);

            returnHome("H");

        } catch (Exception e) {
            System.out.println("Enter a valid value ..\n ");
            Hexadecimal();
        }

    }

    public static void Roman() {

        displayHeader("Roman Number Converter ");

        System.out.println("\n\t[01] Decimal Number to Roman Number Converter\n\t[02] Roman Number to Decimal  Number Converter\n");
        System.out.print("\nEnter an option : ");

        String num = sc.next();
        switch (num) {
            case "1" ->
                DRConverter();
            case "2" ->
                RDConverter();
            default ->
                Roman();
        }
    }

    public static void DRConverter() {
        try {
            displayHeader("Decimal Number to Roman Number Converter ");
            System.out.print("Enter an Decimal Number : ");
            int num = sc.nextInt();
            if (num < 0) {
                System.out.println("\t\tInvalid Input...\n");
                System.out.print("Do you want Input number again (Y/N) ->  ");
                char ans = sc.next().toUpperCase().charAt(0);
                switch (ans) {
                    case 'Y' ->
                        DRConverter();
                    case 'N' ->
                        Home();
                    default ->
                        DRConverter();
                }

            }
            String roman = convertToRoman(num);
            System.out.println("\n\tRoman Numeral: " + roman);
            returnHome("DR");

        } catch (Exception e) {
            System.out.println("Enter a valid value ..\n ");
            DRConverter();
        }
    }

    public static void RDConverter() {
        try {
            displayHeader("Roman Number to Decimal Number Converter ");

            System.out.print("Enter an Roman Number : ");
            String roman = sc.next();
            if (roman.matches("^(?i:M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
                System.out.print("\t\tInvalid Input...\nDo you want Input number again (Y/N) -> ");
                char ans = sc.next().toUpperCase().charAt(0);
                switch (ans) {
                    case 'Y' -> RDConverter();
                    case 'N' -> Home();
                    default -> Roman();
                }

            }
            int decimal = convertToDecimal(roman);
            System.out.println("\n\tDecimal Number: " + decimal);

            returnHome("RD");

        } catch (Exception e) {
            System.out.println("Enter a valid value ..\n ");
            DRConverter();
        }
    }

    public static String convertToRoman(int number) {
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < decimalValues.length; i++) {
            while (number >= decimalValues[i]) {
                romanNumeral.append(romanSymbols[i]);
                number -= decimalValues[i];
            }
        }
        return romanNumeral.toString();
    }

    public static int convertToDecimal(String roman) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        int decimal = 0;

        for (int j = 0; j < symbols.length; j++) {
            while (roman.startsWith(symbols[j], i)) {
                decimal += values[j];
                i += symbols[j].length();
            }
        }
        return decimal;
    }

    public static void Home() {
        System.out.println("\n\t\t\t\t\t __   ______             __           \n"
                + "\t\t\t\t\t|  \\ /      \\           |  \\          \n"
                + "\t\t\t\t\t \\$$|  $$$$$$\\  ______  | $$  _______ \n"
                + "\t\t\t\t\t|  \\| $$   \\$$ |      \\ | $$ /       \\\n"
                + "\t\t\t\t\t| $$| $$        \\$$$$$$\\| $$|  $$$$$$$\n"
                + "\t\t\t\t\t| $$| $$   __  /      $$| $$| $$      \n"
                + "\t\t\t\t\t| $$| $$__/  \\|  $$$$$$$| $$| $$_____ \n"
                + "\t\t\t\t\t| $$ \\$$    $$ \\$$    $$| $$ \\$$     \\\n"
                + "\t\t\t\t\t \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$\n"
                + "\t\t\t\t\t                                     ");

        System.out.println("  _   _                       _                         ____                                         _                 \n"
                + " | \\ | |  _   _   _ __ ___   | |__     ___   _ __      / ___|   ___    _ __   __   __   ___   _ __  | |_    ___   _ __ \n"
                + " |  \\| | | | | | | '_ ` _ \\  | '_ \\   / _ \\ | '__|    | |      / _ \\  | '_ \\  \\ \\ / /  / _ \\ | '__| | __|  / _ \\ | '__|\n"
                + " | |\\  | | |_| | | | | | | | | |_) | |  __/ | |       | |___  | (_) | | | | |  \\ V /  |  __/ | |    | |_  |  __/ | |   \n"
                + " |_| \\_|  \\__,_| |_| |_| |_| |_.__/   \\___| |_|        \\____|  \\___/  |_| |_|   \\_/    \\___| |_|     \\__|  \\___| |_|   \n"
                + "                                                                                                                       ");
        System.out.println("=======================================================================================================================\n");

        System.out.println("\n\t[01] Decimal Conveter\n\t[02] Binary Conveter\n\t[03] Octal Conveter\n\t[04] Hexadecimal Conveter\n\t[05] Roman Number Conveter");
        System.out.print("\nEnter Option -> ");
        String num = sc.next();

        switch (num) {
            case "1" -> Decimal();
            case "2" -> Binary();
            case "3" -> Octal();
            case "4" -> Hexadecimal();
            case "5" -> Roman();
            default -> Home();
        }
    }

    public static void main(String[] args) {
        Home();
    }
}
