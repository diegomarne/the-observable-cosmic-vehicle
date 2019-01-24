package gov.nasa.theobersvablecosmicvehicle.view.contracts;

import io.reactivex.annotations.NonNull;

public interface PhotosDetailsContract {
    void setImage(@NonNull String uri);
    void setRoverName(@NonNull String roverName);
    void setCameraName(@NonNull String cameraName);
    void setCameraFullName(@NonNull String cameraFullName);
}
