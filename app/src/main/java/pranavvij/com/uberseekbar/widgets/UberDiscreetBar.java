package pranavvij.com.uberseekbar.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import pranavvij.com.uberseekbar.R;

/**
 * Created by pranavvij on 28/03/17.
 */

public class UberDiscreetBar extends LinearLayout {
    DiscreetSeekBar discreetSeekBar;
    // BackgroundSeekbar mBackGroundSeekBar;

    LayoutInflater mLayoutInflater;
    int mCount = 3;
    int mCurrentProgress = 0;
    int maxProgress = 100;

    public UberDiscreetBar(Context context) {
        super(context);
    }

    public UberDiscreetBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UberDiscreetBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public UberDiscreetBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void init(Context context, AttributeSet attrs) {
        mLayoutInflater = LayoutInflater.from(context);
        View mView = mLayoutInflater.inflate(R.layout.layout_uber_bar, this, false);
        discreetSeekBar = (DiscreetSeekBar) mView.findViewById(R.id.mDiscreetSeekBar);
        //mBackGroundSeekBar = (BackgroundSeekbar) mView.findViewById(R.id.mBackgroundSeekbar);
        addView(mView);
    }

    public void setAttributes() {
        maxProgress = (mCount - 1) * 100;
        discreetSeekBar.setMax(maxProgress);
    }

    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mCurrentProgress = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            mCurrentProgress = seekBar.getProgress();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            mCurrentProgress = seekBar.getProgress();
            int position = mCurrentProgress - mCurrentProgress % 100;
            int shift = mCurrentProgress % 100;
            if (shift > 50) {
                ObjectAnimator animation = ObjectAnimator.ofInt(seekBar, DiscreetSeekBar.PROPERTY_PROGRESS, mCurrentProgress, position + 100);
                animation.setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
                animation.setInterpolator(new DecelerateInterpolator());
                animation.start();
            } else {
                ObjectAnimator animator = ObjectAnimator.ofInt(seekBar, DiscreetSeekBar.PROPERTY_PROGRESS, mCurrentProgress, position);
                animator.setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
                animator.setInterpolator(new DecelerateInterpolator());
                animator.start();
            }
        }
    };
}
