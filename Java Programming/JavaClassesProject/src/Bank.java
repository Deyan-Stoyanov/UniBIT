import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        while(true){
            String command = scanner.nextLine();
            if(command.equals("End")){
                break;
            }
            String[] toDo = command.split("\\s+");
            int id = Integer.parseInt(toDo[1]);
            switch (toDo[0]){
                case "Create":
                    boolean idExists = false;
                    for (BankAccount ba:accounts) {
                        if(ba.id.equals(id)){
                            System.out.println("Account already exists.");
                            idExists = true;
                        }
                    }
                    if(!idExists){
                        BankAccount bankAccount = new BankAccount();
                        bankAccount.id = id;
                        bankAccount.balance = 0.0;
                        accounts.add(bankAccount);
                    }
                    break;
                case "Deposit":
                    int depositNum = Integer.parseInt(toDo[2]);
                    boolean depositExists = false;
                    for (BankAccount ba:accounts) {
                        if(ba.id.equals(id)){
                            ba.deposit(depositNum);
                            depositExists = true;
                        }
                    }
                    if(!depositExists){
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Withdraw":
                    int withdrawNum = Integer.parseInt(toDo[2]);
                    boolean withdrawExists = false;
                    for (BankAccount ba:accounts) {
                        if(ba.id.equals(id)){
                            ba.withdraw(withdrawNum);
                            withdrawExists = true;
                        }
                    }
                    if(!withdrawExists){
                        System.out.println("Account does not exist");
                    }
                case "Print":
                    boolean printExists = false;
                    for (BankAccount ba:accounts) {
                        if(ba.id.equals(id)){
                            System.out.printf("Account ID%d, balance %.2f", ba.id, ba.balance);
                            printExists = true;
                        }
                    }
                    if(!printExists){
                        System.out.println("Account does not exist");
                    }
            }
        }
        Collections.sort(accounts, (firstAccount, secondAccount) ->{
            int sComp = firstAccount.getId().compareTo(secondAccount.getId());
            if(sComp != 0){
                return sComp;
            }else {
                return Double.compare(firstAccount.getBalance(), secondAccount.getBalance());
            }
        });
        for (BankAccount ba:accounts) {
            System.out.println(ba.toString());
        }
    }
}
