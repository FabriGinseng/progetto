# Documentazione
## Introduzione
L’applicazione è stata pensata per eseguire principalmente le seguenti funzioni:
1.	Permettere all’utente di esercitarsi sulle domande ad esso assegnate;
2.	Controllare i propri risultati.

## Struttura
La struttura dell’applicativo è molto semplice, essa chiede all’utente di autenticarsi prima di poter usufruire dei servizi.
Se il login avviene con successo esso avrà la possibilità di vedere le proprie Statistiche e di accedere ai propri concorsi o piani formativi extra.
Un utente potrà usufruire dell’app su un massimo di 3 dispositivi, e non potrà autenticarsi contemporaneamente su due dispositivi diversi.

## Login
L’utente all’apertura dell’applicativo si troverà in una schermata di Login, dove potrà inserire i suoi dati per accedere al servizio.
I dati di accesso saranno composti da un username (codice Fiscale) e una password personale.
Dopo aver inserito i propri dati di accesso basterà premere il tasto entra e partirà in automatico l’invio dei dati al server per controllare la correttezza degli stessi. L’utente potrà notare che tale processo è in corso grazie ad una barra circolare che indica il caricamento.

<p align="center">
  <img src="https://user-images.githubusercontent.com/28861456/30808727-84683698-a1ff-11e7-8925-dd54e8d2ec14.png">
</p>
In più per facilitare all’utente l’inserimento dei dati l’applicativo salverà l’ultimo username inserito ed in più sarà possibile premendo l’icona dell’occhio vedere la password che si sta inserendo.
Al momento del login l’utente sarà registrato sul data-base come loggato e non potrà effettuare l’accesso su altri dispositivi nello stesso momento.
Se per qualche errore improvviso l’utente non dovesse effettuare il log-out non potrà rilegare solo se effettua l’accesso dal ultimo dispositivo utilizzato.
