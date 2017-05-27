package com.zyascend.Nothing.mvp.grassproduct;

import com.zyascend.Nothing.base.BaseFragment;
import com.zyascend.Nothing.base.BaseView;
import com.zyascend.Nothing.bean.GrassProduct;
import com.zyascend.Nothing.bean.ProdBox;
import com.zyascend.Nothing.bean.ProductMenu;

import java.util.List;

/**
 * 功能：
 * 作者：zyascend on 2017/5/26 15:02
 * 邮箱：zyascend@qq.com
 */

public interface GrassContract {
    interface View extends BaseView{
        void onGetProdMenu(List<ProductMenu> menus);
        void onGetHotProd(List<GrassProduct> products);
        void onGetGrassProd(List<GrassProduct> products);
        void onGetProdBox(List<ProdBox> boxes);
    }
    interface Presenter{
        void getProdMenu();
        void getHotProd();
        void getGrassProd();
        void getProdBox();
    }
}
