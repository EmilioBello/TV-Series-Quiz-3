package com.emilio.tvseriesquiz.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emilio.tvseriesquiz.interactor.entities.GetAllSeriesInteractor;
import com.emilio.tvseriesquiz.interactor.entities.SaveEntitiesInteractor;
import com.emilio.tvseriesquiz.model.pojo.entity.ADSerie;
import com.emilio.tvseriesquiz.model.pojo.entityDAO.ADSerieDAO;

import java.util.ArrayList;
import java.util.List;

public class SeriesViewModel extends ViewModel implements InterfaceViewModel<ADSerie> {

    private MutableLiveData<List<ADSerie>> series;

    public LiveData<List<ADSerie>> init() {
        if (series == null) {
            series = new MutableLiveData<>();
        }

        saveSeries();
        loadSeries();

        return series;
    }

    private void saveSeries(){
        List<ADSerie> list =  createItems();

        SaveEntitiesInteractor<ADSerie, ADSerieDAO> interactor = new SaveEntitiesInteractor<>(ADSerie.class, ADSerieDAO.class);
        interactor.init(list);
    }
    private void loadSeries() {
        GetAllSeriesInteractor interactor = new GetAllSeriesInteractor();
        final List<ADSerie> list = interactor.init();

        series.setValue(list);
    }

    private List<ADSerie> createItems(){
        List<ADSerie> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ADSerie item = new ADSerie();
            item.setCode(i);
            item.setName(""+i);
            item.setUrlAvatar("https://vignette.wikia.nocookie.net/gameofthrones/images/1/15/Game-of-thrones-final-season-poster.jpg/revision/latest?cb=20180227185541");
            list.add(item);
        }

        return list;
    }

    public void clickOnRowElement(ADSerie serie){
        List<ADSerie> list = series.getValue();
        list.remove(serie);
        series.setValue(list);
    }
}
