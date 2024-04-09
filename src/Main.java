import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Please, type your full name:");
        String fullName = read.nextLine();
        System.out.println("What's your account type? (current or savings)");
        String accountType = read.nextLine();
        System.out.println("Type your initial balance:");
        double balance = read.nextDouble();

        System.out.println(STR."""
                **************************************************
                Customer's data:

                Name:                 \{fullName}
                Type of account:      \{accountType}
                Initial Balance:      U$ \{String.format("%.2f", balance)}
                **************************************************
                """);

        int operationOption = 0;

        while (operationOption != 4){
            System.out.println(STR."""
                Operations:

                1- Check Balances
                2- Deposit Amount
                3- Withdraw Amount
                4- Exit
                """);
            System.out.println("Enter the desired option:");
            operationOption = read.nextInt();

            switch (operationOption){
                case 1:

                    System.out.println(STR."""
                    -----------------------------------------------------------
                    Your current balance is U$ \{String.format("%.2f", balance)}
                    -----------------------------------------------------------
                    """);
                    break;

                case 2:

                    System.out.println("How much do you wish to deposit?");
                    double depositAmount = read.nextDouble();

                    while (depositAmount < 0){
                        System.out.println(STR."""
                        ----------------------------------------------------------------------------------
                        Invalid amount (U$ \{String.format("%.2f", depositAmount)}), please insert an amount higher than U$ 0.00!
                        ----------------------------------------------------------------------------------
                        """);
                        depositAmount = read.nextDouble();
                    }

                    balance += depositAmount;

                    System.out.println(STR."""
                    ------------------------------------------------------------------
                    Amount of U$ \{String.format("%.2f", depositAmount)} successfully!
                    """);
                    System.out.println(STR."""
                    Your current balance is U$ \{String.format("%.2f", balance)}
                    ------------------------------------------------------------------
                    """);
                    break;

                case 3:

                    System.out.println("How much do you wish to withdraw?");
                    double withdrawAmount = read.nextDouble();

                    if (withdrawAmount > balance){
                        System.out.println(STR."""
                        -----------------------------------------------------------------------------------------
                        Desired amount to withdraw (U$ \{withdrawAmount}) is higher than balance (U$ \{String.format("%.2f", balance)})!
                        """);
                        System.out.println(STR."""
                        Please, try a amount equal or lower than U$ \{String.format("%.2f", balance)}!
                        -----------------------------------------------------------------------------------------
                        """);
                    } else {
                        balance -= withdrawAmount;
                        System.out.println(STR."""
                        ------------------------------------------------------------------
                        Successful U$ \{String.format("%.2f", withdrawAmount)} withdrawal!
                        """);
                        System.out.println(STR."""
                        Your current balance is U$ \{String.format("%.2f", balance)}
                        ------------------------------------------------------------------
                        """);
                    }
                    break;

                case 5,6,7,8,9,0:
                    System.out.println("""
                    ------------------------------------------------------------------
                    Invalid Option!
                    ------------------------------------------------------------------
                    """);
                    break;


                default:
            }
        }

        System.out.println("Exiting the application...");

    }
}