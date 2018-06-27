package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public  class LoanFactory {

    public static class LoanFactoryBuilder{
        public static Loan CreateLoan(Book book ,Member member){
            Loan loan = new Loan();
            loan.setBook(book);
            loan.setMember(member);
            loan.setLoanDate(LocalDate.now());
            loan.setDateForReturn(loan.getLoanDate().plusDays(10));
            return loan;
        }
    }


}
