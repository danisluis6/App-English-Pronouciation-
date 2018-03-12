package doit.englishpronouciation.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class FragmentStack {
    /**
     * Fragment
     */
    Fragment fragment;
    /**
     * Tag name of fragment
     */
    String tag;

    public FragmentStack(Fragment fragment, String key) {
        this.fragment = fragment;
        tag = key;
    }

    /**
     * Get fragment
     *
     * @return fragment
     */
    public Fragment getFragment() {
        return fragment;
    }

    /**
     * Get tag of fragment
     *
     * @return tag
     */
    public String getTag() {
        return tag;
    }
}
