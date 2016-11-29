package jjtelechea.netmind.com.dataadaptermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_recycler_view); //Para las listas el otro

       // final ListView mListView = (ListView) findViewById(R.id.list_view_main);


        String[] mListValues = {"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};

        String[] mListImages = {"androidicon", "iphoneicon", "windowsmobileicon",
                "blackberryicon", "webosicon", "ubuntuicon", "win7icon", "macosxicon",
                "linuxicon", "os2icon", "ubuntuicon", "win7icon", "macosxicon", "linuxicon",
                "os2icon", "ubuntuicon", "win7icon", "macosxicon", "linuxicon", "os2icon",
                "androidicon", "iphoneicon", "windowsmobileicon"};

        /* //EL por defecto
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mListValues));
        */
        //mListView.setOnItemClickListener(this);
        List<Item> listItem = new ArrayList<>();
        String aString = "A body describing the element in the list";
        for (int i = 0; i <mListValues.length; i++) {
            listItem.add(new Item(mListValues[i],aString,mListImages[i]));
        }

        /* //El personalizado
        MyListAdapter adapter =  new MyListAdapter(this,0, listItem);
        mListView.setAdapter(adapter);
        */

        //El recyclerview
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false));
        recyclerView.setAdapter(new MyListAdapterRecycler(this,listItem));


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Element " + position + ",with ID = " + id,Toast.LENGTH_SHORT).show();
    }
}
