package com.zyascend.Nothing.mvp.mainpage.tag;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.ChildTag;
import com.zyascend.Nothing.bean.SiftsBean;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;
import com.zyascend.Nothing.mvp.mainpage.MainContract;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 10:18
 * 邮箱：zyascend@qq.com
 */

public class TagPresenter extends BasePresenter<MainContract.TagView>
        implements MainContract.TagPresenter {

    private HttpService httpService;
    public TagPresenter() {
        httpService = HttpService.getInstance();
    }


    @Override
    public void getChildTags(final String id) {
        httpService.getChildTags(id, lifeCycleSubject, new BaseDataCallback<List<List<ChildTag>>>() {
            @Override
            public void onSuccess(List<List<ChildTag>> data) {
                if (isViewAttached())mViewRef.get().onGetChildTags(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }

    @Override
    public void getDynamic(String mainId, List<ChildTag> childTags) {
        httpService.getDynamicByTags(mainId, childTags, lifeCycleSubject, new BaseDataCallback<List<SiftsBean>>() {
            @Override
            public void onSuccess(List<SiftsBean> data) {
                if (isViewAttached())mViewRef.get().onGetDynamic(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().showError();
            }
        });
    }
}
