package gov.nasa.theobersvablecosmicvehicle.network;

import gov.nasa.theobersvablecosmicvehicle.model.MarsRover;
import gov.nasa.theobersvablecosmicvehicle.model.wsresponse.PhotosResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarsRoverService {

    String BASE_URL = "mars-photos/api/v1/rovers/";

    @GET(BASE_URL + "{roverName}/photos")
    Single<PhotosResponse> getPhotos(@Path("roverName") @MarsRover.RoverName String roverName, @Query("earth_date") String date, @Query("page") int pageNum);
}
