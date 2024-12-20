import java.util.LinkedList;

public class Library {
    // 使用 LinkedList 儲存書籍和會員
    private LinkedList<Book> books;
    private LinkedList<Member> members;

    // 建構函數，初始化書籍和會員清單
    public Library() {
        this.books = new LinkedList<>();
        this.members = new LinkedList<>();
    }

    // 新增書籍方法
    public void addBook(Book book) {
        books.add(book);
        System.out.println("新增書籍: " + book.getTitle());
    }

    // 新增會員方法
    public void addMember(Member member) {
        members.add(member);
        System.out.println("新增會員: " + member.getName());
    }

    // 列出所有書籍
    public void listBooks() {
        System.out.println("圖書館現有書籍:");
        if (books.isEmpty()) {
            System.out.println("無書籍。");
        } else {
            for (Book book : books) {
                System.out.println("  - " + book.getTitle() + " 狀態: " + (book.isBorrowed() ? "已借出" : "可借閱"));
            }
        }
    }

    // 根據會員名稱取得會員
    public Member getMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }
}
