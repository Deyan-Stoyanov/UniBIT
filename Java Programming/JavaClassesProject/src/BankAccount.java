public class BankAccount {
    @Override
    public String toString() {
        return super.toString();
    }

    public Integer id;
    public Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(double ammount){
        if(ammount < 0){
            withdraw(ammount);
        }else{
            this.balance += ammount;
        }
    }

    public void withdraw(double ammount){
        if(ammount > balance){
            System.out.println("Insufficient balance!");
        }else{
            this.balance -= ammount;
        }
    }

}
