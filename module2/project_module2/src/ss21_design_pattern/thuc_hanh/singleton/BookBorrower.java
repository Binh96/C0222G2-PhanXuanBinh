package ss21_design_pattern.thuc_hanh.singleton;

public class BookBorrower {
    private BookSingleTon borrowedBook;
    private boolean haveBook = false;

    public void borrowBook(){
        borrowedBook = BookSingleTon.borrowBook();
        if(borrowedBook == null){
            haveBook = false;
        }
        else{
            haveBook = true;
        }
    }

    public String getAuthorAndTitle(){
        if(haveBook){
            return borrowedBook.getAuthorAndTitle();
        }
        return "I don't have the book";
    }

    public void returnBook(){
        borrowedBook.returnBook(borrowedBook);
    }
}
