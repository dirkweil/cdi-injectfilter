package de.gedoplan.beantrial.cdi.injectfilter.web.presentation;

import de.gedoplan.beantrial.cdi.injectfilter.lib.LibraryService;
import de.gedoplan.beantrial.cdi.injectfilter.lib.service.GreetingService;
import de.gedoplan.beantrial.cdi.injectfilter.lib.service.spi.PartOfDayService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ServicePresenter
{
  @Inject
  GreetingService greetingService;

  public String getHelloWorld()
  {
    return this.greetingService.getGreeting() + ", dies ist \"Hello, world\" auf CDI-Basis.";
  }

  /*
   * Die folgende Injektion ist nicht erlaubt und sollte zum Deployment-Abbruch führen
   */
  @Inject
  @LibraryService
  PartOfDayService partOfDayService;

}
