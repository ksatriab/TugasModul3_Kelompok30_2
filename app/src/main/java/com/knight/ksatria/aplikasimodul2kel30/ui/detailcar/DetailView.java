package com.knight.ksatria.aplikasimodul2kel30.ui.detailcar;

import com.knight.ksatria.aplikasimodul2kel30.data.model.DataCar;

import java.util.List;

public interface DetailView {
    void showErrorCarById(String message);

    void showSuccessCarById(List<DataCar> dataCar);
}