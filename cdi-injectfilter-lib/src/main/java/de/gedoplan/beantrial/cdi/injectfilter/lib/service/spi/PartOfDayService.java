package de.gedoplan.beantrial.cdi.injectfilter.lib.service.spi;

import de.gedoplan.beantrial.cdi.injectfilter.lib.LibraryService;

import java.util.Calendar;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@LibraryService
public class PartOfDayService
{
  public PartOfDay getPartOfDay()
  {
    int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    if (hourOfDay < 10)
    {
      return PartOfDay.MORNING;
    }
    else if (hourOfDay < 18)
    {
      return PartOfDay.AFTERNOON;
    }
    else
    {
      return PartOfDay.EVENING;
    }
  }
}
