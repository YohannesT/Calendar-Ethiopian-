package tamru.yohannes.ethiopiancalendar.activities.widgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Date;

import tamru.yohannes.ethiopiancalendar.R;
import tamru.yohannes.ethiopiancalendar.models.EthiopianDate;

/**
 * Implementation of App Widget functionality.
 */
public class TodayWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_today);
        EthiopianDate ethiopianDate = new EthiopianDate(new Date());

        for (int i=0; i<N; i++) {
            views.setTextViewText(R.id.txtWidgetToday, ethiopianDate.ToLongEthiopianDateString());
            appWidgetManager.updateAppWidget(appWidgetIds[i], views);
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

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_today);
        EthiopianDate ethiopianDate = new EthiopianDate(new Date());
        views.setTextViewText(R.id.txtWidgetToday, ethiopianDate.ToLongEthiopianDateString());

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}


