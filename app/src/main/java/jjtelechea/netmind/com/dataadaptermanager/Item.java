package jjtelechea.netmind.com.dataadaptermanager;


public class Item {

    private String mTitle;
    private String mBody;
    private String mImage;


    public Item(String mTitle, String mBody, String mImage) {
        this.mTitle = mTitle;
        this.mBody = mBody;
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmImage() {
        return mImage;
    }

    public String getmBody() {
        return mBody;
    }
}
