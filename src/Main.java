import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Investor inv = new Investor();
        ArrayList<Investor> investors = inv.readInvestors();

        boolean valid;
        String firstName, secondName, mail, phoneNumber;
        double sum;
        int loanTime;
        System.out.println("New client: ");

        do {
            valid = true;
            System.out.print("Insert first name: ");
            firstName = input.next();
            if (!firstName.matches("[A-Z][a-z]*")) {
                valid = false;
                System.out.println("Invalid first name!");
            }
        }
        while(!valid);
        do {
            valid = true;
            System.out.print("Insert second name: ");
            secondName = input.next();
            if (!secondName.matches("[A-Z][a-z]*")) {
                valid = false;
                System.out.println("Invalid second name!");
            }
        }
        while(!valid);

        do {
            valid = true;
            System.out.print("Insert email: ");
            mail = input.next();
            if(!mail.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") ||
                    !(mail.endsWith(".com") || mail.endsWith(".ro") ||
                     mail.endsWith(".gov") || mail.endsWith(".net"))) {
                valid = false;
                System.out.println("Invalid email address!");
            }
        }
        while(!valid);

        do {
            valid = true;
            System.out.print("Insert phone number: ");
            phoneNumber = input.next();
            if (!phoneNumber.startsWith("07") || !phoneNumber.matches("([0-9])\\d+")) {
                valid = false;
                System.out.println("Invalid phone number!");
            }
        }
        while(!valid);

        do {
            valid = true;
            System.out.print("Insert wanted sum: ");
            sum = input.nextDouble();
            double investorFunds = 0;
            for(int i = 0; i < investors.size(); i++)
                investorFunds += investors.get(i).getSum();
            if(sum > investorFunds) {
                    valid = false;
                    System.out.println("Insufficient funds!");
            }
        }
        while(!valid);

        do {
            valid = true;
            System.out.print("Insert time period for the loan: ");
            loanTime = input.nextInt();
            if(loanTime < 12) {
                valid = false;
                System.out.println("This period is too short!");
            }
        }
        while(!valid);

        Client client = new Client(firstName, secondName, mail, sum, phoneNumber, loanTime);

        Collections.sort(investors, new SortbyInterest());

        double wanted = client.getSum();
        boolean satisfied = false;

        for(int i = 0; i < investors.size() && !satisfied; i++) {
            if(wanted > investors.get(i).getSum()) {
                client.setTotalSum(investors.get(i).getSum(), investors.get(i).getInterest());
                wanted -= investors.get(i).getSum();
            }
            else {
                client.setTotalSum(wanted, investors.get(i).getInterest());
                satisfied = true;
            }
        }

        System.out.println("Suma totala de plata: " + client.getTotalSum());
        client.setMonthlyPay();
        System.out.println("Rata lunara: " + client.getMonthlyPay());

        System.out.println("DAE: " + client.getDAE());
        System.exit(0);
    }
}
