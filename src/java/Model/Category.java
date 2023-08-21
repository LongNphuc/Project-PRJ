
package Model;

public class Category {
    private int cateid;
    private String cateName;

    public Category() {
    }

    public Category(int cateid, String cateName) {
        this.cateid = cateid;
        this.cateName = cateName;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    public String convertCate(int key, String cate) {
        switch (key) {
            case 1:
                return "Narration";
            case 2:
                return "Funny";
            case 3:
                return "Cartoon";
            case 4:
                return "Action";
            case 5:
                return "Adventure";
            case 6:
                return "Fiction";
            case 7:
                return "KungFu";
            case 8:
                return "Tv Show";
            case 9:
                return "Drama";
            case 10:
                return "old film";
        }
        return cate;
    }
    
    
}
