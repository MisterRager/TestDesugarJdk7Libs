package es.lolrav.testdesugarjdk7libs;

import android.content.Context;

import com.qozix.tileview.widgets.ZoomPanLayout;

public class MyBrokenView extends ZoomPanLayout {
    public MyBrokenView(Context context) {
        super(context);
    }

    public void breakDesugar(){
        post(() -> setScale(getScale()));
    }
}