package com.proxy.personaltain.test1;

//	BankAccount 클래스를 만든다.
//	•	필드: String owner, long balance
//	•	메서드:
//	•	deposit(long amount) : 0 이하 들어오면 예외
//	•	withdraw(long amount) : 잔고 부족하면 예외
//	•	커스텀 예외 2개 정의:
//	•	InvalidAmountException (입금/출금 금액이 0 이하일 때)
//	•	InsufficientBalanceException (잔고 부족할 때)
//	•	main 메서드에서:
//	•	계좌 생성 → 입금 → 출금 → 예외 나는 상황까지 한 번씩 호출
//
//포인트
//	•	class 설계, 생성자, getter 필요 여부 스스로 판단
//	•	예외를 extends RuntimeException으로 할지 Exception으로 할지 네 판단대로
public class mission1 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("yeonjoon", 1000);

        acc.deposit(1000);
        System.out.println("입금 후 잔고 체크"+ acc.getBalance());
        acc.withdraw(1000);
        System.out.println("출금 후 잔고 체크"+ acc.getBalance());

        try{
            acc.deposit(0);
        }catch (InvalidAmountException e){
            System.out.println("예외체크 "+ e.getMessage());
        }

        try {
            acc.withdraw(10000);
        }catch (InsufficientBalanceException e){
            System.out.println("예외체크 "+ e.getMessage());
        }

    }


}
class BankAccount{
    private final String owner;
    private long balance;

    public BankAccount(String owner, long balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(long amount){
        if(amount <= 0){
            throw new InvalidAmountException("입금 금액은 0보다 커야 합니다.");
        }
        balance += amount;
    }

    public void withdraw(long amount){
        if (amount <= 0) {
            throw new InvalidAmountException("출금 금액은 0보다 커야 합니다.");
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("잔고 부족: 요청=" + amount + ", 잔고=" + balance);
        }
        balance -= amount;
        balance -= amount;
    }

    public long getBalance(){
        return balance;
    }
    public String getOwner(){
        return owner;
    }
}

class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String message){
        super(message);
    }
}
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

