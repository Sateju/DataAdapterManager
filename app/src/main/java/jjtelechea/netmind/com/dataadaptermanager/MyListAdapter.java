package jjtelechea.netmind.com.dataadaptermanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyListAdapter extends ArrayAdapter<Item> {

    Context mContext;
    List<Item> itemList;

    public MyListAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.itemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);

        if (convertView == null){
            //O bien
            //LayoutInflater inflater =
            // (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_custom_layout,parent,false);
        }

        TextView tVTitle = (TextView) convertView.findViewById(R.id.textViewTiltle);
        TextView tVBody = (TextView) convertView.findViewById(R.id.textViewBody);
        ImageView iVList = (ImageView) convertView.findViewById(R.id.imageViewList);

        tVTitle.setText(item.getmTitle());
        tVBody.setText(item.getmBody());
        //iVList.setImageDrawable(item.getmImage());

        return convertView; //super.getView(position, convertView, parent);
    }
}
