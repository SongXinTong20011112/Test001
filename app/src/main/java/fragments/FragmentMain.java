package fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.civilclass.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import activity.Activity01;
import activity.Activity02;
import activity.NewActivity;
import activity.Subject01Activity;
import activity.Subject02Activity;
import util.AppConfig;

public class FragmentMain extends Fragment implements View.OnClickListener {
    private ViewHolder viewHolder;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Integer> image = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.layout_fragment_main, null);

        viewHolder = new ViewHolder(inflate);
        inClick();
        initSlide();
        initListDate();
        initDate();

        return inflate;
    }

    private void initListDate() {
        title.add("90后程序员被骗子骗去诈骗还不知自己在诈骗");
        title.add("在吗？帮我砍一刀？");
        title.add("这套防诈骗测试题，你能得满分吗？");
        title.add("“有女人为我自杀，可以吹一辈子！”杀猪盘还要再“吃”多少人？");
        title.add("女明星换脸AV女优？骗子掌握「换脸」黑科技！太可怕了！");
        title.add("40岁男子被骗100万后自杀：撑不下去的时候，就看看这10张图");
        title.add("这些忙，绝对不能找朋友帮，有人会坐牢！");
        title.add("如何一句话把骗子气哭！");
        title.add("【惊】骗子盯上了团购APP 女子买30元零食被骗6万");
        title.add("针对小学生、中学生、大学生，骗子是怎样策划的——");
        title.add("大三学生“出借”银行卡成电诈“帮凶”，指认现场跪地痛哭……");
        title.add("“AI换脸”诈骗|只有你想不到没有他们做不到....");

        image.add(R.drawable.new01);
        image.add(R.drawable.new02);
        image.add(R.drawable.new03);
        image.add(R.drawable.new04);
        image.add(R.drawable.new05);
        image.add(R.drawable.new06);
        image.add(R.drawable.new07);
        image.add(R.drawable.new08);
        image.add(R.drawable.tj01);
        image.add(R.drawable.tj02);
        image.add(R.drawable.tj03);
        image.add(R.drawable.tj04);
    }

    private void initDate() {
        viewHolder.myListView.setAdapter(new BaseAdapter() {
            class ViewHolder {
                public View rootView;
                public TextView tv_title;
                public ImageView iv;
                public View myView;

                public ViewHolder(View rootView) {
                    this.rootView = rootView;
                    this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
                    this.iv = (ImageView) rootView.findViewById(R.id.iv);
                    this.myView = (View) rootView.findViewById(R.id.myView);
                }

            }

            @Override
            public int getCount() {
                return image.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View inflate = getLayoutInflater().inflate(R.layout.layout_news, null);
                final ViewHolder viewHolder = new ViewHolder(inflate);
                for (int i = 0; i < image.size(); i++) {
                    if ( i == position ){
                        viewHolder.tv_title.setText( title.get(i) );
                        viewHolder.iv.setImageResource( image.get(i) );
                    }
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppConfig.newNumber = position;
                        System.out.println("AppConfig.newNumber is " + AppConfig.newNumber );
                        startActivity( new Intent().setClass( getContext(), NewActivity.class ) );
//                        startActivity(new Intent().setClass(getContext(), DetailActivity.class));
//                        String title = viewHolder.tv_title.getText().toString();
//                        AppConfig.Title = title;
//                        AppConfig.Content = FragmentMain.Content;
//
//                        Intent intent = new Intent(getContext(), DetailActivity.class);
//                        viewHolder.iv.setDrawingCacheEnabled(Boolean.TRUE);
//                        intent.putExtra("BITMAP", viewHolder.iv.getDrawingCache());
//                        startActivity(intent);
                    }
                });

                return inflate;
            }
        });

        setListViewHeight(viewHolder.myListView);
    }

    private void setListViewHeight(ListView listView) {
        BaseAdapter adapter = (BaseAdapter) listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = adapter.getView(1, null, listView);
            view.measure(0, 0);
            totalHeight += view.getMeasuredHeight();
        }

        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    private void initSlide() {
        imagePath = new ArrayList<>();
        imagePath.add(R.drawable.glide01);
        imagePath.add(R.drawable.glide02);
        imagePath.add(R.drawable.glide03);
        viewHolder.myBanner.setImages(imagePath);
        viewHolder.myBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context.getApplicationContext()).load(path).into(imageView);
            }
        });
        viewHolder.myBanner.setDelayTime(2000);
        viewHolder.myBanner.start();
    }

    private void inClick() {
        viewHolder.ll_01.setOnClickListener(this);
        viewHolder.ll_02.setOnClickListener(this);
        viewHolder.ll_03.setOnClickListener(this);
        viewHolder.ll_04.setOnClickListener(this);
        viewHolder.ll_subject01.setOnClickListener( this );
        viewHolder.ll_subject02.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_01:
                startActivity(new Intent().setClass(getContext(), Activity01.class));
                break;
            case R.id.ll_02:
                startActivity(new Intent().setClass(getContext(), Activity02.class));
                break;
            case R.id.ll_03:
                initBtn("来电预警");
                break;
            case R.id.ll_04:
                initBtn("身份核实");
                break;
            case R.id.ll_subject01:
                startActivity( new Intent().setClass( getContext(), Subject01Activity.class ) );
                break;
            case R.id.ll_subject02:
                startActivity( new Intent().setClass( getContext(), Subject02Activity.class ) );
                break;
        }
    }

    private void initBtn(String string) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View inflate = getLayoutInflater().inflate(R.layout.layout_tc, null);
        class ViewHolder {
            public View rootView;
            public TextView tv;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.tv = (TextView) rootView.findViewById(R.id.tv);
            }

        }
        builder.setView(inflate);
        ViewHolder viewHolder = new ViewHolder(inflate);
        String s = viewHolder.tv.getText().toString();
        viewHolder.tv.setText(string + s);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();

    }

    public static
    class ViewHolder {
        public View rootView;
        public ImageView logo;
        public ImageView iv_report;
        public Banner myBanner;
        public LinearLayout ll_01;
        public LinearLayout ll_02;
        public LinearLayout ll_03;
        public LinearLayout ll_04;
        public ListView myListView;
        public LinearLayout ll_subject01;
        public LinearLayout ll_subject02;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.logo = (ImageView) rootView.findViewById(R.id.logo);
            this.myBanner = (Banner) rootView.findViewById(R.id.myBanner);
            this.ll_01 = (LinearLayout) rootView.findViewById(R.id.ll_01);
            this.ll_02 = (LinearLayout) rootView.findViewById(R.id.ll_02);
            this.ll_03 = (LinearLayout) rootView.findViewById(R.id.ll_03);
            this.ll_04 = (LinearLayout) rootView.findViewById(R.id.ll_04);
            this.myListView = (ListView) rootView.findViewById(R.id.myListView);
            this.ll_subject01 = rootView.findViewById( R.id.ll_subject01 );
            this.ll_subject02 = rootView.findViewById( R.id.ll_subject02 );
        }

    }


}
