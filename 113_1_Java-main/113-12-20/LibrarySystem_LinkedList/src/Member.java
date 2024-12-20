import java.util.LinkedList;

public class Member extends Person {
    // 使用 LinkedList 儲存借閱的書籍
    private LinkedList<Book> borrowedBooks;

    // 建構函數，初始化成員名稱與借閱書籍清單
    public Member(String name) {
        super(name);
        this.borrowedBooks = new LinkedList<>();
    }

    // 借書方法
    public void borrowBook(Book book) {
        if (!book.isBorrowed()) { // 檢查書是否已被借出
            book.borrow(); // 標記書為已借出
            borrowedBooks.add(book); // 將書加入借閱清單
            System.out.println(getName() + " 成功借閱 " + book.getTitle() + "。");
        } else {
            System.out.println(getName() + " 無法借閱 " + book.getTitle() + "，因為已被借走。");
        }
    }

    // 還書方法
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) { // 檢查是否在借閱清單中
            book.returnItem(); // 標記書為已歸還
            borrowedBooks.remove(book); // 從借閱清單中移除書
            System.out.println(getName() + " 成功歸還 " + book.getTitle() + "。");
        } else {
            System.out.println(getName() + " 無法歸還 " + book.getTitle() + "，因為未借閱。");
        }
    }

    // 列出目前借閱的書籍
    public void listBorrowedBooks() {
        System.out.println(getName() + " 借閱的書籍清單:");
        if (borrowedBooks.isEmpty()) { // 檢查清單是否為空
            System.out.println("無借閱書籍。");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle());
            }
        }
    }
}
