package com.knight.ksatria.aplikasimodul2kel30.ui.addcar;


public interface AddView {

    String getName();

    String getMerk();

    String getModel();

    String getYear();

    void successAddCar();

    void failedAddCar();
}