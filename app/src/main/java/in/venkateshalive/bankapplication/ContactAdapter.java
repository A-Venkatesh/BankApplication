package in.venkateshalive.bankapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ANBU on 3/19/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contacts> contactses = new ArrayList<Contacts>();
    Context ctx;
    public ContactAdapter(ArrayList<Contacts> contactses,Context ctx){
        this.contactses = contactses;
        this.ctx = ctx;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(v,ctx,contactses);
        return  contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Contacts con = contactses.get(position);
        holder.person_image.setImageResource(con.getImage_id());
        holder.person_name.setText(con.getName());
        holder.person_mobile.setText(con.getMobile());

       // Picasso.with(person_image.getContext()).load(con.getImage_id())



    }

    @Override
    public int getItemCount() {

        return contactses.size();
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView person_image;
        TextView person_name,person_mobile;
        ArrayList<Contacts> contactses = new ArrayList<Contacts>();
        Context ctx;
        public ContactViewHolder(View v,Context ctx,ArrayList<Contacts>contactses)
        {
            super(v);
            this.ctx = ctx;
            this.contactses = contactses;
            v.setOnClickListener(this);
            person_image = (ImageView)v.findViewById(R.id.pro_pic);
            person_name = (TextView)v.findViewById(R.id.contact_name);
            person_mobile = (TextView)v.findViewById(R.id.phone_no_tv);




        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Contacts contacts = this.contactses.get(position);
            Intent intent = new Intent(ctx,ContactDetailes.class);
            intent.putExtra("img_id",contacts.getImage_id());
            intent.putExtra("name",contacts.getName());
            this.ctx.startActivity(intent);

        }
    }
}
