package gov.nasa.theobersvablecosmicvehicle.model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("id")
    private int id;

    @SerializedName("sol")
    private int sol;

    @SerializedName("camera")
    private Camera camera;

    @SerializedName("img_src")
    private String imgUri;

    @SerializedName("earth_date")
    private String earthDate;

    @SerializedName("rover")
    private Rover rover;

    public String getImgUri() {
        return imgUri;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public Camera getCamera() {
        return camera;
    }

    public Rover getRover() {
        return rover;
    }
}
