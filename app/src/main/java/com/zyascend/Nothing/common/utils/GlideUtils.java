package com.zyascend.Nothing.common.utils;

import android.content.Context;
import android.media.Image;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Resource;

/**
 * 功能：
 * 作者：zyascend on 2017/5/22 15:09
 * 邮箱：zyascend@qq.com
 */

public class GlideUtils {

    public static void loadNormalPic(Context context,ImageView imageView, String url){
        if (imageView == null || TextUtils.isEmpty(url))return;
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    public static void loadRoundPic(Context context,ImageView imageView, String url){
        if (imageView == null || TextUtils.isEmpty(url))return;
        GlideRoundTransform transform = new GlideRoundTransform(context);
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(transform)
                .into(imageView);

    }

    public static void loadCirclePic(Context context,ImageView imageView, String url){
        if (imageView == null || TextUtils.isEmpty(url))return;
        GlideCircleTransform circleTransform = new GlideCircleTransform(context);
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(circleTransform)
                .into(imageView);
    }
}
