package com.knight.ksatria.aplikasimodul2kel30.ui.home;

import com.knight.ksatria.aplikasimodul2kel30.data.model.DataCar;

import java.util.List;

/**
 * Created by USER on 10/25/2018.
 */

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);

}
