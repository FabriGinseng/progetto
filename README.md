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

## Home-Page
Una volta effettuato il login con successo l’utente si troverà nella Home-Page, qui saranno presenti tutti i dati inerenti ad “Amoroso Concorsi”:
-	Indirizzo
-	Telefono
-	Mobile
-	E-Mail
-	Pagina Facebook
-	Mappa posizione
<p align="center">
  <img src="https://user-images.githubusercontent.com/28861456/30808983-79d9380c-a200-11e7-9404-aa875f988032.png">
</p>

Si può notare subito in alto la barra di navigazione, dove si potrà navigare fra le pagine, l’utente avrà anche la possibilità di spostarsi fa le stesse tramite un semplice swap da sinistra verso destra o viceversa.

## Piani-Formativi
Andando nella schermata dei piani formativi si potranno vedere tutti piani formativi assegnati, con la seguente formattazione:
- Titolo: Nome del concorso a cui appartiene il piano, se sarà un piano extra questo avrà come titolo “extra”
-	Descrizione: Qui sarà presente il nome del piano alla quale si fa riferimento
Per selezionare il piano all’utente basterà effettuare un tap sul piano scelto(si sposterà nella scheda “set domande disponibili”).

<p align="center">
  <img width="400" height="640" src="https://user-images.githubusercontent.com/28861456/30809103-e48526c0-a200-11e7-9f55-8e09a9056b61.png">
</p>
Il caricamento dei piani viene effettuato al momento del Login, quindi l’utente non potrà visualizzare eventuali aggiornamenti finché non effettuerà un log-out.

## Set domande disponibili
All’apertura di tale finestra si potranno vedere tutti i set di domande disponibili per quel piano didattico.
Si può notare fin da subito una variazione nella grafica poiché scomparirà la barra di navigazione e al suo posto sarà presente un bottone situato in alto a sinistra che consentirà di tornare alle schermate principali.
I vari set di domande si presenteranno in questo modo:
-	Titolo: nome del set
-	Descrizione: sarà presente la descrizione del set di domande
La scelta del set risulta molto semplice poiché basterà cliccare sul set desiderato (verremmo spostati nella finestra “Modalità”).
<p align="center">
  <img width="400" height="640" src="https://user-images.githubusercontent.com/28861456/30809171-305ee068-a201-11e7-9170-a6fcbd3adea2.png">
</p>

## Modalità
Qui potremmo scegliere la modalità, fra quelle disponibili:
-	Dispensa
-	Apprendimento
-	Simulazione assistita
-	Simulazione

<p align="center">
  <img width="400" height="640" src="https://user-images.githubusercontent.com/28861456/30809259-6d1b5310-a201-11e7-95b8-a53dc52efb93.png">
</p>

Al click su di una modalità comparirà una breve descrizione della stessa e il pulsante per avviarla.

## Dispensa
Qui l’utente potrà visualizzare tutte le domande facenti parte del set, sarà possibile visualizzare la risposta esatta.
Non ci saranno limiti di tempo e potrà scorrere tutte le domande andando avanti e indietro coi bottoni.
La dispensa si chiuderà in automatico non appena si supererà l’ultima domanda o premendo il bottone back situato in alto a sinistra.
<p>
  <img align="left" width="400" height="640" src="https://user-images.githubusercontent.com/28861456/30809456-0ef76282-a202-11e7-9ff0-38eac2e0cb04.png">

  <img align ="right" width="400" height="640" src="https://user-images.githubusercontent.com/28861456/30809590-8c63cbd4-a202-11e7-8e77-9f77ca812a98.png">
</p>
