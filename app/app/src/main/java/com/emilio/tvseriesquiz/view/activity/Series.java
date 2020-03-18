package com.emilio.tvseriesquiz.view.activity;

import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emilio.tvseriesquiz.BR;
import com.emilio.tvseriesquiz.MyApp;
import com.emilio.tvseriesquiz.R;
import com.emilio.tvseriesquiz.model.pojo.entity.ADSerie;
import com.emilio.tvseriesquiz.view.adapter.CommonAdapter;
import com.emilio.tvseriesquiz.view.adapter.CommonAdapterListener;
import com.emilio.tvseriesquiz.viewmodel.SeriesViewModel;

import java.util.ArrayList;
import java.util.List;

public class Series extends AppCompatActivity implements CommonAdapterListener<ADSerie> {

    private RecyclerView rvSerie;
    private ImageView ivImageBackground, ivAvatar;

    private SeriesViewModel mViewModel;
    private List<ADSerie> list = new ArrayList<>();
    private CommonAdapter<ADSerie> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transitionSetup();
        setContentView(R.layout.activity_main);

        mapUI();
        init();
    }

    private void mapUI() {
        rvSerie = findViewById(R.id.rvSeries);
        ivImageBackground = findViewById(R.id.ivImageBackground);
        ivAvatar = findViewById(R.id.ivAvatar);
    }

    private void init() {
        initializeViewModel();
        initializeRecyclerView();
    }

    private void initializeViewModel() {
        mViewModel = new ViewModelProvider(this).get(SeriesViewModel.class);
        mViewModel.init().observe(this, list -> {
            this.list = list;
            adapter.update(list);
        });
    }

    private void initializeRecyclerView() {
        //adapter
        adapter = new CommonAdapter<>(this, list, R.layout.row_serie, BR.serie);
        rvSerie.setAdapter(adapter);

        //layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyApp.getContext(), LinearLayoutManager.VERTICAL, false);
        rvSerie.setLayoutManager(layoutManager);
    }

    private void transitionSetup() {
        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        // set an exit transition
        getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Explode());
    }

    @Override
    public void getItem(@NonNull ADSerie serie, View view) {
        mViewModel.clickOnRowElement(serie);
    }
}
