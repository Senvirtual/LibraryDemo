package com.company;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String Id;

    private String Name;

    private ArrayList<Loan> Loans = new ArrayList<Loan>();

    public Member(){}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean canLoan(Book book){
        if (book.getLoanTo()==null){
            System.out.println(book.getTitle()+"这本书可以借");
            return true;
        }else {
            System.out.println(book.getTitle()+"这本书不可以借");
            return false;
        }
    }


    public void loan(Book book){
        Loan loan = null;
        if (this.canLoan(book)!=false){
            loan = LoanFactory.LoanFactoryBuilder.CreateLoan(book,this);
            this.Loans.add(loan);
            book.setLoanTo(this);
            System.out.println("借书成功");
        }else {System.out.println("借书失败");}
    }

    public ArrayList<Loan> FindCurrentLongFor(){
        return this.Loans;
    }

    public void Return(Book book){

        this.Loans.forEach(loan -> {
            if (loan.getBook().getIsbn().equals(book.getIsbn())){
                loan.MarkAsReturned();
                this.Loans.remove(loan);
                System.out.println("还书成功");
            }
        });
    }


}
