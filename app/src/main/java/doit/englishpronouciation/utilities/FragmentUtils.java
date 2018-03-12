package doit.englishpronouciation.utilities;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.Stack;

import doit.englishpronouciation.R;
import doit.englishpronouciation.activities.EPBaseActivity;
import doit.englishpronouciation.fragments.FragmentStack;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class FragmentUtils {
    /**
     * Context
     */
    private Context context;
    /**
     * Stack<FragmentStack>
     */
    private Stack<FragmentStack> currentFrgStack;
    /**
     * Container res id
     */
    private int containerId;

    public FragmentUtils(Context context, Stack<FragmentStack> currentFrgStack, @IdRes int containerId) {
        this.context = context;
        this.currentFrgStack = currentFrgStack;
        this.containerId = containerId;
    }

    public void setCurrentFrgStack(Stack<FragmentStack> currentFrgStack) {
        this.currentFrgStack = currentFrgStack;
    }

    /**
     * Get current fragment in stack and show it
     */
    public void peekFragment() {
        try {
            FragmentStack fragment = currentFrgStack.peek();
            FragmentManager manager = ((EPBaseActivity) context).getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
            ft.replace(containerId, fragment.getFragment(), fragment.getTag());
            ft.commitAllowingStateLoss();
        } catch (IllegalStateException | ArrayIndexOutOfBoundsException e) {
            Log.e("", e.getMessage());
        }
    }

    /**
     * Get previous fragment in stack and show it
     */
    public void popFragment() {
        currentFrgStack.pop();
        peekFragment();
    }

    /**
     * Handle event when user change fragment
     */
    public void pushFragment(PushFrgType type, Fragment fragment, String tag, boolean shouldAdd) {
        try {
            FragmentManager manager = ((EPBaseActivity) context).getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            if (type == PushFrgType.REPLACE) {
                ft.replace(containerId, fragment, tag);
                ft.addToBackStack(tag);
                ft.commitAllowingStateLoss();
            } else if (type == PushFrgType.ADD) {
                ft.add(containerId, fragment, tag);
                ft.disallowAddToBackStack();
                ft.commit();
            }
            manager.executePendingTransactions();
        } catch (IllegalStateException e) {
            Log.e("", e.getMessage());
        }
        if (shouldAdd) {
            currentFrgStack.add(new FragmentStack(fragment, tag));
        }
    }

    public enum PushFrgType {
        REPLACE, ADD
    }
}
