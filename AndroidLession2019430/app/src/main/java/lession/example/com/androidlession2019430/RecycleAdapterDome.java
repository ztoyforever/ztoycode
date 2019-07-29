package lession.example.com.androidlession2019430;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecycleAdapterDome extends RecyclerView.Adapter<RecycleAdapterDome.ViewHolder> {
    private View inflater;
    private Context context;
    private List<String> list;
    public RecycleAdapterDome(Context context, List<String> list ){
        this.context = context;
        this.list = list;
    }
    //声明view 和 holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item_dome, viewGroup,false);
        ViewHolder holder = new ViewHolder(inflater);
        return holder;
    }
    //给Xml赋值
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtView.setText(list.get(i));
    }
    //一共有多少个item
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = (TextView) itemView.findViewById(R.id.txt_view);
        }
    }
}
