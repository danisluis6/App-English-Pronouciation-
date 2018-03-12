package doit.englishpronouciation.activities.Home;

import android.support.v4.app.Fragment;

import doit.englishpronouciation.IEPBaseView;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public interface IHomeView extends IEPBaseView {

    void updateToolbar(String currentOption);

    void pushFragment(Fragment fragment, String tag);
}
