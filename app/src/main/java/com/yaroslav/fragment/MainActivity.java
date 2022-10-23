package com.yaroslav.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;


public class MainActivity extends AppCompatActivity implements IContactListener, FragmentOnAttachListener {
    private FragmentDetalle frgDetail;
    private boolean tabletLayout;

    public MainActivity() {
        super(R.layout.activity_main);
        frgDetail = null;
        tabletLayout = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabletLayout = findViewById(R.id.FrgDetalle) != null;

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.FrgListado, FragmentListado.class, null)
                .commit();
        manager.addFragmentOnAttachListener(this);
    }

    @Override
    public void onSelectedContact(Contact c) {
        //If is tablet
        if(tabletLayout) {
            frgDetail.showDetail(c.getName(), c.getSurname1(), c.getSurname2(), c.getBirth(), c.getCompany(), c.getEmail(), c.getPhone1(), c.getPhone2(), c.adress);
        }
        //If is phone
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_NAME, c.getName());
            i.putExtra(DetalleActivity.EXTRA_SURNAME1, c.getSurname1());
            i.putExtra(DetalleActivity.EXTRA_SURNAME2, c.getSurname2());
            i.putExtra(DetalleActivity.EXTRA_BIRTH, c.getBirth());
            i.putExtra(DetalleActivity.EXTRA_COMPANY, c.getCompany());
            i.putExtra(DetalleActivity.EXTRA_EMAIL, c.getEmail());
            i.putExtra(DetalleActivity.EXTRA_PHONE1, c.getPhone1());
            i.putExtra(DetalleActivity.EXTRA_PHONE2, c.getPhone2());
            i.putExtra(DetalleActivity.EXTRA_ADDRESS, c.getAdress());
            startActivity(i);
        }
    }

    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if(fragment.getId() == R.id.FrgListado) {
            FragmentListado fragmentListado = (FragmentListado) fragment;
            fragmentListado.setContactsListener(this);
            if(tabletLayout) {
                Bundle bundle = new Bundle();
                bundle.putString(FragmentDetalle.NAME_CONTACT, fragmentListado.getDatas()[0].getName());
                bundle.putString(FragmentDetalle.SURNAME1_CONTACT, fragmentListado.getDatas()[0].getSurname1());
                bundle.putString(FragmentDetalle.SURNAME2_CONTACT, fragmentListado.getDatas()[0].getSurname2());
                bundle.putString(FragmentDetalle.BIRTH_CONTACT, fragmentListado.getDatas()[0].getBirth());
                bundle.putString(FragmentDetalle.COMPANY_CONTACT, fragmentListado.getDatas()[0].getCompany());
                bundle.putString(FragmentDetalle.EMAIL_CONTACT, fragmentListado.getDatas()[0].getEmail());
                bundle.putString(FragmentDetalle.PHONE1_CONTACT, fragmentListado.getDatas()[0].getPhone1());
                bundle.putString(FragmentDetalle.PHONE2_CONTACT, fragmentListado.getDatas()[0].getPhone2());
                bundle.putString(FragmentDetalle.ADDRESS_CONTACT, fragmentListado.getDatas()[0].getAdress());

                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.FrgDetalle, FragmentDetalle.class, bundle)
                        .commit();
            }
        }
        if(fragment.getId() == R.id.FrgDetalle) {
            frgDetail = (FragmentDetalle) fragment;
        }
    }
}
