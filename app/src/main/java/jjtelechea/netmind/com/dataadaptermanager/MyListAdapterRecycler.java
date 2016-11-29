package jjtelechea.netmind.com.dataadaptermanager;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


class MyListAdapterRecycler extends RecyclerView.Adapter<MyListAdapterRecycler.ViewHolder> {

    private Context mContext;
    private List<Item> mItemList;

    MyListAdapterRecycler(Context context, List<Item> listItem) {
        this.mContext = context;
        this.mItemList = listItem;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitleTextView;
        TextView mBodyTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.imageViewList);
            mTitleTextView = (TextView) itemView.findViewById(R.id.textViewTiltle);
            mBodyTextView = (TextView) itemView.findViewById(R.id.textViewBody);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewRow = LayoutInflater.from(this.mContext)
                .inflate(R.layout.list_view_custom_layout,parent,false);

        viewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        ViewHolder viewRowHolder = new ViewHolder(viewRow);
        return viewRowHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(this.mContext.getResources()
        .getIdentifier(this.mItemList.get(position).getmImage(), "drawable",this.mContext.getPackageName()));
        holder.mTitleTextView.setText(this.mItemList.get(position).getmTitle());
        holder.mBodyTextView.setText(this.mItemList.get(position).getmBody());
    }

    @Override
    public int getItemCount() {
        return this.mItemList.size();
    }

}
