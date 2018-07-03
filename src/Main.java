import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
        System.out.println("Enter investors number: ");
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

        System.out.println("New client: ");
        System.out.print("First name: ");
        String firstName = input.next();
        System.out.print("Second name: ");
        String secondName = input.next();
        System.out.print("Email: ");
        String mail = input.next();
        System.out.print("Phone number: ");
        String phoneNumber = input.next();
        System.out.print("Wanted sum: ");
        double sum = input.nextDouble();
        System.out.print("Loan time in months: ");
        int loanTime = input.nextInt();

        Client client = new Client(firstName, secondName, mail, sum, phoneNumber, loanTime);

        System.out.println("Suma totala de plata: ");
        Collections.sort(investors, new Sortbyinterest());
//        for(int i = 0; i < investors.size(); i++) {
//            System.out.println(investors.get(i));
//      }
        double wanted = client.getSum();
        boolean satisfied = false;
/*        if(client.getSum() <= investors.get(0).getSum()) {
            client.setTotalSum(investors.get(0).getSum(), investors.get(0).getInterest());
            System.out.println(client.getTotalSum());
        }
*/
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

        System.out.println(client.getTotalSum());
        client.setMonthlyPay();
        System.out.println("Rata lunara: " + client.getMonthlyPay());
        System.exit(0);
    }
}
