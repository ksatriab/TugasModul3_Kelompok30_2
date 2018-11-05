package com.knight.ksatria.aplikasimodul2kel30.ui.detailcar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.knight.ksatria.aplikasimodul2kel30.R;
import com.knight.ksatria.aplikasimodul2kel30.data.model.DataCar;
import com.knight.ksatria.aplikasimodul2kel30.utility.Constant;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private DataCar dataCar;
    private DetailPresenter detailPresenter;
    private TextView tvNama;
    private TextView tvMerk;
    private TextView tvModel;
    private TextView tvTahun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initIntentData();
        initPresenter();
        initData();
    }

    private void initView() {
        tvNama = findViewById(R.id.tvTampil_nama);
        tvMerk = findViewById(R.id.tvTampil_Merek);
        tvModel = findViewById(R.id.tvTampil_Model);
        tvTahun = findViewById(R.id.tvTampil_Taun);
    }

    private void initData() {
        detailPresenter.getCarById(dataCar);
    }

    private void initPresenter() {
        detailPresenter = new DetailPresenter(this);
    }

    private void initIntentData() {
        dataCar = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (dataCar == null) finish();
    }

    @Override
    public void showErrorCarById(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessCarById(List<DataCar> car) {
        tvNama.setText(car.get(0).getName());
        tvMerk.setText(car.get(0).getMerk());
        tvModel.setText(car.get(0).getModel());
        tvTahun.setText(car.get(0).getYear());
    }
}
