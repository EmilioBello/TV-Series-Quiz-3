package com.emilio.tvseriesquiz.viewmodel;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface InterfaceViewModel<Pojo> {
    LiveData<List<Pojo>> init();
}
