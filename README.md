# jackson-resolver

Demo-Projekt zum Blog Beitrag auf:

`https://javaeeblog.wordpress.com/`

> JAX-RS macht das Erstellen von Webservices leicht. Innerhalb von Minuten ist die Businesslogik und JPA Entitäten über REST im JSON Format verfügbar. Aber Moment! LazyLoadException? Circular Dependencies? Schnell stellen wir fest das unsere komplexen JPA Entitäten eben nicht out of the box in ein JSON Format übertragen werden können wenn Relationen und Bidirektionale Verbindungen im Spiel sind. Die Verarbeitung solche Relationen ist dann oftmals mühsam und mit viel manuellen Aufwand verbunden wenn der Umweg über DTOs gegangen wird. Jackson (JSON Parser, Standardimplementierung z.B. im Wildfly) biete hier eine interessante Möglichkeit: JsonIdentityInfo mit eigenem Resolver.

## Run

Die Anwendung verwendet **Wildfly Swarm** und **Swagger**

run:

> mvn wildfly-swarm:run

open:

> http://localhost:8080/

_by GEDOPLAN, [Dominik Mathmann](https://github.com/dominikmathmann)_
