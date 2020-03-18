package com.emilio.tvseriesquiz.interactor.entities;

import androidx.annotation.NonNull;

import com.emilio.tvseriesquiz.model.pojo.entity.ADSerie;
import com.emilio.tvseriesquiz.model.pojo.entityDAO.ADSerieDAO;
import com.emilio.tvseriesquiz.model.realm.schema.ADSerieSchema;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmQuery;

public class GetAllSeriesInteractor extends GetEntitiesInteractor<ADSerie, ADSerieDAO>{

    public GetAllSeriesInteractor() {
        super(ADSerie.class, ADSerieDAO.class);
    }

    @Override
    public String getOrder() {
        return ADSerieSchema.code;
    }

    @Override
    public RealmQuery<RealmModel> buildQuery() {
        RealmQuery<RealmModel> query;
        Realm realm = Realm.getDefaultInstance();

        final Class type = ADSerieDAO.class;

        query = realm.where(type);
        query.sort(ADSerieSchema.code);

        return query;
    }

    @Override
    public List<ADSerie> processResult(@NonNull List<ADSerie> entities) {
        return entities;
    }
}
