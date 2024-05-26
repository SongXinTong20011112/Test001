package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.civilclass.R;

import activity.PersonageActivity;
import user.AboutActivity;
import user.HelpActivity;
import user.SafetyActivity;
import user.SetActivity;

public class FragmentMy extends Fragment implements View.OnClickListener {

    private ViewHolder viewHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.layout_fragment_my, null);

        viewHolder = new ViewHolder(inflate);

        inClick();


        return inflate;
    }

    private void inClick() {
        viewHolder.rl_01.setOnClickListener(this);
        viewHolder.rl_02.setOnClickListener(this);
        viewHolder.rl_03.setOnClickListener(this);
        viewHolder.rl_04.setOnClickListener(this);
        viewHolder.rl_05.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_01:
                startActivity(new Intent().setClass(getContext(), PersonageActivity.class));
                break;
            case R.id.rl_02:
                startActivity( new Intent(getContext(), SafetyActivity.class));
//                Toast.makeText(getContext(), "账号安全功能尚未完善", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_03:
                startActivity( new Intent(getContext(), SetActivity.class));
//                Toast.makeText(getContext(), "设置功能尚未完善", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_04:
                startActivity( new Intent(getContext(), HelpActivity.class));
//                Toast.makeText(getContext(), "帮助与反馈功能尚未完善", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_05:
                startActivity( new Intent(getContext(), AboutActivity.class));
//                Toast.makeText(getContext(), "关于功能尚未完善", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public static
    class ViewHolder {
        public View rootView;
        public TextView tv_01;
        public ImageView iv_01;
        public RelativeLayout rl_01;
        public TextView tv_02;
        public ImageView iv_02;
        public RelativeLayout rl_02;
        public TextView tv_03;
        public ImageView iv_03;
        public RelativeLayout rl_03;
        public TextView tv_04;
        public ImageView iv_04;
        public RelativeLayout rl_04;
        public TextView tv_05;
        public ImageView iv_05;
        public RelativeLayout rl_05;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_01 = (TextView) rootView.findViewById(R.id.tv_01);
            this.iv_01 = (ImageView) rootView.findViewById(R.id.iv_01);
            this.rl_01 = (RelativeLayout) rootView.findViewById(R.id.rl_01);
            this.tv_02 = (TextView) rootView.findViewById(R.id.tv_02);
            this.iv_02 = (ImageView) rootView.findViewById(R.id.iv_02);
            this.rl_02 = (RelativeLayout) rootView.findViewById(R.id.rl_02);
            this.tv_03 = (TextView) rootView.findViewById(R.id.tv_03);
            this.iv_03 = (ImageView) rootView.findViewById(R.id.iv_03);
            this.rl_03 = (RelativeLayout) rootView.findViewById(R.id.rl_03);
            this.tv_04 = (TextView) rootView.findViewById(R.id.tv_04);
            this.iv_04 = (ImageView) rootView.findViewById(R.id.iv_04);
            this.rl_04 = (RelativeLayout) rootView.findViewById(R.id.rl_04);
            this.tv_05 = (TextView) rootView.findViewById(R.id.tv_05);
            this.iv_05 = (ImageView) rootView.findViewById(R.id.iv_05);
            this.rl_05 = (RelativeLayout) rootView.findViewById(R.id.rl_05);
        }

    }
}
