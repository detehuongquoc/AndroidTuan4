package com.example.a18077431_nguyenphanhuynhduc_android_tuan4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboveFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int quantity;
    private double donGia;
    private PurchaseProduct purchaseProduct;
    DecimalFormat decimalFormat = new DecimalFormat("#,###.#");
    @Override
    public void onAttach(@NonNull Context context) {

        purchaseProduct = (PurchaseProduct) context;
        super.onAttach(context);
    }

    public AboveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboveFragment newInstance(String param1, String param2) {
        AboveFragment fragment = new AboveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_above, container, false);
        ImageButton imgBtnSub = view.findViewById(R.id.imgBtnSub);
        ImageButton imgBtnPlus = view.findViewById(R.id.imgBtnPlus);
        TextView tvQuantity = view.findViewById(R.id.quantityProduct);
        TextView tvDonGia = view.findViewById(R.id.txtDonGia);
        quantity = Integer.parseInt(tvQuantity.getText().toString());
        String gia = tvDonGia.getText().toString();
        gia = gia.substring(0,gia.length()-2);
        try {
            donGia = decimalFormat.parse(gia).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        imgBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnSub.setEnabled(true);
                quantity++;
                tvQuantity.setText(String.valueOf(quantity));
                purchaseProduct.addProduct(quantity,donGia);
            }
        });
        imgBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvQuantity.getText().toString()) <= 1){
                    imgBtnSub.setEnabled(false);
                }
                else{
                    quantity--;
                    tvQuantity.setText(String.valueOf(quantity));
                    purchaseProduct.subProduct(quantity, donGia);
                }
            }
        });
        return view;
    }
}