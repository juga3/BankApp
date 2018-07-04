import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Investor {
    private String firstName;
    private String secondName;
    private String mail;
    private double sum;
    private int interest;
    private String phoneNumber;

    public Investor() {}

    public Investor(String firstName, String secondName, String mail, double sum, int interest, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
        this.sum = sum;
        this.interest = interest;
        this. phoneNumber = phoneNumber;
    }

    public double getSum() {
        return sum;
    }

    public int getInterest() {
        return interest;
    }

    @Override
    public String toString() {
        return "Investor{ " +
                "First Name='" + firstName + '\'' +
                ", Second Name='" + secondName + '\'' +
                ", Email='" + mail + '\'' +
                ", Sum=" + sum +
                ", Interest=" + interest +
                ", PhoneNumber='" + phoneNumber + '\'' +
                "}\n";
    }

    public ArrayList<Investor> readInvestors() {
        ArrayList<Investor> investors = new ArrayList<Investor>();
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
        return investors;
    }
}
