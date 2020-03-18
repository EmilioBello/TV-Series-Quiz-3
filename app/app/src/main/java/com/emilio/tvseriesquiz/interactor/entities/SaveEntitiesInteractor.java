package com.emilio.tvseriesquiz.interactor.entities;

import androidx.annotation.NonNull;

import com.emilio.tvseriesquiz.model.realm.repository.RealmRepository;

import java.util.List;

public class SaveEntitiesInteractor<Pojo, DAO>{
    private final Class<Pojo> typePojo;
    private final Class<DAO> typeDAO;

    public SaveEntitiesInteractor(@NonNull final Class<Pojo> typePojo, @NonNull final Class<DAO> typeDAO) {
        this.typePojo = typePojo;
        this.typeDAO = typeDAO;
    }

    public void init(@NonNull final List<Pojo>  list) {
        RealmRepository<Pojo, DAO> repository = new RealmRepository<>(typePojo, typeDAO);
        repository.save(list);
    }
}
