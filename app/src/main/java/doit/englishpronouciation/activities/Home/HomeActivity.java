package doit.englishpronouciation.activities.Home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuItem;

import java.util.Stack;

import doit.englishpronouciation.R;
import doit.englishpronouciation.activities.EPBaseActivity;
import doit.englishpronouciation.fragments.AnotherTool.Fragment1;
import doit.englishpronouciation.fragments.FragmentStack;
import doit.englishpronouciation.fragments.GoogleTranslator.Fragment2;
import doit.englishpronouciation.fragments.SozoExchange.Fragment3;
import doit.englishpronouciation.utilities.Constants;
import doit.englishpronouciation.utilities.FragmentUtils;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class HomeActivity extends EPBaseActivity implements IHomeView {

    /**
     * Current fragment stack.
     */
    private Stack<FragmentStack> currentFrgStack;
    /**
     * FragmentUtils
     */
    private FragmentUtils fragmentUtils;
    /**
     * IHomePresenter
     */
    private IHomePresenter homePresenter;
    /**
     * TitleMessage
     */
    private static String sCurrentOption;

    // Fragments
    private Fragment1 mFragment1;
    private Fragment2 mFragment2;
    private Fragment3 mFragment3;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initAttributes() {
        homePresenter = new HomePresenter(this);
        homePresenter.attachView(this);
        currentFrgStack = new Stack<>();
        fragmentUtils = new FragmentUtils(this, currentFrgStack, R.id.fragment_container);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void initViews() {
        setTitle(getString(R.string.nav_item_translator));
        mFragment1 = Fragment1.getInstance();
        sCurrentOption = Constants.FRAGMENT_TAG_GOOGLE_TRANSLATOR;
        pushFragment(mFragment1, Constants.FRAGMENT_TAG_GOOGLE_TRANSLATOR);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_google_translator:
                    updateToolbar(Constants.FRAGMENT_TAG_GOOGLE_TRANSLATOR);
                    return true;
                case R.id.navigation_sozo_exchanged:
                    updateToolbar(Constants.FRAGMENT_TAG_SOZO_EXCHANGE);
                    return true;
                case R.id.navigation_other_support:
                    updateToolbar(Constants.FRAGMENT_TAG_OTHER_SUPPORT);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void updateToolbar(String currentOption) {
        switch (currentOption) {
            case Constants.FRAGMENT_TAG_GOOGLE_TRANSLATOR:
                mFragment1 = Fragment1.getInstance();
                pushFragment(mFragment1, currentOption);
                break;
            case Constants.FRAGMENT_TAG_SOZO_EXCHANGE:
                mFragment2 = Fragment2.getInstance();
                pushFragment(mFragment2, currentOption);
                break;
            case Constants.FRAGMENT_TAG_OTHER_SUPPORT:
                mFragment3 = Fragment3.getInstance();
                pushFragment(mFragment3, currentOption);
                break;
            default:
                break;
        }
    }

    @Override
    public void pushFragment(Fragment fragment, String tag) {
        fragmentUtils.pushFragment(FragmentUtils.PushFrgType.REPLACE, fragment, tag, false);
        sCurrentOption = tag;
        Log.i("TAG", "currentFrgStack.size(): "+currentFrgStack.size());
        setTitle(sCurrentOption);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
