package gov.nasa.theobersvablecosmicvehicle.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rover {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("landing_date")
    private String landingDate;

    @SerializedName("launch_date")
    private String launchDate;

    @SerializedName("status")
    private String status;

    @SerializedName("max_sol")
    private int maxSol;

    @SerializedName("max_date")
    private String maxDate;

    @SerializedName("total_photos")
    private int totalPhotos;

    @Expose
    private List<Object> cameras;

    public String getName() {
        return name;
    }
}
