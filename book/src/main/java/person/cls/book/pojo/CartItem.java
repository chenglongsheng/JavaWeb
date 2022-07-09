package person.cls.book.pojo;

/**
 * @description: 购物车详情表
 * @author: CLS
 * @date: 2022-07-09-13:42
 * @version: 1.0
 */
public class CartItem {

    private Integer id;
    private Book book;
    private Integer buyCount;
    private User userBean;

    public CartItem() {
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

}
