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

}
