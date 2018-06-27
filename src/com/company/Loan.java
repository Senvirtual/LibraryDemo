package com.company;

import org.junit.Test;

import java.time.LocalDate;

public class Loan {

    private String Id;

    private LocalDate LoanDate;

    private LocalDate DateForReturn;

    private Book book;

    private Member member;

    public Loan(){}


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDate getLoanDate() {
        return LoanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        LoanDate = loanDate;
    }

    public LocalDate getDateForReturn() {
        return DateForReturn;
    }

    public void setDateForReturn(LocalDate dateForReturn) {
        DateForReturn = dateForReturn;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


//尚未归还
    public boolean HasNotBeenReturned(){
        if (this.getBook().getLoanTo()!= null){
            return true;
        }else {
            return false;
        }

    }

//归还标记
    public void MarkAsReturned(){
        this.getBook().setLoanTo(null);

    }


}
