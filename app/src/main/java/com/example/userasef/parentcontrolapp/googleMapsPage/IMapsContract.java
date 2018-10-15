package com.example.userasef.parentcontrolapp.googleMapsPage;

import com.example.userasef.parentcontrolapp.IBasePresenter;
import com.example.userasef.parentcontrolapp.IBaseView;
import com.example.userasef.parentcontrolapp.data.response.MyLatLng;

import java.util.ArrayList;

public interface IMapsContract {
    interface View extends IBaseView{
        void showUserLocations(ArrayList<MyLatLng> list);
    }

    interface Presenter extends IBasePresenter{
        void getUserLocationsForToday(String id);
    }
}