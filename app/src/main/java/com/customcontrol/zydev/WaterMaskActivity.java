package com.customcontrol.zydev;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.customcontrol.zydev.util.ImageUtil;
import com.customcontrol.zydev.util.WaterMaskUtil;
import com.customcontrol.zydev.weight.WaterMaskView;
import com.watermark.androidwm_light.WatermarkBuilder;
import com.watermark.androidwm_light.bean.WatermarkImage;
import com.watermark.androidwm_light.bean.WatermarkText;

import java.util.ArrayList;
import java.util.List;

public class WaterMaskActivity extends AppCompatActivity {

    private ImageView ivWaterMark;

    private WaterMaskView waterMaskView;
    private Bitmap sourBitmap;
    private Bitmap waterBitmap;
    private Bitmap watermarkBitmap;

    private final static int LEFT_TOP=0;
    private final static int RIGHT_TOP=1;
    private final static int RIGHT_BOTTOM=2;
    private final static int LEFT_BOTTOM=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_mask);

        ivWaterMark= (ImageView) findViewById(R.id.wartermark_pic);

        sourBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_demo);

        WatermarkImage watermarkImage1 = new WatermarkImage(this, R.mipmap.bg_start_progress);
        watermarkImage1.setSize(0.05);
        watermarkImage1.setImageAlpha(255);
        watermarkImage1.setPositionX(0.05);
        watermarkImage1.setPositionY(0.75);
        WatermarkText watermarkText1 = new WatermarkText("位置位置");
        watermarkText1.setTextColor(R.color.black);
        watermarkText1.setPositionX(watermarkImage1.getPosition().getPositionX()+0.1);
        watermarkText1.setPositionY(watermarkImage1.getPosition().getPositionY());
        watermarkText1.setTextSize(15.0);
        watermarkText1.setTextAlpha (255);



        WatermarkImage watermarkImage2 = new WatermarkImage(this, R.mipmap.bg_start_progress_run);
        watermarkImage2.setSize(0.05);
        watermarkImage2.setImageAlpha(255);
        watermarkImage2.setPositionX(0.05);
        watermarkImage2.setPositionY(0.85);
        WatermarkText watermarkText2 = new WatermarkText("名称名称名称");
        watermarkText2.setTextColor(R.color.black);
        watermarkText2.setPositionX(watermarkText1.getPosition().getPositionX());
        watermarkText2.setPositionY(watermarkImage2.getPosition().getPositionY());
        watermarkText2.setTextSize(15.0);
        watermarkText2.setTextAlpha (255);






        List<WatermarkText> textList = new ArrayList<>();
        textList.add(watermarkText1);
        textList.add(watermarkText2);
        List<WatermarkImage> imageList = new ArrayList<>();
        imageList.add(watermarkImage1);
        imageList.add(watermarkImage2);




        Bitmap bitmap = WatermarkBuilder
                .create(this, sourBitmap)
                .loadWatermarkTexts(textList)
                .loadWatermarkImages(imageList)
                .getWatermark()
                .getOutputImage();
        ivWaterMark.setImageBitmap(bitmap);
//        waterMaskView = new WaterMaskView(this);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT*2, RelativeLayout.LayoutParams.MATCH_PARENT);
//        waterMaskView.setLayoutParams(params);
//        waterMaskView.setCompanyText("XXXXXX公司");
//        waterMaskView.setInfoText("这是相关信息1这是相关信息2这是相关信息3这是相关信息4这是相关信息5");
//        Bitmap testBitmap = ImageUtil.drawTextToLeftTop(this, sourBitmap, "示例文字", 30, R.color.black, 20, 30);
//        Bitmap testBitmap = ImageUtil.drawTextToLeftTop(this, sourBitmap, "示例文字", 30, R.color.black, 20, 30);
//        Bitmap testBitmap = ImageUtil.drawTextToLeftBottom(this, sourBitmap, "示例文字", 10, R.color.black, 10, 10);
//
        //默认设置水印位置在左下
//        saveWaterMask(LEFT_BOTTOM);


    }

    /**
     * @param position 左上为0，顺时针算起
     */
    private void saveWaterMask(int position) {
        waterBitmap = WaterMaskUtil.convertViewToBitmap(waterMaskView);

        //根据原图处理要生成的水印的宽高
        float width = sourBitmap.getWidth();
        float height = sourBitmap.getHeight();
        float be = width / height;

        if ((float) 16 / 9 >= be && be >= (float) 4 / 3) {
            //在图片比例区间内16;9~4：3内，将生成的水印bitmap设置为原图宽高各自的1/5
            waterBitmap = WaterMaskUtil.zoomBitmap(waterBitmap, (int) width / 5, (int) height / 5);
        } else if (be > (float) 16 / 9) {
            //生成4：3的水印
            waterBitmap = WaterMaskUtil.zoomBitmap(waterBitmap, (int) width / 5, (int) width*3 / 20);
        } else if (be < (float) 4 / 3) {
            //生成4：3的水印
            waterBitmap = WaterMaskUtil.zoomBitmap(waterBitmap, (int) height*4 / 15, (int) height / 5);
        }

        switch (position) {
            case LEFT_BOTTOM:
                watermarkBitmap = WaterMaskUtil.createWaterMaskLeftBottom(this, sourBitmap, waterBitmap, 0, 0);
                break;
        }
        ivWaterMark.setImageBitmap(watermarkBitmap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (sourBitmap != null) {
            sourBitmap.recycle();
            sourBitmap = null;
        }
        if (waterBitmap != null) {
            waterBitmap.recycle();
            waterBitmap = null;
        }
    }
}