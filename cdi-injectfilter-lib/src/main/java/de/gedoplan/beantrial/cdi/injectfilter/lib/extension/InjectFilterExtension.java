package de.gedoplan.beantrial.cdi.injectfilter.lib.extension;

import de.gedoplan.beantrial.cdi.injectfilter.lib.LibraryService;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.InjectionException;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.ProcessInjectionPoint;

public class InjectFilterExtension implements Extension
{
  private static final String LIB_PACKAGE_NAME = LibraryService.class.getPackage().getName();

  <T, X> void processInjectionPoint(@Observes ProcessInjectionPoint<T, X> event)
  {
    InjectionPoint injectionPoint = event.getInjectionPoint();
    if (injectionPoint.getAnnotated().getAnnotation(LibraryService.class) != null)
    {
      String targetPackageName = injectionPoint.getMember().getDeclaringClass().getPackage().getName();
      if (targetPackageName.equals(LIB_PACKAGE_NAME))
      {
        return;
      }

      if (targetPackageName.startsWith(LIB_PACKAGE_NAME) && targetPackageName.charAt(LIB_PACKAGE_NAME.length()) == '.')
      {
        return;
      }

      event.addDefinitionError(new InjectionException("@" + LibraryService.class.getName() + " beans may not be injected outside their defining library"));
    }
  }

}
