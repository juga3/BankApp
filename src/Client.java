public class Client {
    private String firstName;
    private String secondName;
    private String mail;
    private double sum;
    private String phoneNumber;
    private int loanTime;
    private double totalSum = 0;
    private double monthlyPay;

    public int getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(int loanTime) {
        this.loanTime = loanTime;
    }

    public Client(String firstName, String secondName, String mail, double sum, String phoneNumber, int loanTime) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
        this.sum = sum;
        this.phoneNumber = phoneNumber;
        this.loanTime = loanTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

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

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
