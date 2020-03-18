package com.emilio.tvseriesquiz.model.pojo.entityDAO;

import java.util.Date;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import lombok.Data;

@Data
@RealmClass
public class ADSerieDAO implements RealmModel {

    @PrimaryKey
    private int code;

    private Date createdAt;
    private Date updatedAt;
    private boolean active;

    private String name;
    private int seasons;
    private int totalEpisodes;
    private String listEpisode;

    private int seasonProgress;
    private int episodeProgress;

    private boolean downloaded;

    private boolean complete;
    private int status;

    private String urlAvatar;
    private String urlImageBackground;
}
