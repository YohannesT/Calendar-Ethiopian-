package tamru.yohannes.ethiopiancalendar.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import tamru.yohannes.ethiopiancalendar.models.EthiopianYear;

/**
 * Created by Yohannes Tamru on 12/19/13.
 */
public class EthiopianCalendarBuilder {

    public List<EthiopianYear> MakeCalander(int startYear, int endYear)
    {
        HashSet<EthiopianYear> ethiopianYears = new HashSet<EthiopianYear>();
        for(int i = startYear; i < endYear + 1; i++)
        {
            ethiopianYears.add(new EthiopianYear(i));
        }

        List<EthiopianYear> years = new ArrayList<EthiopianYear>();
        years.addAll(ethiopianYears);
       return years;
    }

    public EthiopianYear MakeCalanderYear(int ethiopianYear)
    {
        return new EthiopianYear(ethiopianYear);
    }
}
