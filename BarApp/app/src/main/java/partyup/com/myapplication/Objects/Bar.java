package partyup.com.myapplication.Objects;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by user on 07/05/2015.
 */
public class Bar {


    private String id="";
    private String name ="";
    private String slug="";
    private String category="";
    private String description="";
    private String city="";
    private String province="";
    private String phones="";
    private String created="";
    private String updated="";
    private double price =0;
    private String WebSite="";
    private String MusicStyle="";
    private String PaymentsSystem;
    private String address ="";
    private String lng ="";
    private String lat ="";
    private String mVisist="";
    private String ex_image_url ="";
    private Bars_subObject bars_franchise= new Bars_subObject();
    private Bars_subObject bars_category= new Bars_subObject();
    private ArrayList<Bar_week_shedules> bars_week_schedules= new ArrayList<>();
    private String likes="";
    private String hits="";

    public Bars_subObject getBars_franchise() {
        return bars_franchise;
    }

    public void setBars_franchise(Bars_subObject bars_franchise) {
        this.bars_franchise = bars_franchise;
    }

    public Bars_subObject getBars_category() {
        return bars_category;
    }

    public void setBars_category(Bars_subObject bars_category) {
        this.bars_category = bars_category;
    }

    public ArrayList<Bar_week_shedules> getBars_week_schedules() {
        return bars_week_schedules;
    }

    public void setBars_week_schedules(ArrayList<Bar_week_shedules>  bars_week_schedules) {
        this.bars_week_schedules = bars_week_schedules;
    }

    public void setCordinates(String lat,String lon){
        this.lat=lat;
        this.lng=lon;
    }

    public LatLng getCordinates(){
        return new LatLng(Double.valueOf(lat),Double.valueOf(lng));
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }

    public String getMusicStyle() {
        return MusicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        MusicStyle = musicStyle;
    }

    public String getPaymentsSystem() {
        return PaymentsSystem;
    }

    public void setPaymentsSystem(String paymentsSystem) {
        PaymentsSystem = paymentsSystem;
    }

    private String color =ColorsTheme.CYAN.name();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getImage_url() {
        return ex_image_url;
    }

    public void setImage_url(String image_url) {
        this.ex_image_url = image_url;
    }

    public String getmImaginePath() {
        return ex_image_url;
    }

    public void setmImaginePath(String mImaginePath) {
        this.ex_image_url = mImaginePath;
    }


    public String getmAddress() {
        return address;
    }

    public void setmAddress(String mAddress) {
        this.address = mAddress;
    }

    public String getmLat() {
        return lat;
    }

    public void setmLat(String mLat) {
        this.lat = mLat;
    }

    public String getmLong() {
        return lng;
    }

    public void setmLong(String mLong) {
        this.lng = mLong;
    }

    public String getmName() {
        return name;
    }

    public void setmName(String mName) {
        this.name = mName;
    }

    public String  getPrice() {
        return String.format("$ %,.02f",price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getmVisist() {
        return mVisist;
    }

    public void setmVisist(String mVisist) {
        this.mVisist = mVisist;
    }
}
