package com.company;

public class LoanOnlyOneSpecification implements ISpecification<Member> {


    private Book WantBook;

    private boolean Switch = true;


    @Override
    public boolean IsSatisfied(Member member) {
        member.FindCurrentLongFor().forEach(loan->{
            if (loan.getBook().getIsbn().equals(this.WantBook.getIsbn())){
                System.out.println("您已经借过"+this.WantBook.getTitle()+"这本书了，不需要再执行操作");
                this.Switch =false;
            }
        });
        return  this.Switch;
    }

    public void LoanOnlyOneBook(Book book){
        this.WantBook = book;
    }


}
