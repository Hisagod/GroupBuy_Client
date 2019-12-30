package com.example.cniaotuan.listner;

import com.example.cniaotuan.entity.FavorInfo;

import java.util.List;


/**
 * Created by hongkl on 16/9/5.
 */
public interface IBmobListener {
    void loginSuccess();
    void loginFailure();
    void querySuccess(FavorInfo object);
    void queryAllSuccess(List<FavorInfo> object);
}
