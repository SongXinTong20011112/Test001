package util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private static Toast toast;

    public static void shouToast(Context context,String content){
        if (toast == null) {
            toast = Toast.makeText(context,content,Toast.LENGTH_SHORT);
        }else {
            toast.setText(content);
        }
        toast.show();
    }

}
