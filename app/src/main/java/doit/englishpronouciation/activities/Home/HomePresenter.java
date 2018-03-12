package doit.englishpronouciation.activities.Home;

import android.content.Context;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class HomePresenter implements IHomePresenter {
    /**
     * Context
     */
    private Context context;
    /**
     * IHomeModel
     */
    private IHomeModel homeModel;
    /**
     * IHomeView
     */
    private IHomeView homeView;

    public HomePresenter(Context context) {
        this.context = context;
        this.homeModel = new HomeModel(context);
        this.homeModel.attachPresenter(this);
    }

    @Override
    public void attachView(IHomeView view) {
        this.homeView = view;
    }
}
