package tamru.yohannes.ethiopiancalendar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import tamru.yohannes.ethiopiancalendar.models.*;
import tamru.yohannes.ethiopiancalendar.R;

/**
 * Created by Yohannes Tamru on 12/17/13.
 */

public class MonthViewAdapter extends ArrayAdapter<EthiopianDate> {
    Context context;
    List<EthiopianDate> dates;
    EthiopianDate ethiopianDateToday = new EthiopianDate(new Date());

    TextView txtGridItemEuropianDate, txtGridItemEthiopianDate, txtGeezeDate, txtDayOfWeek;
    public MonthViewAdapter(Context context, EthiopianMonth month) {
        super(context, R.layout.grid_cell, month.GetDates());
        this.dates = month.GetDates();
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cell = inflater.inflate(R.layout.grid_cell, parent, false);

         txtGridItemEuropianDate = (TextView) cell.findViewById(R.id.txtGridItemEuropianDate);
         txtGridItemEthiopianDate = (TextView) cell.findViewById(R.id.txtGridItemEthiopianDate);
         txtGeezeDate = (TextView) cell.findViewById(R.id.txtGeezeDate);
         txtDayOfWeek = (TextView)cell.findViewById(R.id.txtDoW);

        EthiopianDate ethiopianDate = dates.get(position);//String.valueOf(ethiopianDate.GetDay())

        txtGridItemEuropianDate.setText(String.valueOf(ethiopianDate.GetGregorianDay()));
        txtGridItemEthiopianDate.setText(String.valueOf(ethiopianDate.GetDay()));
        txtGeezeDate.setText(ethiopianDate.GetGeezeDay());

        if(position < 7)
        {
            String d = ethiopianDate.GetEthiopianDayOfWeek();
            txtDayOfWeek.setText(d.substring(0,1));
        }

        if(ethiopianDate.equals(ethiopianDateToday))
        {
            cell.setBackgroundColor(Color.rgb(100, 150, 200));
            txtGridItemEuropianDate.setTextColor(Color.WHITE );
            txtGridItemEthiopianDate.setTextColor(Color.WHITE );
            txtGeezeDate.setTextColor(Color.WHITE);
        }

        if(ethiopianDate.GetEthiopianDayOfWeek() == "እሁድ")
        {
            txtGridItemEuropianDate.setTextColor(Color.rgb(180, 100, 30) );
            txtGridItemEthiopianDate.setTextColor(Color.rgb(180, 100, 30));
            txtGeezeDate.setTextColor(Color.rgb(180, 100, 30));
        }

        if(position < EthiopianMonth.GetFirstDayOfMonthIndex(dates))
        {
            txtGridItemEuropianDate.setTextColor(Color.GRAY );
            txtGridItemEthiopianDate.setTextColor(Color.GRAY );
            txtGeezeDate.setTextColor(Color.GRAY );
        }

        return cell;
    }

    public EthiopianDate getDateAt(int position)
    {
        return dates.get(position);
    }
}
