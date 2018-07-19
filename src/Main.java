<<<<<<< HEAD
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
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.*;
import java.util.stream.Stream;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/INV?verifyServerCertificate=false&useSSL=true";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "septembrie96.";

    public static ArrayList<Investor> investors;

    private static void addInvestor(String[] params) {
        investors.add(new Investor(params[0], params[1],
                params[2], Double.parseDouble(params[4]),
                Integer.parseInt(params[5]), params[3]));
    }

    public static void main(String[] args) {
        investors = new ArrayList<>();

        String fileName = "src\\investors";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.map(line -> line.split(", "))
                    .forEach(Main::addInvestor);

        } catch (IOException e) {
            e.printStackTrace();
        }
        investors.stream().forEach(System.out::println);


        Connection conn = null;
        Statement stmt = null;
        try{

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");

            String entry;
//            PreparedStatement statement;
//            entry = "INSERT INTO Investors (firstName, secondName, email, phoneNumber, amount, interest) " +
//                        "VALUES (?, ?, ?, ?, ?, ?);";
//            statement = conn.prepareStatement(entry);
//            statement.setString(1, investors.get(0).getFirstName());
//            statement.setString(2, investors.get(0).getSecondName());
//            statement.setString(3, investors.get(0).getMail());
//            statement.setString(4, investors.get(0).getPhoneNumber());
//            statement.setDouble(5, investors.get(0).getSum());
//            statement.setInt(6, investors.get(0).getInterest());
//
//            statement.executeUpdate();

//            stmt = conn.createStatement();
//            entry = "DELETE FROM Investors " +
//                    "WHERE id = 8";
//            stmt.executeUpdate(entry);

            stmt = conn.createStatement();

            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        Client client = new Client();
        client = client.checkData(investors);
>>>>>>> branch

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
<<<<<<< HEAD
}
=======
}
>>>>>>> branch
