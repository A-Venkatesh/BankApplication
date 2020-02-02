package in.venkateshalive.bankapplication;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class AllBank extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contacts> list = new ArrayList<Contacts>();
    int[] image_id = { R.drawable.andhra_bank,
            R.drawable.axis_bank,
            R.drawable.bandhan_bank_logo,
            R.drawable.bank_of_baroda,
            R.drawable.bank_of_india,
            R.drawable.bankofmaharashtra,
            R.drawable.bnb,
            R.drawable.canara_bank,
            R.drawable.catholic_syrian,
            R.drawable.central_bank_of_india_logo,
            R.drawable.cityunion,
            R.drawable.corporation_bank_logo,
            R.drawable.dcb,
            R.drawable.dena_bank_logo,
            R.drawable.dhanalaxmi,
            R.drawable.federal_bank,
            R.drawable.hdfc_logo,
            R.drawable.icici_bank_logo,
            R.drawable.idbi,
            R.drawable.idfc,
            R.drawable.indian_bank_logo,
            R.drawable.iob,
            R.drawable.indusind_bank,
            R.drawable.jamuandkash,
            };
    String[] name,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bank);

        name = getResources().getStringArray(R.array.person_name);
        mobile = getResources().getStringArray(R.array.person_mobile);
        int count = 0;
        for(String Name : name)
        {
            Contacts contacts = new Contacts(image_id[count],Name,mobile[count]);
            count ++;
            list.add(contacts);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ContactAdapter(list,this);
        recyclerView.setAdapter(adapter);




    }
}
