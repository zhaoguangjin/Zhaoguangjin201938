package com.bwie.zhaoguangjin201938.view.adapter;

import android.content.Context;
import android.print.PrinterId;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.zhaoguangjin201938.R;
import com.bwie.zhaoguangjin201938.model.bean.Bean;

import java.util.List;

/**
 * @Auther: zh
 * @Date: 2019/3/8 14:40
 * @Description: :${赵光金}
 */
public class ZAdapter extends RecyclerView.Adapter<ZAdapter.VVH> {
    Context context;
    List<Bean.DataBean.ListBean> list;
    LayoutInflater layoutInflater;

    public ZAdapter(Context context, List<Bean.DataBean.ListBean> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ZAdapter.VVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.zadapter, viewGroup, false);
        VVH vvh = new VVH(view);
        return vvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ZAdapter.VVH vvh, final int i) {
        vvh.zchecked.setChecked(list.get(i).isChecked());
        vvh.zjiage.setText("￥" + list.get(i).getPrice());
        vvh.ztext.setText(list.get(i).getSubhead());
        Glide.with(context).load(list.get(i).getImages()).into(vvh.zimg);
        vvh.shuliang.setText(list.get(i).getNum());
        vvh.jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = list.get(i).getNum();
                int i1 = Integer.parseInt(num);

                i1++;
                list.get(i).setNum(i1 + "");
                String num1 = list.get(i).getNum();
                vvh.shuliang.setText(num1);

                notifyDataSetChanged();
            }
        });
        vvh.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = list.get(i).getNum();
                int i1 = Integer.parseInt(num);
                if (i1 >= 1) {
                    i1--;
                    list.get(i).setNum(i1 + "");
                    String num1 = list.get(i).getNum();
                    vvh.shuliang.setText(num1);
                }
                notifyDataSetChanged();
            }
        });
        vvh.zchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                boolean checked = checkBox.isChecked();
                list.get(i).setChecked(checked);
                boolean zchecked = zchecked();
                fbox.setChecked(zchecked);
                notifyDataSetChanged();

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VVH extends RecyclerView.ViewHolder {

        private final CheckBox zchecked;
        private final ImageView zimg;
        private final TextView zjiage;
        private final TextView ztext;
        private final Button jia;
        private final Button jian;
        private final TextView shuliang;

        public VVH(@NonNull View itemView) {
            super(itemView);
            zchecked = itemView.findViewById(R.id.zchecked);
            zimg = itemView.findViewById(R.id.zimg);
            zjiage = itemView.findViewById(R.id.zjiage);
            ztext = itemView.findViewById(R.id.ztext);
            jia = itemView.findViewById(R.id.jia);
            jian = itemView.findViewById(R.id.jian);
            shuliang = itemView.findViewById(R.id.shuliang);

        }
    }

    private CheckBox box;


    public void setFbox(final CheckBox fbox) {
        this.box = fbox;

    }

    private CheckBox fbox;
    private List<Bean.DataBean> beans;

    public void setZbox(CheckBox zbox, List<Bean.DataBean> beans1) {
        this.fbox = zbox;
        this.beans = beans1;

    }

    private boolean zchecked() {
        for (int i = 0; i < list.size(); i++) {
            boolean checked = list.get(i).isChecked();
            if (!checked) {
                return false;
            }
        }
        return true;
    }

    private TextView textView;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
