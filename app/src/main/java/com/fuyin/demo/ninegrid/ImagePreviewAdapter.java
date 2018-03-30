package com.fuyin.demo.ninegrid;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Description:
 * @Author: Liangchaojie
 * @Create On 2018/3/30 10:33
 */
public class ImagePreviewAdapter extends PagerAdapter {
    private Context context;
    private List<String> imageList;

    public ImagePreviewAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList==null?0:imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public PhotoView instantiateItem(ViewGroup container, int position) {
        final PhotoView image = new PhotoView(context);
        // 开启图片缩放功能
        image.setEnabled(true);
        // 设置缩放类型
        image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        // 设置最大缩放倍数
        image.setMaxScale(2.5f);
        // 加载图片
        Glide.with(context).load(imageList.get(position)).into(image);
        // 单击图片，返回
       image.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               image.setEnabled(false);
               ((Activity)context).finish();
           }
       });
        container.addView(image);
        return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
