package doit.englishpronouciation.fragments.SozoExchange;

import butterknife.OnClick;
import doit.englishpronouciation.R;
import doit.englishpronouciation.fragments.AnotherTool.Fragment1;
import doit.englishpronouciation.fragments.EPBaseFragment;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class Fragment3 extends EPBaseFragment {

    private static Fragment3 mInstance;

    public static Fragment3 getInstance() {
        if (mInstance == null) {
            mInstance = new Fragment3();
        }
        return mInstance;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_3;
    }

    @Override
    protected void initViews() {
    }

    @OnClick(R.id.btnExample)
    void exampleClicked() {
        showMessage("Example fragment");
    }
}
