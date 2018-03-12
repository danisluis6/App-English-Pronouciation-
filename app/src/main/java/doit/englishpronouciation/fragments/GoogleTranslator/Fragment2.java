package doit.englishpronouciation.fragments.GoogleTranslator;

import butterknife.OnClick;
import doit.englishpronouciation.R;
import doit.englishpronouciation.fragments.EPBaseFragment;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class Fragment2 extends EPBaseFragment {

    private static Fragment2 mInstance;

    public static Fragment2 getInstance() {
        if (mInstance == null) {
            mInstance = new Fragment2();
        }
        return mInstance;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_2;
    }

    @Override
    protected void initViews() {
    }

    @OnClick(R.id.btnExample)
    void exampleClicked() {
        showMessage("Example fragment");
    }
}
