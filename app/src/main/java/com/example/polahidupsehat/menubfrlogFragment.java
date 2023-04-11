package com.example.polahidupsehat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menubfrlogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menubfrlogFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button masuk,daftarr;
    private ImageView konsul,mkn,rem,olgaa;
    public menubfrlogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menubfrlogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static menubfrlogFragment newInstance(String param1, String param2) {
        menubfrlogFragment fragment = new menubfrlogFragment();
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
        View view = inflater.inflate(R.layout.fragment_menubfrlog, container, false);

        masuk = view.findViewById(R.id.btnmasuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),login.class);
                startActivity(intent);

            }
        });
        daftarr = view.findViewById(R.id.btndaftar);
        daftarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),daftar.class);
                startActivity(intent);

            }
        });
        konsul = view.findViewById(R.id.konsultasi);
        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("PERINGATAN!!!");
                alert.setMessage("Kamu harus login terlebih dahulu!");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),login.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        });
        mkn = view.findViewById(R.id.polamkn);
        mkn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("PERINGATAN!!!");
                alert.setMessage("Kamu harus login terlebih dahulu!");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),login.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        });
        rem = view.findViewById(R.id.pingat);
        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("PERINGATAN!!!");
                alert.setMessage("Kamu harus login terlebih dahulu!");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),login.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        });
        olgaa = view.findViewById(R.id.olga);
        olgaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("PERINGATAN!!!");
                alert.setMessage("Kamu harus login terlebih dahulu!");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),login.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        });
        return view;


    }
}