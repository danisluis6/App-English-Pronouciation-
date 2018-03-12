package doit.englishpronouciation.utilities;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class Utils {
    // Lock all accesses from outside
    private Utils() {
    }

    /**
     * Show toast message
     *
     * @param context the context
     * @param msg     message to show
     */
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
