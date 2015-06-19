package partyup.com.myapplication.Objects;

/**
 * Created by juan.ocampo on 12/06/2015.
 */
public class ItemDetails {
    private String mTitle;
    private String Flags;

    public String getFlags() {
        return Flags;
    }

    public void setFlags(String flags) {
        Flags = flags;
    }

    public String getmData() {
        return mData;
    }

    public void setmData(String mData) {
        this.mData = mData;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    private String mData;
    private int mImgResource;

    public int getmImgResource() {
        return mImgResource;
    }

    public void setmImgResource(int mImgResource) {
        this.mImgResource = mImgResource;
    }
}
