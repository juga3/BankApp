<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Scanner;

>>>>>>> branch
public class Client {
    private String firstName;
    private String secondName;
    private String mail;
    private double sum;
    private String phoneNumber;
    private int loanTime;
    private double totalSum = 0;
    private double monthlyPay;
    private double DAE;


    public Client(String firstName, String secondName, String mail, double sum, String phoneNumber, int loanTime) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
        this.sum = sum;
        this.phoneNumber = phoneNumber;
        this.loanTime = loanTime;
    }

<<<<<<< HEAD
=======
    public Client() {}

>>>>>>> branch
    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", mail='" + mail + '\'' +
                ", sum=" + sum +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loanTime=" + loanTime +
                ", totalSum=" + totalSum +
                "}\n";
    }

    public void setTotalSum(double taken, int interest) {
        double total = taken;
        total += ((taken * interest / 100) / 12 * loanTime);
        this.totalSum += total;
    }

    public void setMonthlyPay() {
        monthlyPay =  totalSum / loanTime;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public double getDAE() {
        this.DAE = (totalSum - sum) * 12 / (sum * loanTime) * 100;
        return DAE;
    }

<<<<<<< HEAD
=======
    public Client checkData(ArrayList<Investor> investors) {
        Scanner input = new Scanner(System.in);

        boolean valid;
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

        return new Client(firstName, secondName, mail, sum, phoneNumber, loanTime);
    }
>>>>>>> branch
}
