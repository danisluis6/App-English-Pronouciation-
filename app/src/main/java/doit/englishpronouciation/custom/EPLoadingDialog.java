package doit.englishpronouciation.custom;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;

import doit.englishpronouciation.R;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class EPLoadingDialog extends Dialog {
    /**
     * Activity context.
     */
    private Activity mActivity;

    /**
     * Initiate dialog.
     *
     * @param context activity context
     */
    public EPLoadingDialog(Activity context) {
        super(context);
        this.mActivity = context;
        init();
    }

    /**
     * Initiate the views.
     */
    private void init() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_progress);
        setCancelable(false);
    }

    @Override
    public void show() {
        if (mActivity != null && !mActivity.isFinishing()) {
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (mActivity != null && !mActivity.isFinishing()) {
            super.dismiss();
        }
    }
}
