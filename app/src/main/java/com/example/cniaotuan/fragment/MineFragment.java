package com.example.cniaotuan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cniaotuan.R;
import com.example.cniaotuan.activity.CollectActivity;
import com.example.cniaotuan.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
    Button mBtnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_mine, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtnLogin = (Button) getView().findViewById(R.id.btn_login);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.tv_collect:
                startActivity(new Intent(getActivity(), CollectActivity.class));
                break;
            case R.id.tv_recent_view:
                break;
        }
    }
}
