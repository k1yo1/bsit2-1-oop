import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();

        gateway.add(new GCashPayment(1001, "Ana", 1500.00, "0917-555-0134"));
        gateway.add(new MayaPayment(1002, "Jerome", 899.50, "jerome@liceo.edu.ph"));
        gateway.add(new CashPayment(1003, "Liza", 250.00));

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("          LICEO PAY");
            System.out.println("     Payment Gateway System");
            System.out.println("======================================");
            System.out.println("1. Make a Payment");
            System.out.println("2. Show All Receipts");
            System.out.println("3. Find Payment by ID");
            System.out.println("4. Show Total Collected");
            System.out.println("5. Refund Every Refundable Payment");
            System.out.println("6. Show Service Fees");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        makePayment(sc, gateway);
                        break;

                    case 2:
                        System.out.println("\nAll Receipts:");
                        gateway.processAll();
                        break;

                    case 3:
                        System.out.print("Enter Payment ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Payment payment = gateway.findById(id);

                        if (payment != null) {
                            System.out.println("\nPayment Found:");
                            payment.printReceipt();
                            payment.printThankYou();
                        } else {
                            System.out.println("Payment ID not found.");
                        }
                        break;

                    case 4:
                        System.out.printf("\nTotal Collected: PHP %.2f%n",
                                gateway.totalCollected());
                        break;

                    case 5:
                        System.out.println("\nRefunding every payment that can be refunded:");
                        gateway.refundAll();
                        break;

                    case 6:
                        System.out.println("\nService fees (the two serviceFee methods):");
                        gateway.showServiceFees();
                        break;

                    case 0:
                        System.out.println("Thank you for using LICEO PAY!");
                        break;

                    default:
                        System.out.println("Invalid menu option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number only.");
                sc.nextLine();
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }

    public static void makePayment(Scanner sc, PaymentGateway gateway) {

        try {
            System.out.print("Enter Payment ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Payer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.println("\nPayment Method");
            System.out.println("1. GCash");
            System.out.println("2. Maya");
            System.out.println("3. Cash");
            System.out.print("Choose payment method: ");

            int method = sc.nextInt();
            sc.nextLine();

            Payment payment = null;

            switch (method) {

                case 1:
                    System.out.print("Enter Mobile Number: ");
                    String mobile = sc.nextLine();

                    payment = new GCashPayment(id, name, amount, mobile);
                    break;

                case 2:
                    System.out.print("Enter Email Address: ");
                    String email = sc.nextLine();

                    payment = new MayaPayment(id, name, amount, email);
                    break;

                case 3:
                    payment = new CashPayment(id, name, amount);
                    break;

                default:
                    System.out.println("Invalid payment method.");
                    return;
            }

            gateway.add(payment);

            System.out.println("\nPayment Added Successfully!");
            payment.printReceipt();
            payment.printThankYou();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            sc.nextLine();
        }
    }
}