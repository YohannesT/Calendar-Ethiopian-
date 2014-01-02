package tamru.yohannes.ethiopiancalendar.activities.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Date;

import tamru.yohannes.ethiopiancalendar.R;
import tamru.yohannes.ethiopiancalendar.adapter.MonthViewAdapter;
import tamru.yohannes.ethiopiancalendar.models.EthiopianDate;
import tamru.yohannes.ethiopiancalendar.models.EthiopianMonth;

/**
 * Implementation of App Widget functionality.
 */
public class CalendarWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_calendar);

        EthiopianDate ethiopianDate = new EthiopianDate(new Date());
        EthiopianMonth month = new EthiopianMonth(ethiopianDate.GetMonth(), ethiopianDate.GetYear());

        views.setTextViewText(R.id.txtCalendarWidgetToday, ethiopianDate.ToLongEthiopianDateString());
        MonthViewAdapter adapter = new MonthViewAdapter(context, month);
        //GridView grid = (GridView) views. R.id.txtCalendarWidgetToday;
        //monthView.setAdapter(adapter);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}


