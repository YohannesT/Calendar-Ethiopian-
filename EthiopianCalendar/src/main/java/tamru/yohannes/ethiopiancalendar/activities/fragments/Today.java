package tamru.yohannes.ethiopiancalendar.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import tamru.yohannes.ethiopiancalendar.R;
import tamru.yohannes.ethiopiancalendar.models.EthiopianDate;

public class Today extends Fragment {
    private TextView txtEthiopianDateRegular, txtEthiopianDateNice, txtGregorianDate;

    public static Today newInstance(String param1, String param2) {
        Today fragment = new Today();
        return fragment;
    }

    public Today() { } // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);

        txtEthiopianDateNice = (TextView) view.findViewById(R.id.txtEthiopianDateNice);
        txtEthiopianDateRegular = (TextView) view.findViewById(R.id.txtEthopianDate);
        txtGregorianDate = (TextView)view.findViewById(R.id.txtGregoreanDate);

        EthiopianDate ethiopianDate = new EthiopianDate(new Date());
        txtEthiopianDateRegular.setText(ethiopianDate.ToShortEthiopianDateString());
        txtEthiopianDateNice.setText(ethiopianDate.ToLongEthiopianDateString());
        txtGregorianDate.setText(ethiopianDate.ToLongGregorianDateString());
        return view;
    }
}
