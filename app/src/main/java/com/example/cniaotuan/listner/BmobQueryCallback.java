package com.example.cniaotuan.listner;

import com.example.cniaotuan.entity.FavorInfo;

import java.util.List;

/**
 * Created by hongkl on 16/9/5.
 */
public abstract class BmobQueryCallback implements IBmobListener {
    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailure() {

    }



    @Override
    public void queryAllSuccess(List<FavorInfo> object) {

    }
}
