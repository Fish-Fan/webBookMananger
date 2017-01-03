package entity;

/**
 * Created by yanfeng-mac on 2017/1/2.
 */
public class BookType {
    private Integer id;
    private String book_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", book_type='" + book_type + '\'' +
                '}';
    }
}
