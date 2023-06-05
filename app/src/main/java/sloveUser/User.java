package sloveUser;

public class User {
    private int img;
    private String name;
    private String infor;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public User(int img, String name, String infor) {
        this.img = img;
        this.name = name;
        this.infor = infor;
    }
}
