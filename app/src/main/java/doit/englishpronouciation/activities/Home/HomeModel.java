package doit.englishpronouciation.activities.Home;

import android.content.Context;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class HomeModel implements IHomeModel {
    /**
     * Context
     */
    private Context context;
    /**
     * IHomePresenter
     */
    private IHomePresenter homePresenter;

    public HomeModel(Context context) {
        this.context = context;
    }

    @Override
    public void attachPresenter(IHomePresenter presenter) {
        this.homePresenter = presenter;
    }
}
