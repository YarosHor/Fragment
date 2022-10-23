package com.yaroslav.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class FragmentListado extends Fragment {
    private Contact[] data;
    private IContactListener listener;

    public FragmentListado() {
        super(R.layout.fragment_listado);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Parse parse = new Parse();
        data = parse.parse(getContext(), "contacts.json");
        System.out.println(data);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lstListado = view.findViewById(R.id.LstListado);
        lstListado.setAdapter(new AdapterContacts(this, data));
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if(listener!=null) {
                    listener.onSelectedContact((Contact) adapterView.getItemAtPosition(pos));
                }
            }
        });
    }

    public Contact[] getDatas() {
        if(data == null){
            Parse parse = new Parse();
            data = parse.parse(getContext(), "contacts.json");
            System.out.println(data);
        }
        return data;
    }

    public void setContactsListener(IContactListener listener) {
        this.listener = listener;
    }
}

