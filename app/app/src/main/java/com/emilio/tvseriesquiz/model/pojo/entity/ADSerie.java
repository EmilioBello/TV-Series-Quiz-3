package com.emilio.tvseriesquiz.model.pojo.entity;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import test.skeleton.androidviewmodelapp.MyApp;

/**
 * Created by Emilio on 11/02/2016.
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class ADSerie extends ADEntity {
    private String name;

    private int season;
    private int totalEpisodes;

    private int seasonProgress;
    private int episodeProgress;

    private boolean downloaded;

    private ArrayList<Integer> listEpisode;

    private boolean complete;
    private int status;

    private String urlAvatar;
    private String urlImageBackground;

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(MyApp.getContext())
                .load(imageUrl)
                .into(view);
    }
}
