package com.zyascend.Nothing.mvp.grassproduct;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.bean.ProductMenu;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 15:08
 * 邮箱：zyascend@qq.com
 */

public class GrassPresenter extends BasePresenter<GrassContract.View>
    implements GrassContract.Presenter{

    private final HttpService httpService;

    public GrassPresenter() {
        this.httpService = HttpService.getInstance();
    }

    @Override
    public void getProdMenu(int type) {
        httpService.getCommonMenu(type, lifeCycleSubject, new BaseDataCallback<List<ProductMenu>>() {
            @Override
            public void onSuccess(List<ProductMenu> data) {
                if (isViewAttached())
                    mViewRef.get().onGetProdMenu(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())
                    mViewRef.get().onGetProdMenu(null);
            }
        });
    }

    @Override
    public void getHotProd() {
        httpService.findGrassHotProd(lifeCycleSubject, new BaseDataCallback<List<GrassProduct>>() {
            @Override
            public void onSuccess(List<GrassProduct> data) {
                if (isViewAttached())
                    mViewRef.get().onGetHotProd(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())
                    mViewRef.get().onGetHotProd(null);
            }
        });
    }

    @Override
    public void getGrassProd() {
        httpService.findGrassProd(lifeCycleSubject, new BaseDataCallback<List<GrassProduct>>() {
            @Override
            public void onSuccess(List<GrassProduct> data) {
                if (isViewAttached())
                    mViewRef.get().onGetGrassProd(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())
                    mViewRef.get().onGetGrassProd(null);
            }
        });
    }

    @Override
    public void getProdBox() {
        httpService.getProdBox(lifeCycleSubject, new BaseDataCallback<List<ProdBox>>() {
            @Override
            public void onSuccess(List<ProdBox> data) {
                if (isViewAttached())
                    mViewRef.get().onGetProdBox(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())
                    mViewRef.get().onGetProdBox(null);
            }
        });

    }

}
