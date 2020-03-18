package com.emilio.tvseriesquiz.interactor.entities;


import androidx.annotation.NonNull;

import com.emilio.tvseriesquiz.model.realm.repository.RealmRepository;

import java.util.List;

public abstract class GetEntitiesInteractor<In, Out> implements GetEntitiesInterface<In>{

    private final Class<In> typeIn;
    private final Class<Out> typeOut;

    public GetEntitiesInteractor(@NonNull final Class<In> typeIn,@NonNull final Class<Out> typeOut) {
        this.typeIn = typeIn;
        this.typeOut = typeOut;
    }

    public List<In> init() {
        final RealmRepository<In, Out> repository = new RealmRepository<>(typeIn, typeOut);
        final List<In> entities = repository.fetchAll(buildQuery());
        return processResult(entities);
    }
}
