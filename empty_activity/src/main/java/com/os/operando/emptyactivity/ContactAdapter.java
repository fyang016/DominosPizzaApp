package com.os.operando.emptyactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// PLEASE READ: I was basically following a YouTube tutorial to the tee. This is actually for the Store List.

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    Context ctx;

    public ContactAdapter(ArrayList<Contact> contacts, Context ctx) {
        this.contacts = contacts;
        this.ctx = ctx;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view, ctx, contacts);
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

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView store_img;
        TextView store_address, store_phone, store_hours;
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Context ctx;

        public ContactViewHolder(View view, Context ctx, ArrayList<Contact> contacts) {
            super(view);
            this.contacts = contacts;
            this.ctx = ctx;
            view.setOnClickListener(this);
            store_img = (ImageView) view.findViewById(R.id.store_image);
            store_address = (TextView) view.findViewById(R.id.store_address);
            store_phone = (TextView) view.findViewById(R.id.store_phone);
            store_hours = (TextView) view.findViewById(R.id.store_hours);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Contact contact = this.contacts.get(position);
            Intent intent = new Intent(ctx,StoreDetails.class);
            // add the information before going into the activity
            intent.putExtra("img_id",contact.getImage_id());
            intent.putExtra("address",contact.getAddress());
            intent.putExtra("phone", contact.getPhone());
            intent.putExtra("hours", contact.getHours());
            // new passStrings code
            intent.putExtra("passStrings", contact.getPassStrings());
            this.ctx.startActivity(intent);
        }
    }
}
