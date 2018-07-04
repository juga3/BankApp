import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Sortbyinterest implements Comparator<Investor>
{
    public int compare(Investor a, Investor b)
    {
        return a.getInterest() - b.getInterest();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Investor> investors = new ArrayList<Investor>();

/*        System.out.println("Enter investors number: ");
        int number = input.nextInt();

        for(int i = 0; i < number; i++) {
            System.out.println("Enter investor credentials: ");
            System.out.print("First name: ");
            String firstName = input.next();
            System.out.print("Second name: ");
            String secondName = input.next();
            System.out.print("Email: ");
            String mail = input.next();
            System.out.print("Phone number: ");
            String phoneNumber = input.next();
            System.out.print("Invested sum: ");
            double sum = input.nextDouble();
            System.out.print("Interest: ");
            int interest = input.nextInt();

            Investor inv = new Investor(firstName, secondName, mail, sum, interest, phoneNumber);
            investors.add(inv);
        }
*/
        File file = new File("src\\investors");
        try {

            Scanner sc = new Scanner(file);
            sc.useDelimiter(" ");
            int number = Integer.parseInt(sc.next());
            for(int i = 0; i < number; i++) {
                String firstName = sc.next();
                System.out.println(firstName);
                String secondName = sc.next();
                System.out.println(secondName);
                String mail = sc.next();
                System.out.println(mail);
                String phoneNumber = sc.next();
                System.out.println(phoneNumber);
                double sum = Double.parseDouble(sc.next());
                System.out.println(sum);
                int interest = Integer.parseInt(sc.next());
                System.out.println(interest);

                Investor inv = new Investor(firstName, secondName, mail, sum, interest, phoneNumber);
                investors.add(inv);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean valid;
        String firstName, secondName, mail, phoneNumber;
        double sum;
        int loanTime;
        System.out.println("New client: ");

        do {
            valid = true;
            System.out.print("Insert first name: ");
            firstName = input.next();
            for(int i = 0; i < firstName.length() && valid; i++) {
                char character = firstName.charAt(i);
                if (!Character.isLetter(character)) {
                    valid = false;
                    System.out.println("Invalid first name!");
                }
            }
        }
        while(!valid);
        do {
            valid = true;
            System.out.print("Insert second name: ");
            secondName = input.next();
            for(int i = 0; i < secondName.length() && valid; i++) {
                char character = secondName.charAt(i);
                if (!Character.isLetter(character)) {
                    valid = false;
                    System.out.println("Invalid second name!");
                }
            }
        }
        while(!valid);

        do {
            valid = true;
            System.out.print("Insert email: ");
            mail = input.next();
            int count = 0;
            if (mail.charAt(0) == '@')
                valid = false;
            for (int i = 0; i < mail.length(); i++)
                 if (mail.charAt(i) == '@')
                     count++;
            if (count != 1)
                valid = false;
            if (!(mail.endsWith(".com") || mail.endsWith(".ro") || mail.endsWith(".gov") || mail.endsWith(".net")))
                valid = false;
            if(!valid)
                System.out.println("Invalid email address!");
        }
        while(!valid);

        do {
            valid = true;
            System.out.print("Insert phone number: ");
            phoneNumber = input.next();
            if (!phoneNumber.startsWith("07") || phoneNumber.length() != 10)
                valid = false;
            for(int i = 0; i < phoneNumber.length() && valid; i++) {
                char character = phoneNumber.charAt(i);
                if (!Character.isDigit(character)) {
                    valid = false;
                }
            }
            if(!valid)
                System.out.println("Invalid phone number!");
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

        Collections.sort(investors, new Sortbyinterest());

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
