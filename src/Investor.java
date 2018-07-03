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

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMail() {
        return mail;
    }

    public double getSum() {
        return sum;
    }

    public int getInterest() {
        return interest;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
