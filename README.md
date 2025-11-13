# Progetto-OOP (UniME)

Applicazione client/server per la gestione e la vendita di strumenti musicali (progetto didattico).
Progetto sviluppato in Java da Trimarchi Giuseppe e Lombardo Eleonora.

## Contenuto del repository
- File di configurazione: [server.xml](server.xml), [client.xml](client.xml)
- Build: [Progetto-OOP/pom.xml](Progetto-OOP/pom.xml)
- Codice server: [`UniME.ServerSide.Server`](Progetto-OOP/src/main/java/UniME/ServerSide/Server.java), [`UniME.ServerSide.GestoreClient`](Progetto-OOP/src/main/java/UniME/ServerSide/GestoreClient.java), [`UniME.ServerSide.PostgreSQLManager`](Progetto-OOP/src/main/java/UniME/ServerSide/PostgreSQLManager.java)
- Codice client: [`UniME.ClientSide.Client`](Progetto-OOP/src/main/java/UniME/ClientSide/Client.java)
- Utilità condivise: [`UniME.Shared.Utils`](Progetto-OOP/src/main/java/UniME/Shared/Utils.java), [`UniME.Shared.Strumento`](Progetto-OOP/src/main/java/UniME/Shared/Strumento.java) e sottoclassi

## Requisiti
- JDK 11+ installato
- Maven
- PostgreSQL (se si vuole usare il DB reale)
