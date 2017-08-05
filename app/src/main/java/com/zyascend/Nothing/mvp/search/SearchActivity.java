package com.zyascend.Nothing.mvp.search;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.zyascend.Nothing.R;
import com.zyascend.Nothing.base.BasePresenter;
import com.zyascend.Nothing.base.MVPBaseActivity;
import com.zyascend.Nothing.common.utils.ActivityUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 功能：
 * 作者：zyascend on 2017/7/19 15:17
 * 邮箱：zyascend@qq.com
 */

public class SearchActivity extends MVPBaseActivity<SearchContract.SearchView,SearchActivityPresenter> implements AdapterView.OnItemClickListener
        ,SearchContract.SearchView {
    @Bind(R.id.ed_search)
    EditText edSearch;
    @Bind(R.id.flex_hot_words)
    FlexboxLayout flexHotWords;
    @Bind(R.id.tv_history)
    TextView tvHistory;
    @Bind(R.id.btn_clearHistory)
    TextView btnClearHistory;
    @Bind(R.id.list_history)
    ListView listHistory;
    @Bind(R.id.ll_hotWords)
    LinearLayout llHotWords;
    @Bind(R.id.fr_history)
    FrameLayout frHistory;

    private ArrayList<String> mList;
    private ArrayAdapter<String> adapter;

    @Override
    protected SearchActivityPresenter initPresenter() {
        return new SearchActivityPresenter();
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mList);
        listHistory.setAdapter(adapter);
        listHistory.setOnItemClickListener(this);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String temp = edSearch.getText().toString();
                if (!TextUtils.isEmpty(temp)){
                    llHotWords.setVisibility(View.GONE);
                    frHistory.setVisibility(View.GONE);
                    mPresenter.getSuggestWord(temp);
                }else {
                    llHotWords.setVisibility(View.VISIBLE);
                    frHistory.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        fetchData();
    }

    private void fetchData() {
        mPresenter.getHotSearchWord();
        mPresenter.getSearchHistory();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_search;
    }


    @OnClick(R.id.btn_clearHistory)
    public void onClick() {
        adapter.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onGetSearchHistory(List<String> list) {
        updateAdapter(list);
    }

    private void updateAdapter(List<String> list) {
        if (!ActivityUtils.notNullOrEmpty(list))return;
        adapter.clear();
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onGetHotSearchWord(List<String> hotWords) {
        if (!ActivityUtils.notNullOrEmpty(hotWords))return;
        for (String s : hotWords){
            TextView textView = ActivityUtils.obtainTextView(s,this);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 2017/8/5
                }
            });
            flexHotWords.addView(textView);
        }
    }

    @Override
    public void onGetSuggestWord(List<String> suggestWords) {
        updateAdapter(suggestWords);
    }
}
