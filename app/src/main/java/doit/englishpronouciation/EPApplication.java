package doit.englishpronouciation;

import android.app.Application;
import android.content.Context;

/**
 * Created by lorence on 12/03/2018.
 *
 */

public class EPApplication extends Application {
    /**
     * Application context
     */
    private Context context;

    /**
     * Get EFApplication instance
     *
     * @param context the context
     * @return EFApplication
     */
    public static EPApplication get(Context context) {
        return (EPApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    /**
     * Get the context of application
     *
     * @return context
     */
    public Context getContext() {
        return context;
    }
}
