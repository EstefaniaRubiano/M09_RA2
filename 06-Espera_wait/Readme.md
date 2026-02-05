# Preguntes pràctica

## Per què s'atura l'execució al cap d'un temps?
El programa no s'atura, segueix executant-se però els fils estan en wait() esperant places o fent accions que no generen missatges visibles. Per això sembla "parat" a la consola.

## Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30% (cancel·lar)? I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos

### 70% ferReserva i 30% cancel·lar

**codi modificat:**
```java
@Override
    public void run() {
        while (true) {
            try {
                if (Math.random() < 0.7) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep((int) (Math.random() * 1000));
                
            } catch (InterruptedException e) {
                break;  
            }
        }
    }
```
**Sortida esperada**: L'esdeveniment estarà gairebé sempre complet. Poques cancel·lacions així que les places s'alliberaràn lentament.

```
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-9 ha fet una reserva. Places disponibles: 4
Assistent-8 ha fet una reserva. Places disponibles: 3
Assistent-7 ha fet una reserva. Places disponibles: 2
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 ha fet una reserva. Places disponibles: 1
Assistent-4 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0       
Assistent-9 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0       
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
```

### 30% ferReserva i 70% cancel·lar

**codi modificat:**
```java
@Override
    public void run() {
        while (true) {
            try {
                if (Math.random() < 0.3) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep((int) (Math.random() * 1000));
                
            } catch (InterruptedException e) {
                break;  
            }
        }
    }
```
**Sortida esperada**: Les places s'ocuparàn lentament i haurà molts intents de cancel·lar sense reserva.
```
Assistent-9 ha fet una reserva. Places disponibles: 4
Assistent-8 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-7 ha fet una reserva. Places disponibles: 3
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 ha fet una reserva. Places disponibles: 2
Assistent-7 ha cancel·lat una reserva. Places disponibles: 3
Assistent-4 ha fet una reserva. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-4 ha cancel·lat una reserva. Places disponibles: 3
Assistent-5 ha fet una reserva. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha cancel·lat una reserva. Places disponibles: 2
Assistent-5 ha cancel·lat una reserva. Places disponibles: 3
Assistent-7 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-7 ha fet una reserva. Places disponibles: 2
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-4 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogur cancel·lar una reserva inexistent. Places disponibles: 0
```

## Per què calen llistes en lloc d'una simple variable sencera?
La llista és necessària per identificar exactament QUI té reserva i així poder verificar les operacions (evitar cancel·lacions de qui no té reserva i evitar reserves duplicades). Un comptador només ens diu quantes, no qui.