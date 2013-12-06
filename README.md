ReservationSericeREST
=====================

Exercice : On veut développer un service RESTful ReservationServiceREST permettant la gestion des réservations de salles de cours. 
Ce service doit permettre : 
• de lister l’ensemble des réservations de salles pour une date et/ou heure précises, par type  de cours, à partir d’une certaine date, … ; 

• de lister l’ensemble des salles disponibles à une date et/ou heure précises ; • de réserver une salle pour une date et heure précises ; 

• d’annuler une réservation ; 

• de modifier une réservation (mise à jour de la date et/ou l’heure de réservation, mise à jour  du type de cours). Une réservation contient les informations suivantes : • Un numéro de réservation : de type entier 

• Une petite description : de type texte ; • Une date : de type string au format 23032012 pour la date 23/03/2012 ; • Une heure : de type string au format 0800 pour 08h00 ; 

• Une durée : de type double au format 1.5 heures ; 

• Un nom de salle : de type string ; • Un type de cours : de type énumération (CM|TD|TP|Examen).
