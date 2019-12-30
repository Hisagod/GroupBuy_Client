package com.example.cniaotuan.listner;

import com.example.cniaotuan.entity.FavorInfo;

import java.util.List;


/**
 * Created by hongkl on 16/9/6.
 */
public abstract class BmobLoginCallback implements IBmobListener {

    @Override
    public void querySuccess(FavorInfo object) {

    }

    @Override
    public void queryAllSuccess(List<FavorInfo> object) {

    }
}
