package com.yaroslav.fragment;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterContacts extends ArrayAdapter<Contact> {
    private final Context context;
    private final Contact[] data;

    public AdapterContacts(Fragment context, Contact[] data) {
        super(context.requireActivity(), R.layout.listitem_contact, data);
        this.context = context.getActivity();
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.listitem_contact, null);
        TextView tvName = item.findViewById(R.id.tvNameSmall);
        tvName.setText(data[position].getName());
        TextView tvSurname = item.findViewById(R.id.tvSurnameSmall);
        tvSurname.setText(data[position].getSurname1());
        TextView tvPhone = item.findViewById(R.id.tvPhone);
        tvPhone.setText(data[position].getPhone1());
        return item;
    }
}
