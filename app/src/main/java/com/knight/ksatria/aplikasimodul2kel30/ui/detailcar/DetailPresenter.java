package com.knight.ksatria.aplikasimodul2kel30.ui.detailcar;

        import android.util.Log;
        import com.google.gson.Gson;
        import com.google.gson.JsonArray;
        import com.google.gson.JsonObject;
        import com.google.gson.reflect.TypeToken;
        import com.knight.ksatria.aplikasimodul2kel30.data.model.DataCar;
        import com.knight.ksatria.aplikasimodul2kel30.data.network.RetrofitClient;

        import java.lang.reflect.Type;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class DetailPresenter {
    private final DetailView mView ;
    public  DetailPresenter(DetailView detailView){ mView =detailView;}

    public void getCarById(DataCar dataCar) {
        RetrofitClient.getInstance()
                .getApi()
                .GetCarById(dataCar.getId())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject body = response.body();
                            JsonArray array = body.get("result").getAsJsonArray();
                            Type type =new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCar = new Gson().fromJson(array, type);
                            mView.showSuccessCarById(dataCar);
                        } else {
                            mView.showErrorCarById("ERROR Ya BOSS !!");
                        }
                    }
                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("DATA", t.getMessage());
                        mView.showErrorCarById(t.getMessage());
                    }
                });
    }
}