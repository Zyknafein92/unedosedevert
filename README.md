Projet n°12 pour OpenClassrooms : Une dose de vert

- Licence : License libre
- Auteur : Jérôme Deneux


Description du projet
---------------------

Application web pour une site d'épicerie fine en ligne avec paiement via Stripe.


Pré-requis
----------
Vous devez posséder Java JRE version 8 ou supérieur sur votre machine pour pouvoir correctement utiliser l'application.

Technologies employées
----------------------

Langage :
- Java 8
- TypeScript

Front :
- Angular
- Stripe
- Troast

Back :
- Spring Data
- Spring Web
- Spring Security
- JWT Token
- Send in blue
- Lombok
- Stripe


Base de données :
- PostgreSQL
- RDS PostegreSQL (version en ligne)

Serveur d'application :
- Apache Tomcat v.9


Restaurer la base de données
----------------------------
Ouvrez pgAdmin, et ajoutez une base de donnée nommée epicerie.
Au lancement de l'application, le fichier data.sql présent dans /ressources va automatiquement initier la base de données.
/!\ Vérifiez que le fichier présent dans src/main/ressources/application-dev-properties possède à la ligne spring.jpa.hibernate.ddl-auto la valeur create-drop.


Installation et utilisation de l’application
--------------------------------------------

Installation
------------

- Ouvrez votre IDE, et importez le projet extrait depuis le fichier .zip ou clonez le fichier depuis le repository : https://gitlab.com/deneux.j/unedosedevert
- Importez les fichiers avec Maven.
- Lancez "npm install" dans le terminal si nécessaire afin de charger les éléments du Front.

Démarrez l'application votre IDE (dev mod)
------------------------------------------
-	Lancez « application-dev ».
     - /!\ Si vous devenez définir un environement de déploiement, veuillez saisir le path suivant : -Dspring.config.location=classpath:application-dev.properties
-	Rendez-vous sur http://localhost:4200

