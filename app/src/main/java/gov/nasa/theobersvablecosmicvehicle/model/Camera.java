package gov.nasa.theobersvablecosmicvehicle.model;

import com.google.gson.annotations.SerializedName;

public class Camera {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("rover_id")
    private int roverId;

    @SerializedName("full_name")
    private String fullName;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoverId() {
        return roverId;
    }

    public String getFullName() {
        return fullName;
    }
}
