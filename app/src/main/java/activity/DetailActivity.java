package activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.CsActivity;
import com.example.civilclass.R;
import com.example.civilclass.ZYMActivity;

import util.AppConfig;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private TextView tv_title;
    private TextView tv_content;
    private ImageView image_article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        image = (ImageView) findViewById(R.id.image);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_content = (TextView) findViewById(R.id.tv_content);
        image_article = (ImageView) findViewById(R.id.image_article);
        image_article.setOnClickListener(this);

        image.setOnClickListener(this);

        initDate();

        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent().setClass( DetailActivity.this, CsActivity.class ) );
            }
        });
    }

    private void initDate() {
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("BITMAP") != null) {
            System.out.println("You and me");
            Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("BITMAP");
            image_article.setImageBitmap(bitmap);
        }

        tv_content.setText(AppConfig.Content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image:
                startActivity( new Intent().setClass( DetailActivity.this, ZYMActivity.class ) );
                break;
        }
    }
}