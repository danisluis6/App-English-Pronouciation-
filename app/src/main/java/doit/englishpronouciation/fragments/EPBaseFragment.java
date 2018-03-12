package doit.englishpronouciation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import doit.englishpronouciation.activities.EPBaseActivity;
import doit.englishpronouciation.utilities.Utils;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public abstract class EPBaseFragment extends Fragment {
    /**
     * Container activity
     */
    protected EPBaseActivity mActivity;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (EPBaseActivity) this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    protected abstract int getLayoutRes();

    protected abstract void initViews();

    protected void showMessage(String msg) {
        Utils.showToast(mActivity, msg);
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }
}
