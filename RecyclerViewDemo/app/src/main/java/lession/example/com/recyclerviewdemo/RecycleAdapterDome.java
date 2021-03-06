package lession.example.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
    /*
    ① 创建Adapter：创建一个继承RecyclerView.Adapter<VH>的Adapter类
    ② 创建ViewHolder：在Adapter中创建一个继承RecyclerView.ViewHolder的静态内部类。
    ③ 在Adapter中实现3个方法：
       onCreateViewHolder()
       onBindViewHolder()
       getItemCount()
    */
public class RecycleAdapterDome extends RecyclerView.Adapter<RecycleAdapterDome.MyViewHolder>{
    private Context context;
    private List<String> list;
    private View inflater;
    //构造方法，传入数据
    public RecycleAdapterDome(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHolder，返回每一项的布局
        inflater = LayoutInflater.from(context).inflate(R.layout.item_dome,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //将数据和控件绑定
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        //返回Item总条数
        return list.size();
    }
    //内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
