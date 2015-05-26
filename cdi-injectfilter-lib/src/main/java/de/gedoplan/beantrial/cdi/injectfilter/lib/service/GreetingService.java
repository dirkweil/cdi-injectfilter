package de.gedoplan.beantrial.cdi.injectfilter.lib.service;

import de.gedoplan.beantrial.cdi.injectfilter.lib.LibraryService;
import de.gedoplan.beantrial.cdi.injectfilter.lib.service.spi.PartOfDayService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService
{
  @Inject
  @LibraryService
  PartOfDayService partOfDayService;

  public String getGreeting()
  {
    switch (this.partOfDayService.getPartOfDay())
    {
    case MORNING:
      return "Guten Morgen";

    case AFTERNOON:
      return "Guten Tag";

    default:
      return "Guten Abend";
    }
  }
}
