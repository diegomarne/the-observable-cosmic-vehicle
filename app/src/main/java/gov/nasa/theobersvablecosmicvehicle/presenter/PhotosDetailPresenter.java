package gov.nasa.theobersvablecosmicvehicle.presenter;

import gov.nasa.theobersvablecosmicvehicle.model.Photo;
import gov.nasa.theobersvablecosmicvehicle.view.contracts.PhotosDetailsContract;

public class PhotosDetailPresenter {

    PhotosDetailsContract photosDetailsContract;
    Photo photo;

    public PhotosDetailPresenter(PhotosDetailsContract photosListContract, Photo photo) {
        this.photosDetailsContract = photosListContract;
        this.photo = photo;
    }


    public void init() {
        loadData();
    }

    private void loadData() {
        photosDetailsContract.setImage(photo.getImgUri());
        photosDetailsContract.setRoverName(photo.getRover().getName());
        photosDetailsContract.setCameraName(photo.getCamera().getName());
        photosDetailsContract.setCameraFullName(photo.getCamera().getFullName());
    }
}
