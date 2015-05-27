Demo-Projekt: Filterung/Einschränkung der Injektionsmöglichkeiten in CDI

Dieses Projekt demostriert, wie man mit Hilfe einer CDI Extension die Injektionsmöglichkeiten zur
Deploy/Laufzeit einschränken kann.

Das Teilprojekt cdi-injectfilter-web nutzt in seiner Klasse ServicePresenter zwei Injektionen von Klassen aus dem
zweiten Teilprojekt cdi-injectfilter-lib. Dabei wird die Situation gestellt , bei der einige Klassen einer Library 
zur Injektion in andere Anwendungsteile veröffentlicht werden, während der Rest der Library nur innerhalb der 
Library selbst zur Injektion bereit steht.

Im Demoprojekt können Beans, die mit @LibraryService qualifiziert sind, nur innerhalb des Teilprojektes cdi-injectfilter-lib
injiziert werden.

Dies wird durch die Extension InjectFilterExtension zum Deploymentzeitpunkt erzwungen. Dazu werden die Injection Points, die 
eine im obigen Sinne illegale Kombination darstellen, mit einem Definition Error gebannt.
