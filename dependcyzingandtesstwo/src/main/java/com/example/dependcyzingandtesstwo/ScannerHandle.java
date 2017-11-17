package com.example.dependcyzingandtesstwo;

import android.graphics.Rect;
import android.os.Handler;

import com.google.zxing.Result;

/**
 * 作者libohan on 2017/10/23.
 * 邮箱:76681287@qq.com
 */

public interface ScannerHandle {
    public void  handleDecode(Result result);
    public Rect getCropRect();
    public boolean isQRCode();
    public Handler getCaptureActivityHandler();
}
