package com.example.a18077431_nguyenphanhuynhduc_android_tuan4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BelowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BelowFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int quantity = 1;
    private double donGia = 141800;
    public BelowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BelowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BelowFragment newInstance(int quantity, double donGia) {
        BelowFragment fragment = new BelowFragment();
        Bundle args = new Bundle();
        args.putInt("quantity",quantity);
        args.putDouble("donGia", donGia);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quantity = getArguments().getInt("quantity");
            donGia = getArguments().getDouble("donGia");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_below, container, false);

        TextView taTamTinh = view.findViewById(R.id.txtTamTinh);
        taTamTinh.setText(new DecimalFormat("#,###.#").format(quantity*donGia)+" đ");
        return  view;
    }
}