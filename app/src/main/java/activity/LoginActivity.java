package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;
import com.google.gson.JsonObject;

import util.HttpRequest;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    private void initDate() {
        final String url = "/prod-api/api/login";
        new Thread(new Runnable() {
            @Override
            public void run() {
                final JsonObject jsonObject = HttpRequest.getPost(url, "{\n" +
                        "\"username\":\"test26\",\n" +
                        "\"password\":\"123456\"\n" +
                        "}", JsonObject.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (jsonObject != null) {
                            System.out.println("json 是空");
                            if (jsonObject.get("code").getAsString().equals("200")) {
                                System.out.println( jsonObject.get("code").getAsString() + " this is code is ");
                                System.out.println("***进到了Post请求***");
                            } else {
                                System.out.println("没进来");
                            }
                        }
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                initDate();
                break;
        }
    }
}