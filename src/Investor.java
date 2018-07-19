public class Investor {
    private String firstName;
    private String secondName;
    private String mail;
    private double sum;
    private int interest;
    private String phoneNumber;

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

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
}
