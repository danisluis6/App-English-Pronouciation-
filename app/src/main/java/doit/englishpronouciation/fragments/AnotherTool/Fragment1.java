package doit.englishpronouciation.fragments.AnotherTool;

import doit.englishpronouciation.R;
import doit.englishpronouciation.fragments.EPBaseFragment;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class Fragment1 extends EPBaseFragment {

    private static Fragment1 mInstance;

    public static Fragment1 getInstance() {
        if (mInstance == null) {
            mInstance = new Fragment1();
        }
        return mInstance;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_1;
    }

    @Override
    protected void initViews() {
    }
}
