package com.yaroslav.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.yaroslav.fragment.EXTRA_NAME";
    public static final String EXTRA_SURNAME1 = "com.yaroslav.fragment.EXTRA_SURNAME1";
    public static final String EXTRA_SURNAME2 = "com.yaroslav.fragment.EXTRA_SURNAME2";
    public static final String EXTRA_BIRTH = "com.yaroslav.fragment.EXTRA_BIRTH";
    public static final String EXTRA_COMPANY = "com.yaroslav.fragment.EXTRA_COMPANY";
    public static final String EXTRA_EMAIL = "com.yaroslav.fragment.EXTRA_EMAIL";
    public static final String EXTRA_PHONE1 = "com.yaroslav.fragment.EXTRA_PHONE1";
    public static final String EXTRA_PHONE2 = "com.yaroslav.fragment.EXTRA_PHONE2";
    public static final String EXTRA_ADDRESS = "com.yaroslav.fragment.EXTRA_ADDRESS";


    public DetalleActivity() {
        super(R.layout.activity_detalle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            String nameContact = getIntent().getStringExtra(EXTRA_NAME);
            String surname1Contact = getIntent().getStringExtra(EXTRA_SURNAME1);
            String surname2Contact = getIntent().getStringExtra(EXTRA_SURNAME2);
            String birthContact = getIntent().getStringExtra(EXTRA_BIRTH);
            String companyContact = getIntent().getStringExtra(EXTRA_COMPANY);
            String emailContact = getIntent().getStringExtra(EXTRA_EMAIL);
            String phone1Contact = getIntent().getStringExtra(EXTRA_PHONE1);
            String phone2Contact = getIntent().getStringExtra(EXTRA_PHONE2);
            String addressContact = getIntent().getStringExtra(EXTRA_ADDRESS);
            Bundle bundle = new Bundle();
            bundle.putString(FragmentDetalle.NAME_CONTACT, nameContact);
            bundle.putString(FragmentDetalle.SURNAME1_CONTACT, surname1Contact);
            bundle.putString(FragmentDetalle.SURNAME2_CONTACT, surname2Contact);
            bundle.putString(FragmentDetalle.BIRTH_CONTACT, birthContact);
            bundle.putString(FragmentDetalle.COMPANY_CONTACT, companyContact);
            bundle.putString(FragmentDetalle.EMAIL_CONTACT, emailContact);
            bundle.putString(FragmentDetalle.PHONE1_CONTACT, phone1Contact);
            bundle.putString(FragmentDetalle.PHONE2_CONTACT, phone2Contact);
            bundle.putString(FragmentDetalle.ADDRESS_CONTACT, addressContact);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.FrgDetalle, FragmentDetalle.class, bundle)
                    .commit();
        }
    }
}
