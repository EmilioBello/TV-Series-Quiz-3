package com.emilio.tvseriesquiz.interactor.entities;

import java.util.List;

import io.realm.RealmModel;
import io.realm.RealmQuery;

public interface GetEntitiesInterface<In> {
    String getOrder();
    RealmQuery<RealmModel> buildQuery();
    List<In> processResult(List<In> entities);
}
