package doit.englishpronouciation.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import doit.englishpronouciation.EPApplication;
import doit.englishpronouciation.utilities.Utils;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public abstract class EPBaseActivity extends AppCompatActivity {
    /**
     * Context
     */
    protected Context context;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = EPApplication.get(this).getContext();
        setContentView(getLayoutRes());
        unbinder = ButterKnife.bind(this);
        initAttributes();
        initViews();
    }

    protected abstract int getLayoutRes();

    protected abstract void initAttributes();

    protected abstract void initViews();

    protected void showMessage(String msg) {
        Utils.showToast(context, msg);
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
