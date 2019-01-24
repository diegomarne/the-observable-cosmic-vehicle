package gov.nasa.theobersvablecosmicvehicle.view.contracts;

import java.util.List;

import gov.nasa.theobersvablecosmicvehicle.model.Photo;

public interface PhotosListContract {
    void showLoading();
    void hideLoading();
    void showToast(String text);
    void updateList(List<Photo> photosList);
    List<Photo> getList();
    void onClickRow(int position);
}
