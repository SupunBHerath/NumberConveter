import java.util.Scanner;

public class NCSystemLoop {
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Home: while (true) {
            clearConsole();
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

            System.out.println(
                    "  _   _                       _                         ____                                         _                 \n"
                            + " | \\ | |  _   _   _ __ ___   | |__     ___   _ __      / ___|   ___    _ __   __   __   ___   _ __  | |_    ___   _ __ \n"
                            + " |  \\| | | | | | | '_ ` _ \\  | '_ \\   / _ \\ | '__|    | |      / _ \\  | '_ \\  \\ \\ / /  / _ \\ | '__| | __|  / _ \\ | '__|\n"
                            + " | |\\  | | |_| | | | | | | | | |_) | |  __/ | |       | |___  | (_) | | | | |  \\ V /  |  __/ | |    | |_  |  __/ | |   \n"
                            + " |_| \\_|  \\__,_| |_| |_| |_| |_.__/   \\___| |_|        \\____|  \\___/  |_| |_|   \\_/    \\___| |_|     \\__|  \\___| |_|   \n"
                            + "                                                                                                                       ");
            System.out.println(
                    "=======================================================================================================================\n");

            System.out.println(
                    "\n\n\t[01] Decimal Conveter\n\n\t[02] Binary Conveter\n\n\t[03] Octal Conveter\n\n\t[04] Hexadecimal Conveter\n\n\t[05] Roman Number Conveter");
            System.out.print("\n\n\nEnter Option -> ");
            String num = sc.next();

            switch (num) {
                case "1":
                    D: while (true) {
                        clearConsole();
                        System.out.println("\n+-------------------------------------------+");
                        System.out.println("|           Decimal Converter               |");
                        System.out.println("+-------------------------------------------+\n");

                        System.out.print("\n\nEnter a Decimal number : ");
                        try {

                            int decimalInput = sc.nextInt();
                            if (decimalInput < 0) {
                                System.out.println("\n\t\tInvalid Input... \n");
                                System.out.print("Do you want Input number again (Y/N) ->  ");
                                char ans = sc.next().toUpperCase().charAt(0);
                                if (ans == 'Y') {
                                    continue;
                                } else {
                                    continue Home;
                                }
                            }

                            // Convert to binary
                            String binary = "";
                            int decimal = decimalInput;
                            if (decimal == 0) {
                                binary = "0";
                            } else {
                                while (decimal > 0) {
                                    binary = (decimal % 2) + binary;
                                    decimal = decimal / 2;
                                }
                            }

                            // Convert to octal
                            String octal = "";
                            decimal = decimalInput;
                            if (decimal == 0) {
                                octal = "0";
                            } else {
                                while (decimal > 0) {
                                    octal = (decimal % 8) + octal;
                                    decimal = decimal / 8;
                                }
                            }

                            // Convert to hexadecimal
                            String hex = "";
                            char[] hexDigits = "0123456789ABCDEF".toCharArray();
                            decimal = decimalInput;
                            if (decimal == 0) {
                                hex = "0";
                            } else {
                                while (decimal > 0) {
                                    hex = hexDigits[decimal % 16] + hex;
                                    decimal = decimal / 16;
                                }
                            }

                            System.out.println("\n\n\tBinary Number\t\t: " + binary);
                            System.out.println("\n\tOctal Number\t\t: " + octal);
                            System.out.println("\n\tHexadecimal Number\t: " + hex);
                            while (true) {
                                System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
                                String ans = sc.next().toUpperCase();
                                if (ans.equals("Y")) {
                                    continue Home;
                                } else {
                                    sc.close();
                                    clearConsole();
                                    System.exit(0);

                                }
                            }
                        } catch (Exception e) {
                            sc.nextLine();
                            System.out.println("\n\t\tInvalid Input... \n");
                            System.out.print("Do you want to input the number again (Y/N) ->  ");
                            String ans = sc.next().toUpperCase();
                            if (ans.equals("Y")) {
                                continue D;
                            } else {
                                continue Home;
                            }
                        }

                    }

                case "2":
                    while (true) {
                        clearConsole();
                        System.out.println("\n+-------------------------------------------+");
                        System.out.println("|            Binary Converter               |");
                        System.out.println("+-------------------------------------------+\n");

                        System.out.print("\n\nEnter a Binary number : ");
                        String binaryInput = sc.next();

                        if (!binaryInput.matches("[01]+")) {
                            System.out.println("\n\t\tInvalid Input... \n");
                            System.out.print("Do you want Input number again (Y/N) ->  ");
                            char ans = sc.next().toUpperCase().charAt(0);
                            if (ans == 'Y') {
                                continue;
                            } else {
                                continue Home;
                            }
                        }
                        // Convert to Decimal
                        int decimal = 0;
                        for (int i = 0; i < binaryInput.length(); i++) {
                            char bit = binaryInput.charAt(i);
                            decimal = decimal * 2 + (bit - '0');
                        }
                        int tem = decimal;

                        // Convert to octal
                        String octal = "";
                        if (tem == 0) {
                            octal = "0";
                        } else {
                            while (tem > 0) {
                                octal = (tem % 8) + octal;
                                tem = tem / 8;
                            }
                        }

                        // Convert to hexadecimal
                        String hex = "";
                        tem = decimal;
                        char[] hexDigits = "0123456789ABCDEF".toCharArray();
                        if (decimal == 0) {
                            hex = "0";
                        } else {
                            while (tem > 0) {
                                hex = hexDigits[tem % 16] + hex;
                                tem = tem / 16;
                            }
                        }

                        System.out.println("\n\n\tDecimal Number\t\t: " + decimal);
                        System.out.println("\n\tOctal Number\t\t: " + octal);
                        System.out.println("\n\tHexadecimal Number\t: " + hex);
                        while (true) {
                            System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
                            char ans = sc.next().toUpperCase().charAt(0);
                            if (ans == 'Y') {
                                continue Home;
                            } else {
                                sc.close();
                                clearConsole();
                                System.exit(0);

                            }
                        }
                    }

                case "3":
                    while (true) {
                        clearConsole();
                        System.out.println("\n+-------------------------------------------+");
                        System.out.println("|            Octal Converter                |");
                        System.out.println("+-------------------------------------------+\n");

                        System.out.print("\n\nEnter a Octal number : ");
                        String octalInput = sc.next();

                        boolean isOctal = false;
                        for (int i = 0; i < octalInput.length(); i++) {
                            char digit = octalInput.charAt(i);
                            if (digit < '0' || digit > '7') {
                                isOctal = true;
                                break;
                            }
                        }

                        if (isOctal) {
                            System.out.println("\n\t\tInvalid Input... \n");
                            System.out.print("Do you want to input the number again (Y/N) ->  ");
                            char ans = sc.next().toUpperCase().charAt(0);
                            if (ans == 'Y') {
                                continue;
                            } else {
                                break;
                            }
                        }

                        // Convert octal to decimal
                        int decimal = 0;
                        for (int i = 0; i < octalInput.length(); i++) {
                            char digit = octalInput.charAt(i);
                            int value = digit - '0';
                            decimal = decimal * 8 + value;
                        }

                        // Convert decimal to binary
                        int temp = decimal;
                        String binary = "";
                        if (temp == 0) {
                            binary = "0";
                        } else {
                            while (temp > 0) {
                                binary = (temp % 2) + binary;
                                temp = temp / 2;
                            }
                        }

                        // Convert decimal to hexadecimal
                        temp = decimal;
                        String hex = "";
                        char[] hexDigits = "0123456789ABCDEF".toCharArray();
                        if (temp == 0) {
                            hex = "0";
                        } else {
                            while (temp > 0) {
                                hex = hexDigits[temp % 16] + hex;
                                temp = temp / 16;
                            }
                        }

                        // Display results
                        System.out.println("\n\n\tDecimal Number\t\t: " + decimal);
                        System.out.println("\n\tBinary Number\t\t: " + binary);
                        System.out.println("\n\tHexadecimal Number\t: " + hex);
                        while (true) {
                            System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
                            char ans = sc.next().toUpperCase().charAt(0);
                            if (ans == 'Y') {
                                continue Home;
                            } else {
                                sc.close();
                                clearConsole();
                                System.exit(0);

                            }
                        }
                    }
                case "4":
                    while (true) {
                        clearConsole();
                        System.out.println("\n+-------------------------------------------+");
                        System.out.println("|            HexaDecimal Converter          |");
                        System.out.println("+-------------------------------------------+\n");

                        System.out.print("\n\nEnter a HexaDecimal number : ");
                        String hexInput = sc.next();

                        boolean isHex = false;
                        for (int i = 0; i < hexInput.length(); i++) {
                            char digit = hexInput.charAt(i);
                            if ((digit < '0' || digit > '9') && (digit < 'A' || digit > 'F')
                                    && (digit < 'a' || digit > 'f')) {
                                isHex = true;
                                break;
                            }

                        }
                        if (isHex) {
                            System.out.println("\n\t\tInvalid Input... \n");
                            System.out.print("Do you want Input number again (Y/N) ->  ");
                            char ans = sc.next().toUpperCase().charAt(0);
                            if (ans == 'Y') {
                                continue;
                            } else {
                                continue Home;
                            }
                        }
                        int decimal = 0;
                        for (int i = 0; i < hexInput.length(); i++) {
                            char digit = hexInput.charAt(i);
                            int value = digit - '0';
                            decimal = decimal * 16 + value;
                        }
                        int tem = decimal;

                        // Convert to binary
                        String binary = "";
                        if (tem == 0) {
                            binary = "0";
                        } else {
                            while (tem > 0) {
                                binary = (tem % 2) + binary;
                                tem = tem / 2;
                            }
                        }

                        // Convert to octal
                        String octal = "";
                        tem = decimal;

                        if (tem == 0) {
                            octal = "0";
                        } else {
                            while (tem > 0) {
                                octal = (tem % 8) + octal;
                                tem = tem / 8;
                            }
                        }

                        System.out.println("\n\n\tDecimal Number\t\t: " + decimal);
                        System.out.println("\n\tBinary Number\t\t: " + binary);
                        System.out.println("\n\tOctal Number\t\t: " + octal);
                        while (true) {
                            System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
                            char ans = sc.next().toUpperCase().charAt(0);
                            if (ans == 'Y') {
                                continue Home;
                            } else {
                                sc.close();
                                clearConsole();
                                System.exit(0);

                            }
                        }
                    }
                case "5":
                    Roman: while (true) {
                        clearConsole();
                        System.out.println("\n+-------------------------------------------+");
                        System.out.println("|          Roman Number Converter           |");
                        System.out.println("+-------------------------------------------+\n");

                        System.out.println(
                                "\n\t[01] Decimal Number to Roman Number Converter\n\n\t[02] Roman Number to Decimal  Number Converter\n");
                        System.out.print("\nEnter an option : ");
                        String input = sc.next();

                        switch (input) {
                            case "1":
                                DR: while (true) {
                                    clearConsole();
                                    System.out.println("\n+--------------------------------------------+");
                                    System.out.println("|  Decimal Number to Roman Number Converter  |");
                                    System.out.println("+--------------------------------------------+\n");
                                    try {
                                        System.out.print("\nEnter a Decimal Number : ");
                                        int decimalInput = sc.nextInt();
                                        if (decimalInput < 0) {
                                            System.out.println("\n\t\tInvalid Input... \n");
                                            System.out.print("Do you want Input number again (Y/N) ->  ");
                                            char ans = sc.next().toUpperCase().charAt(0);
                                            if (ans == 'Y') {
                                                continue;
                                            } else {
                                                continue Roman;
                                            }
                                        }

                                        int[] decimalValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
                                        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                                                "V",
                                                "IV", "I" };

                                        StringBuilder romanNumeral = new StringBuilder();

                                        for (int i = 0; i < decimalValues.length; i++) {
                                            while (decimalInput >= decimalValues[i]) {
                                                romanNumeral.append(romanSymbols[i]);
                                                decimalInput -= decimalValues[i];
                                            }
                                        }
                                        System.out.println("\n\n\tRoman Number\t: " + romanNumeral.toString());
                                        while (true) {
                                            System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
                                            char ans = sc.next().toUpperCase().charAt(0);
                                            if (ans == 'Y') {
                                                continue Home;
                                            } else {
                                                sc.close();
                                                clearConsole();
                                                System.exit(0);
                                            }
                                        }
                                    } catch (Exception e) {
                                        sc.nextLine();
                                        System.out.println("\n\t\tInvalid Input... \n");
                                        System.out.print("Do you want to input the number again (Y/N) ->  ");
                                        String ans = sc.next().toUpperCase();
                                        if (ans.equals("Y")) {
                                            continue;
                                        } else {
                                            continue Roman;
                                        }
                                    }
                                }

                            case "2":
                                while (true) {
                                    clearConsole();
                                    System.out.println("\n+--------------------------------------------+");
                                    System.out.println("|  Roman Number to Decimal Number Converter  |");
                                    System.out.println("+--------------------------------------------+\n");

                                    try {
                                        System.out.print("\nEnter a Roman Number : ");
                                        String roman = sc.next().toUpperCase();

                                        // Validate Roman numeral input
                                        if (!roman.matches(
                                                "^(?i:M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
                                            System.out.println("\n\t\tInvalid Input... \n");
                                            System.out.print("Do you want to input the number again (Y/N) ->  ");
                                            String ans = sc.next().toUpperCase();
                                            if (!ans.equals("Y")) {
                                                continue Roman;
                                            }
                                            continue;
                                        }

                                        // Conversion from Roman to Decimal
                                        int decimal = 0;
                                        int i = 0;
                                        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
                                                "IV", "I" };
                                        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

                                        for (int j = 0; j < symbols.length; j++) {
                                            while (roman.startsWith(symbols[j], i)) {
                                                decimal += values[j];
                                                i += symbols[j].length();
                                            }
                                        }

                                        // Output decimal number
                                        System.out.println("\n\n\tDecimal Number\t: " + decimal);

                                        while (true) {
                                            System.out.print("\n\nDo you want to go to the Home page (Y/N) -> ");
                                            char ans = sc.next().toUpperCase().charAt(0);
                                            if (ans == 'Y') {
                                                continue Home;
                                            } else {
                                                sc.close();
                                                clearConsole();
                                                System.exit(0);
                                            }
                                        }

                                    } catch (Exception e) {
                                        sc.nextLine();
                                        System.out.println("\n\t\tInvalid Input... \n");
                                        System.out.print("Do you want to input the number again (Y/N) ->  ");
                                        String ans = sc.next().toUpperCase();
                                        if (!ans.equals("Y")) {
                                            continue Home;
                                        }
                                        continue;
                                    }
                                }

                            default:
                                System.out.print("\n\t\tInvalid Input... \n\n");
                                System.out.print("Do you want Input number again (Y/N) ->  ");
                                char ans = sc.next().toUpperCase().charAt(0);
                                if (ans == 'Y') {
                                    continue Roman;
                                } else {
                                    continue Home;
                                }
                        }

                    }
                default:
                    System.out.print("\n\t\tInvalid Input... \n\n");
                    System.out.print("Do you want Input number again (Y/N) ->  ");
                    char ans = sc.next().toUpperCase().charAt(0);
                    if (ans == 'Y') {
                        continue Home;
                    } else {
                        sc.close();
                        clearConsole();
                        System.exit(0);
                        break;
                    }
            }

        }

    }
}
