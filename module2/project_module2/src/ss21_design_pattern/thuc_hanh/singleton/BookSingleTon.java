package ss21_design_pattern.thuc_hanh.singleton;

public class BookSingleTon {
    private String author;
    private String title;
    private static BookSingleTon book;
    private static boolean isLoanedOut;

    private BookSingleTon(){
        author = "Gamma, Helm, Johnson, and Vlissides";
        title = "Design patterns";
        book = null;
        isLoanedOut = false;
    }

    public static BookSingleTon borrowBook(){
        if(!isLoanedOut){
            if(book == null){
                book = new BookSingleTon();
            }
            isLoanedOut = true;
            return book;
        }
        return null;
    }

    public void returnBook(BookSingleTon bookReturned){
        isLoanedOut = false;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorAndTitle(){
        return getTitle() + " by " + getAuthor();
    }
}
