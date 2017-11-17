package com.example.dependcyzingandtesstwo.view;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dependcyzingandtesstwo.R;


public class ImageDialog extends Dialog {

    private Bitmap bmp;

    private String title;
    private Context context;

    public ImageDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public ImageDialog addBitmap(Bitmap bmp) {
        if (bmp != null)
            this.bmp = bmp;
        return this;
    }

    public ImageDialog addTitle(String title) {
        if (title != null)
            this.title = title;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_dialog);

        ImageView imageView = (ImageView)findViewById(R.id.image_dialog_imageView);
        TextView textView = (TextView)findViewById(R.id.image_dialog_textView);

        if (bmp != null)
            imageView.setImageBitmap(bmp);

        if(title!=null)
            textView.setText(this.title);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Log.e("LBH","点击了");
               Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                       + title.trim()));
               if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                   Log.e("LBH","还真没权限");
                   return;
               }
               context.startActivity(intent);
           }
       });
    }

    @Override
    public void dismiss() {
        bmp.recycle();
        bmp = null;
        System.gc();
        super.dismiss();
    }
}