package gov.nasa.theobersvablecosmicvehicle.model.wsresponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import gov.nasa.theobersvablecosmicvehicle.model.Photo;

public class PhotosResponse {
    @SerializedName("photos")
    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }
}
