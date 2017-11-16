package com.os.operando.emptyactivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Contact CON = contacts.get(position);
        holder.store_img.setImageResource(CON.getImage_id());
        holder.store_address.setText(CON.getAddress());
        holder.store_phone.setText(CON.getPhone());
        holder.store_hours.setText(CON.getHours());
    }

    @Override
    public int getItemCount() {

        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView store_img;
        TextView store_address, store_phone, store_hours;

        public ContactViewHolder(View view) {
            super(view);
            store_img = (ImageView) view.findViewById(R.id.store_image);
            store_address = (TextView) view.findViewById(R.id.store_address);
            store_phone = (TextView) view.findViewById(R.id.store_phone);
            store_hours = (TextView) view.findViewById(R.id.store_hours);
        }
    }
}
