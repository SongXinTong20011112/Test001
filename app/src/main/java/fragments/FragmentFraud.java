package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.civilclass.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import activity.PjActivity;
import util.AppConfig;

public class FragmentFraud extends Fragment {

    private ViewHolder viewHolder;
    private String type[] = {"推荐", "高校", "刷单", "网贷"};
    private List<String> tabList = new ArrayList<>();
    private List<String> tjListTitle = new ArrayList<>();
    private List<String> tjListContent = new ArrayList<>();
    private List<Integer> tjImage = new ArrayList<>();
    private List<String> gxListTitle = new ArrayList<>();
    private List<String> gxListContent = new ArrayList<>();
    private List<Integer> gxImage = new ArrayList<>();
    private List<String> sdListTitle = new ArrayList<>();
    private List<String> sdListContent = new ArrayList<>();
    private List<Integer> sdImage = new ArrayList<>();
    private List<String> wdListTitle = new ArrayList<>();
    private List<String> wdListContent = new ArrayList<>();
    private List<Integer> wdImage = new ArrayList<>();
    private HashMap<String, List<String>> map = new HashMap<>();
    private HashMap<String, List<Integer>> mapImage = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_fragment_fraud, null);

        viewHolder = new ViewHolder(inflate);
        initListDate();
        initDate();

        return inflate;
    }

    private void initListDate() {

        tjListTitle.add("【惊】骗子盯上了团购APP 女子买30元零食被骗6万");
        tjListTitle.add("针对小学生、中学生、大学生，骗子是怎样策划的——");
        tjListTitle.add("大三学生“出借”银行卡成电诈“帮凶”，指认现场跪地痛哭……");
        tjListTitle.add("“AI换脸”诈骗|只有你想不到没有他们做不到....");
        tjListTitle.add("90后程序员被骗子骗去诈骗还不知自己在诈骗");
        tjListTitle.add("在吗？帮我砍一刀？");
        tjListTitle.add("这套防诈骗测试题，你能得满分吗？");
        tjListTitle.add("“有女人为我自杀，可以吹一辈子！”杀猪盘还要再“吃”多少人？");
        tjListTitle.add("女明星换脸AV女优？骗子掌握「换脸」黑科技！太可怕了！");

        tjImage.add(R.drawable.tj01);
        tjImage.add(R.drawable.tj02);
        tjImage.add(R.drawable.tj03);
        tjImage.add(R.drawable.tj04);
        tjImage.add(R.drawable.new01);
        tjImage.add(R.drawable.new02);
        tjImage.add(R.drawable.new03);
        tjImage.add(R.drawable.new04);
        tjImage.add(R.drawable.new05);


        gxListTitle.add("针对小学生、中学生、大学生，骗子是怎样策划的——");
        gxListTitle.add("手机那头的ta是你熟悉的人吗？");
        gxListTitle.add("大三学生“出借”银行卡成电诈“帮凶”，指认现场跪地痛哭……");
        gxListTitle.add("在？进来谈个恋爱");
        gxListTitle.add("某地上千学生被骗！他们有一个共同点……");
        gxListTitle.add("有一种“恋爱”，让你悲痛欲绝......");
        gxListTitle.add("大学生如何防诈骗");

        gxImage.add(R.drawable.tj02);
        gxImage.add(R.drawable.gx01);
        gxImage.add(R.drawable.tj03);
        gxImage.add(R.drawable.gx02);
        gxImage.add(R.drawable.gx03);
        gxImage.add(R.drawable.gx04);
        gxImage.add(R.drawable.zt01);

        sdListTitle.add("刷单兼职骗局，专挑这些人下手……");
        sdListTitle.add("男子因为好奇陷入裸聊骗局，没脱衣服仍被骗走6万块");
        sdListTitle.add("刷抖音的时候，可否了解或者遇到过骗子设的局");
        sdListTitle.add("经典骗局还是能骗到你？");
        sdListTitle.add("聪明的你，是如何一步步被兼职刷单给骗的……");
        sdListTitle.add("【惊】骗子盯上了团购APP 女子买30元零食被骗6万");
        sdListTitle.add("大三学生“出借”银行卡成电诈“帮凶”，指认现场跪地痛哭……");

        sdImage.add(R.drawable.sd01);
        sdImage.add(R.drawable.sd02);
        sdImage.add(R.drawable.sd03);
        sdImage.add(R.drawable.sd04);
        sdImage.add(R.drawable.sd05);
        sdImage.add(R.drawable.tj01);
        sdImage.add(R.drawable.tj03);

        wdListTitle.add("大三学生“出借”银行卡成电诈“帮凶”，指认现场跪地痛哭……");
        wdListTitle.add("诈骗新套路！考证、培训…最后竟然办理了贷款？");
        wdListTitle.add("你微信好友里有没有这些骗子？");
        wdListTitle.add("疫情严峻，骗子又假借“热点”伺机而动了......");
        wdListTitle.add("姑娘在银行里边哭边办银行卡……真相让人哭笑不得");
        wdListTitle.add("杀猪盘诈骗团伙内部的培训资料！");
        wdListTitle.add("刷单兼职骗局，专挑这些人下手……");

        wdImage.add(R.drawable.tj03);
        wdImage.add(R.drawable.sd01);
        wdImage.add(R.drawable.sd02);
        wdImage.add(R.drawable.sd03);
        wdImage.add(R.drawable.sd04);
        wdImage.add(R.drawable.sd05);
        wdImage.add(R.drawable.sd01);

        map.put("推荐", tjListTitle);
        map.put("高校", gxListTitle);
        map.put("刷单", sdListTitle);
        map.put("网贷", wdListTitle);

        mapImage.put("推荐",tjImage);
        mapImage.put("高校",gxImage);
        mapImage.put("刷单",sdImage);
        mapImage.put("网贷",wdImage);

    }

    private void initDate() {
        for (int i = 0; i < type.length; i++) {
            tabList.add(type[i]);
            viewHolder.myTabLayout.addTab(viewHolder.myTabLayout.newTab().setText(tabList.get(i)));
        }

        viewHolder.myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                final int position = tab.getPosition();
                final String s = tabList.get(position);
                final List<String> strings = map.get(s);
                final List<Integer> integers = mapImage.get(s);
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
                        return map.get(tabList.get(position)).size();
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

                        ViewHolder viewHolder = new ViewHolder(inflate);
                        viewHolder.tv_title.setText( strings.get(position) );
                        viewHolder.iv.setImageResource( integers.get(position) );

                        inflate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AppConfig.newType = s;
                                System.out.println("新闻类型是   " + s  );
                                AppConfig.pjNewsPosition = position;
                                System.out.println("点击的索引是 " + position );
                                startActivity( new Intent().setClass( getContext(), PjActivity.class ) );
                            }
                        });

                        return inflate;
                    }
                });

                setListViewHeight(viewHolder.myListView);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewHolder.myTabLayout.setScrollPosition(0, 0, false);

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
                return tjImage.size();
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

                ViewHolder viewHolder = new ViewHolder(inflate);
                viewHolder.iv.setImageResource(tjImage.get(position));
                viewHolder.tv_title.setText(tjListTitle.get(position));

                inflate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppConfig.newType = "推荐";
                        AppConfig.pjNewsPosition = position ;
                        startActivity( new Intent().setClass( getContext(), PjActivity.class ) );
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

    public static
    class ViewHolder {
        public View rootView;
        public TabLayout myTabLayout;
        public ListView myListView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.myTabLayout = (TabLayout) rootView.findViewById(R.id.myTabLayout);
            this.myListView = rootView.findViewById(R.id.myListView);
        }

    }
}
