package com.emilio.tvseriesquiz.view.adapter;

import android.view.View;

import androidx.annotation.NonNull;

public interface CommonAdapterListener<ViewModel> {
    void getItem(@NonNull ViewModel viewModel, View view);
}
