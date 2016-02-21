TP SIR - M1 MIAGE
Nicolas Gigou / Quentin Lagadec

Cr�ation d'un r�seau social sur la consommation d'�nergie d'une maison

// Objets
    - ElectronicDevice
    - Heater
    - Home
    - Person

    Nous avons suivi le sch�ma du TP pour faire les liaisons entre les objets

Utilisation des annotations pour relier les objets � la Base de donn�es (JPA)

Ajout d'une premiere couche de service GET / POST avec les servlet (dossier servlet)
    - /HomeInfo/ElectronicDevicesInfo  : GET : retourne un appareil
                                         POST : ajoute un appareil en base
    - /HomeInfo/HeaterInfo :    GET : retourne un chauffage
                                POST : ajoute un chauffage en base
    - /HomeInfo : GET : retourne une maison
                  POST : ajoute une maison en base
    - /UserInfo :    GET : retourne une personne
                     POST : ajoute une personne en base

    myformadd.html permet d'acc�der aux formulaires d'ajout.


Ajout d'une couche de webservice avec la librairie javax.ws.rs
Test d'une fontion simple de webservice
    - /ws/home/{id} retourne une maison
    - /home ajoute une maison pr�d�finie