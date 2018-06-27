package test;

import com.company.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoanFactoryTest{

    @org.junit.Test
    public void createLoan() {
        Member member = new Member();
        Book book = new Book();
        book.setTitle("One Day");
        Loan loan = LoanFactory.LoanFactoryBuilder.CreateLoan(book,member);
        System.out.println(loan.getBook().getTitle());
        System.out.println("借阅者");
        System.out.println(loan.getBook().getLoanTo());
        System.out.println("借阅时间");
        System.out.println(loan.getLoanDate());
        System.out.println("归还时间");
        System.out.println(loan.getDateForReturn());
    }
    @Test
    public void MarkAsReturned(){
        Member member = new Member();
        Book book = new Book();
        book.setTitle("One Day");
        Loan loan = LoanFactory.LoanFactoryBuilder.CreateLoan(book,member);
        loan.MarkAsReturned();
        System.out.println(loan.HasNotBeenReturned());
    }

    @Test

    public void ReturnBook(){
        Member member = new Member();
        member.setId("123");
        member.setName("Sam");
        Book book = new Book();
        book.setId("1");
        book.setIsbn("123456");
        book.setLoanTo(member);
        book.setTitle("One Day");
        Book book2 = new Book();
        book2.setId("1");
        book2.setIsbn("123456");
        book2.setLoanTo(member);
        book2.setTitle("Same Day");
        Loan loan1 = LoanFactory.LoanFactoryBuilder.CreateLoan(book,member);
        Loan loan2 = LoanFactory.LoanFactoryBuilder.CreateLoan(book2,member);
        member.FindCurrentLongFor().add(loan1);
        member.FindCurrentLongFor().add(loan2);
        member.FindCurrentLongFor().forEach((loan)->{
            System.out.println(loan.getBook().getTitle());
        });

    }
@Test
    public void MainTest(){

//        用户创建
        Member Tom = new Member();
        Tom.setName("Tom");
        Tom.setId("0000010");

//        书籍创建
        Book book = new Book();
        book.setId("0");
        book.setIsbn("0000011");
        book.setTitle("One Day");

        Book book2 = new Book();
        book2.setId("1");
        book2.setIsbn("0000012");
        book2.setTitle("Same Day");
        ;
        Book book3 = new Book();
        book3.setId("1");
        book3.setIsbn("0000013");
        book3.setTitle("Today");

        Book book4 = new Book();
        book4.setId("1");
        book4.setIsbn("0000014");
        book4.setTitle("The Day");



//Tom 借书架的所有书
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        HasReachMaxSpecification hasReachMaxSpecification = new HasReachMaxSpecification();
        LoanOnlyOneSpecification loanOnlyOneSpecification =new LoanOnlyOneSpecification();
    for (Book theBook: bookList) {
//        if (Tom.canLoan(theBook)==true){
            loanOnlyOneSpecification.LoanOnlyOneBook(theBook);
            if (loanOnlyOneSpecification.IsSatisfied(Tom) == true & hasReachMaxSpecification.IsSatisfied(Tom) == true) {
                System.out.print(hasReachMaxSpecification.IsSatisfied(Tom));
                Tom.loan(theBook);
            }
//        }
    }
    Member Sammy = new Member();
    Sammy.setId("1222222");
    Sammy.setName("Sam");

    //        Sam再去接书
    for (Book theBook: bookList) {
//        if (Sammy.canLoan(theBook)==true){
            loanOnlyOneSpecification.LoanOnlyOneBook(theBook);
            if (loanOnlyOneSpecification.IsSatisfied(Sammy) == true & hasReachMaxSpecification.IsSatisfied(Sammy) == true) {
                Sammy.loan(theBook);
            }
//        }
    }
//    Tom还书
    Tom.Return(book);

}


}