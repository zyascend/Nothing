package com.zyascend.Nothing.mvp.search;

import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.common.BaseDataCallback;
import com.zyascend.Nothing.mvp.data.CacheManager;
import com.zyascend.Nothing.mvp.http.HttpService;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/8/4 16:47
 * 邮箱：zyascend@qq.com
 */

public class SearchActivityPresenter extends BasePresenter<SearchContract.SearchView>
        implements SearchContract.SearchPresenter {

    private final HttpService httpService;
    private final CacheManager cacheManager;

    public SearchActivityPresenter() {
        httpService = HttpService.getInstance();
        cacheManager = CacheManager.getInstance();
    }


    @Override
    public void getSearchHistory() {
        cacheManager.getSearchHistory(new BaseDataCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> data) {
                if (isViewAttached())mViewRef.get().onGetHotSearchWord(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetHotSearchWord(null);
            }
        });
    }

    @Override
    public void addSearchHistory(String word) {
        cacheManager.addSearchHistory(word);
    }

    @Override
    public void getSuggestWord(String tempWord) {
        httpService.getSuggestWords(tempWord, lifeCycleSubject, new BaseDataCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> data) {
                if (isViewAttached())mViewRef.get().onGetSuggestWord(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetSuggestWord(null);
            }
        });
    }

    @Override
    public void getHotSearchWord() {
        httpService.getSearchHotWord(lifeCycleSubject, new BaseDataCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> data) {
                if (isViewAttached())mViewRef.get().onGetHotSearchWord(data);
            }

            @Override
            public void onFail(String errorMsg) {
                if (isViewAttached())mViewRef.get().onGetHotSearchWord(null);
            }
        });
    }
}
