package com.example.cniaotuan.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.example.cniaotuan.R;
import com.example.cniaotuan.utils.DataCleanManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    //wifi分享设置
//    @InjectView(R.id.iv_wifi_switch)
    CheckBox mIvWifiSwitch;
    //消息提醒设置
//    @InjectView(R.id.iv_remind_switch)
    CheckBox mIvRemindSwitch;
    //清除缓存
//    @InjectView(R.id.clear_cache_layout)
    RelativeLayout mClearCacheLayout;
    //赏个好评
//    @InjectView(R.id.good_comment_layout)
    RelativeLayout mGoodCommentLayout;
    //联系客服
//    @InjectView(R.id.kefu_layout)
    RelativeLayout mKefuLayout;
    //应用更新
//    @InjectView(R.id.rl_softvare_update)
    RelativeLayout mRlSoftvareUpdate;
    //    @InjectView(R.id.cache_size)
    TextView mTvCacheSize;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_more, container, false);
        try {
            String cacheSize = DataCleanManager.getTotalCacheSize(getActivity());
            mTvCacheSize.setText(cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        enterAbout();
    }

    /**
     * 进入关于我们
     */
    private void enterAbout() {
        getView().findViewById(R.id.tv_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showShort("关于");
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clear_cache_layout:
                DataCleanManager.clearAllCache(getActivity());
                Toast.makeText(getActivity(), "缓存清除成功!", Toast.LENGTH_SHORT).show();
                mTvCacheSize.setText("0KB");
                break;
            case R.id.kefu_layout:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + "1851234567"));
                //开启系统拨号器
                startActivity(intent);
                break;
            case R.id.good_comment_layout:

                openApplicationMarket("");

                break;
            case R.id.rl_softvare_update:

//                BmobUpdateAgent.forceUpdate(getActivity());
                break;
        }
    }

    public void openApplicationMarket(String packageName) {
        try {

            String str = "market://detail?id=" + packageName;

            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(Uri.parse(str));

            startActivity(intent);

        } catch (Exception e) {
            //打开应用商店失败 可能是因为手机没有安装应用市场
            Toast.makeText(getActivity(), "打开应用商店失败!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            //当应用上线
            String url = "";
            //调用浏览器进入商城
            openLinkByUrl(url);

        }
    }


    /***
     * 调用系统的浏览器打开网页
     * @param url
     */
    private void openLinkByUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


}
