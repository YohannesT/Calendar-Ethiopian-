package tamru.yohannes.ethiopiancalendar.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;

import tamru.yohannes.ethiopiancalendar.R;
import tamru.yohannes.ethiopiancalendar.models.EthiopianDate;
import tamru.yohannes.ethiopiancalendar.models.EthiopianMonth;
import tamru.yohannes.ethiopiancalendar.adapter.MonthViewAdapter;

public class Calendar extends Fragment implements View.OnClickListener {
    GridView monthView;
    MonthViewAdapter adapter;
    EthiopianMonth month;
    ImageButton btnPerviousYear, btnPrevious, btnNext, btnNextYear;
    TextView txtNice, txtMonthYear;

    View view;

    public static Calendar newInstance(String param1, String param2) {
        Calendar fragment = new Calendar();
        return fragment;
    }

    public Calendar() { } // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);
        txtNice = (TextView)view.findViewById(R.id.txtNiceDate);
        txtMonthYear = (TextView)view.findViewById(R.id.txtMonthYear);

        btnPerviousYear = (ImageButton) view.findViewById(R.id.btnFirst);
        btnPrevious = (ImageButton) view.findViewById(R.id.btnPrevious);
        btnNext = (ImageButton) view.findViewById(R.id.btnNext);
        btnNextYear = (ImageButton) view.findViewById(R.id.btnLast);

        btnPerviousYear.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnNextYear.setOnClickListener(this);

        monthView = (GridView) view.findViewById(R.id.MonthView);
        EthiopianDate ethiopianDate = new EthiopianDate(new Date());
        month = new EthiopianMonth(ethiopianDate.GetMonth(), ethiopianDate.GetYear());
        adapter = new MonthViewAdapter(view.getContext(), month);
        monthView.setAdapter(adapter);

        txtMonthYear.setText(month.GetMonthName() + ", " + month.GetYear());
        txtNice.setText(ethiopianDate.ToLongEthiopianDateString());

        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EthiopianDate ethiopianDate = (EthiopianDate)parent.getItemAtPosition(position);
                txtNice.setText(ethiopianDate.ToLongEthiopianDateString());
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == btnNext)
        {
            month = month.NextMonth();
            adapter = new MonthViewAdapter(this.view.getContext(), month);
            monthView.setAdapter(adapter);
            txtMonthYear.setText(month.GetMonthName() + ", " + month.GetYear());
            txtNice.setText(month.GetMonthName() + ", " + month.GetYear());
        }
        else if(v == btnPrevious)
        {
            month = month.PreviousMonth();
            adapter = new MonthViewAdapter(this.view.getContext(), month);
            monthView.setAdapter(adapter);
            txtMonthYear.setText(month.GetMonthName() + ", " + month.GetYear());
            txtNice.setText(month.GetMonthName() + ", " + month.GetYear());
        }
        else if(v == btnPerviousYear)
        {
            month = month.PreviousYear();
            adapter = new MonthViewAdapter(this.view.getContext(), month);
            monthView.setAdapter(adapter);
            txtMonthYear.setText(month.GetMonthName() + ", " + month.GetYear());
            txtNice.setText(month.GetMonthName() + ", " + month.GetYear());
        }
        else if(v == btnNextYear)
        {
            month = month.NextYear();
            adapter = new MonthViewAdapter(this.view.getContext(), month);
            monthView.setAdapter(adapter);
            txtMonthYear.setText(month.GetMonthName() + ", " + month.GetYear());
            txtNice.setText(month.GetMonthName() + ", " + month.GetYear());
        }
    }
}
