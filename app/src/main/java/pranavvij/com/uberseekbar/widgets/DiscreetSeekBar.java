package pranavvij.com.uberseekbar.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by pranavvij on 28/03/17.
 */

public class DiscreetSeekBar extends AppCompatSeekBar {

    public static String PROPERTY_PROGRESS = "progress";
    int mRingCount = 2;
    int mMaxProgress = 100;

    public DiscreetSeekBar(Context context) {
        super(context);
    }

    public void setmRingCount(int mRingCount) {
        this.mRingCount = mRingCount;
        invalidate();
    }

    public void setMax(int maxProgress) {
        this.mMaxProgress = maxProgress;
        invalidate();
    }
}
