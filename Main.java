import java.util.Scanner;

public class Main {

    public static void createAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        account.setName(scanner.nextLine());
        System.out.print("\nEnter your gender: ");
        account.setGender(scanner.nextLine());
        System.out.print("\nEnter your birthday: ");
        account.setBirthday(scanner.nextLine());
        System.out.print("\nEnter your address: ");
        account.setAddress(scanner.nextLine());
        System.out.print("\nEnter your email: ");
        account.setEmail(scanner.nextLine());
        account.setMoney(0);
        account.setNumberOfTrans(0);
        System.out.println(account.toString());
    }

    public static void depositAccount(Account account[], int accNb, int amount, int siSo) {
        for (int i = 0; i < siSo; i++) {
            if (account[i].getId() == accNb) {
                try {
                    if (amount > 0) {
                        account[i].setMoney(account[i].getMoney() + amount);
                        account[i].setNumberOfTrans(account[i].getNumberOfTrans() + 1);
                    } else {
                        System.out.println("Deposit money is more than 0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void withdrawAccount(Account account[], int accNb, int amount, int siSo) {
        for (int i = 0; i < siSo; i++) {
            if (account[i].getId() == accNb) {
                try {
                    if (account[i].getMoney() > amount) {
                        account[i].setMoney(account[i].getMoney() - amount);
                        account[i].setNumberOfTrans(account[i].getNumberOfTrans() + 1);
                        System.out.println("Your curent balance is " + amount + "$");
                    } else {
                        throw new MyException("Sorry. But you are short " + amount + "$");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showNumberTrans(Account account[], int accNb, int siSo) {
        for (int i = 0; i < siSo; i++) {
            try {
                if (account[i].getId() == accNb) {
                    System.out.println("Number of trans = " + account[i].getNumberOfTrans());
                    System.out.println(account[i].toString());
                } else {
                    System.out.println("Account number does not exist!!! ");
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Account listAccount[] = new Account[20];
        int siSo = 0;
        String select;
        Scanner sc = new Scanner(System.in);
        System.out.println("please choicce your option: ");

        do {
            System.out.println("____________________________");
            System.out.println("Open an account (enter: 1)");
            System.out.println("Make a deposit (enter: 2)");
            System.out.println("Make a withdraw (enter: 3)");
            System.out.println("Show the number of transactions (enter: 4)");
            System.out.println("Exit the ATM (enter: 5)");
            System.out.println("____________________________");

            select = sc.nextLine();
            switch (select) {
                case "1": {
                    System.out.println("Your choice: Open");
                    listAccount[siSo] = new Account();
                    createAccount(listAccount[siSo]);
                    siSo++;
                    break;
                }
                case "2": {
                    System.out.println("Your choice: Deposit");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nEnter your account number: ");
                    int acn = scanner.nextInt();
                    System.out.println("\nEnter your amount: ");
                    int am = scanner.nextInt();
                    depositAccount(listAccount, acn, am, siSo);
                    //continue;
                    break;
                }
                case "3": {
                    System.out.println("Your choice: Withdraw");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nEnter your account number: ");
                    int acn = scanner.nextInt();
                    System.out.println("\nEnter your amount: ");
                    int am = scanner.nextInt();
                    withdrawAccount(listAccount, acn, am, siSo);
                    break;
                }
                case "4": {
                    System.out.println("Your choice: Transactions");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nEnter your account number: ");
                    int acn = scanner.nextInt();
                    showNumberTrans(listAccount, acn, siSo);
                    break;
                }
                default: {
                    System.out.println("Exit");
                    System.exit(0);
                }
            }
        }
        while (select != " ");
    }

}