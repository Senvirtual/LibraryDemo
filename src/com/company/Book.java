package com.company;

public class Book {
    private String Id;

    private String Isbn;

    private String Title;

    private Member LoanTo;

    public Book(){}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Member getLoanTo() {
        return LoanTo;
    }

    public void setLoanTo(Member loanTo) {
        LoanTo = loanTo;
    }
}
