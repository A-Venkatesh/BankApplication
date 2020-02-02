package in.venkateshalive.bankapplication;

/**
 * Created by ANBU on 3/19/2016.
 */
public class Contacts {
    public Contacts(int image_id,String name,String mobile){
        this.setImage_id(image_id);
        this.setMobile(mobile);
        this.setName(name);



    }
    private int image_id;
    private String name,mobile;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
