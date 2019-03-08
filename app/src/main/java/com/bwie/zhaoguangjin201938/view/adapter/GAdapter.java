package com.bwie.zhaoguangjin201938.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.zhaoguangjin201938.R;
import com.bwie.zhaoguangjin201938.model.bean.Bean;

import java.util.List;

/**
 * @Auther: zh
 * @Date: 2019/3/8 14:22
 * @Description: :${赵光金}
 */
public class GAdapter extends RecyclerView.Adapter<GAdapter.VVH> {
    Context context;
    List<Bean.DataBean> beans;
    LayoutInflater layoutInflater;

    public GAdapter(Context context, List<Bean.DataBean> beans) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public GAdapter.VVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.fadapter, viewGroup, false);
        VVH vvh = new VVH(view);
        return vvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final GAdapter.VVH vvh, final int i) {
        vvh.fchecked.setChecked(beans.get(i).isChecked());
        vvh.ftext.setText(beans.get(i).getSellerName());
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        final List<Bean.DataBean.ListBean> list = beans.get(i).getList();
        ZAdapter adapter = new ZAdapter(context, list);

        vvh.recyclerView.setLayoutManager(layoutManager);
        vvh.recyclerView.setAdapter(adapter);
        adapter.setZbox(vvh.fchecked,beans);
        adapter.setFbox(box);
        adapter.setTextView(textView);
        vvh.fchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                boolean checked = checkBox.isChecked();
                beans.get(i).setChecked(checked);
                for (int j = 0; j <list.size() ; j++) {
                    list.get(j).setChecked(checked);
                }
                boolean fchecked = fchecked();
                box.setChecked(fchecked);
                notifyDataSetChanged();
            }
        });
    }

    private boolean fchecked() {
        for (int i = 0; i <beans.size() ; i++) {
            boolean checked = beans.get(i).isChecked();
            if (!checked) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class VVH extends RecyclerView.ViewHolder {

        private final CheckBox fchecked;
        private final TextView ftext;
        private final RecyclerView recyclerView;

        public VVH(@NonNull View itemView) {
            super(itemView);
            fchecked = itemView.findViewById(R.id.fchecked);
            ftext = itemView.findViewById(R.id.ftext);
            recyclerView = itemView.findViewById(R.id.zrecyclerview);
        }
    }
    private CheckBox box;

    public void setBox(CheckBox box) {
        this.box = box;
    }

    private TextView textView;
    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
