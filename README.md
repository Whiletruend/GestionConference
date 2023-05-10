<!-- Badges -->
[![Contributors][contributors-badge]][contributors-wlink]
[![Stars][stars-badge]][stars-wlink]
[![License][license-badge]][license-wlink]
[![Version][version-badge]][version-wlink]

<!-- School Logo Header -->
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Logo_esilv_png_blanc.png/600px-Logo_esilv_png_blanc.png" alt="ESILV LOGO" width="100" height="100"> 
<img src="https://cdn.livestorm.co/uploads/organization/avatar/458c155c-0eb6-4400-9aa5-417e61f64b3f/29eb3e3a-7095-4752-8b3a-9a6c3279b09f.png?v=1602173188" alt="POLE DE VINCI LOGO" width="100" height="100">

<!-- Project's Part 01 Header -->
# 👋 **Projet GestionConference**
<div align="center">
    <img src="https://i.ibb.co/s5nzRDx/Java.png" alt="NodeJS Logo" width="100" height="90">
    <img src="https://i.ibb.co/JxCKx9K/XAMPP.png" alt="Sequelize Logo" 
    width="80" height="80"/> 
    <img src="https://i.ibb.co/4f3PvJS/MySQL.png" alt="JWT Logo" width="80" height="80"/> 
</div>

<br>

<!-- Project's Part 01 Body -->
## **Description du projet**
Les participants au projet sont: **Whiletruend** *(Benjamin B.)* ; **Miroshino** *(Ewen B.)*<br><br>
Le projet donné lors de notre deuxième année au sein de l'**ESILV** était de réaliser un cas de "**GestionConference**". Dans ce projet, nous avions pour objectif de produire un système permettant qu'une **Conférence** puisse avoir un nombre X de **Session**, ces Sessions disposaient d'une **spécialité** et d'une **date** *(sous le format JJ/MM)*. Des **présentations** pouvaient alors être créées pour ces différentes sessions, à l'instar de celles-ci, il pouvait donc y avoir un nombre Y de **Présentation** ayant pour attributs les **auteurs**, le **titre de l'article**, une date *(sous format JJ/MM)* ainsi qu'une **heure**.

Le premier objectif donné par cet exercice était de faire un héritage de **Conférence** afin de disposer d'une classe "**ConférenceOnline**" qui devait alors avoir comme attributs supplémentaires une **URL** *(sous le format https://EXEMPLE2023-online.zoom.us/)* et un **mot de passe**.

Le second objectif visé était d'inclure maintenant la **DAO** dans le projet, c'est-à-dire ajouter l'accès à la base de données dans le projet afin d'y effectuer des actions **CRUD** *(**C**reate **R**ead **U**pdate **D**elete)*. Pour cela, 4 classes ont été créées : **Database**, **ConferenceDAO**, **SessionDAO** et **PresentationDAO**, qui disposent chacunes des méthodes associées à leurs objectifs.

Finalement, nous devions faire un "**reporting de fichier**". Depuis le code, nous devions être capable de choisir une conférence que nous souhaitons exporter en fichier sous le format voulu, nous avons personnellement choisi un format simple tel que le **.txt**.

L'ensemble du code devait respecter la norme de documentation appelée **JavaDoc**.

## **Technologies utilisées**
Trois principales technologies seront utilisées pour ce projet, en voici la liste:
- **Java**, en utilisant l'IDE **IntelliJ IDEA Ultimate** ;
- **XAMPP**, nous permettant de disposer d'une base de données locale 
<hr>
<br>

<!-- Install the project Header -->
# 💻 **Comment installer le projet**

<!-- Project's Part 02 Install Body -->
## **Récupération du projet GitHub**
Récupérez ensuite le projet via **GitHub**.
Soit, par téléchargement depuis le site, comme tel: <br>
<img src="https://raw.githubusercontent.com/Mottie/GitHub-userscripts/master/images/github-download-zip.gif" alt="GitHub Installation" width="250" height="300"> <br>

Ou bien en réalisant la commande **git clone**, comme ceci:
````
git clone https://github.com/Whiletruend/GestionConference.git
````

## **Avant l'utilisation du projet**
Avant l'utilisation, vous devez disposer d'une **BDD**, le système de gestion de BDD utilisé lors du projet est **MySQL**. <br>
Cela est possible grâce à **[XAMPP](https://www.apachefriends.org/fr/index.html)** *(disponible sur Windows, Mac et Linux)*,  voir **[MAMP](https://www.apachefriends.org/fr/index.html)** *(disponible sur Windows, Mac et Android 5.0+)*. <br><br>
Si vous disposez de cela, le fichier `bdconferences.sql` disponible dans le dossier racine vous permettra de créer la base de données, les tables ainsi que les insertions <ins>nécessaires</ins> à l'utilisation du projet.<br>

> Il est possible de changer les informations de connexion à la base de données, cela se fera directement dans le fichier `Database.java` disponible dans le package `src.com.rtit.esilv.bin1.esilv.dao`. <br>
> Les lignes qui devront être changées sont celles-ci:
> ````java
> private static final String host_db = "localhost"; // Default: localhost (127.0.0.1)
> private static final String name_db = "bdconferences"; // Default: bdconferences
> private static final String user_db = "root"; // Default: root
> private static final String pass_db = ""; // Default: N/A
> ````
> Comme visible, les commentaires de chaque ligne vous indiquent quelle était la valeur initiale, celle par défaut.

Finalement, il vous faudra intégrer au projet les **drivers JDBC** disponibles à cette adresse : https://dev.mysql.com/downloads/connector/j/. Selon les IDE l'intégration peut être différente, mais vous devrez dans tous les cas ajouter un **.jar** externe correspondant au **mysql-connector** que vous venez de télécharger.

## **Utilisation du projet**
Une fois tout cela prêt, il vous suffira de lancer le projet grâce à votre IDE et l'option "**run**".<br>
Après cela, tout devrait fonctionner. Une fois tout le projet chargé, le texte suivant sera retourné:
````
Que souhaitez-vous faire ? : 
1 - Créer une conférence 
2 - Afficher les conférences 
3 - Effectuer une altération 
4 - Reporter une conférence 
5 - Quitter 
Votre choix :
````
<hr>

<!-- Markdown Badges Variables -->
[contributors-badge]: https://img.shields.io/github/contributors/Whiletruend/GestionConference.svg?style=for-the-badge
[contributors-wlink]: https://github.com/Whiletruend/GestionConference/graphs/contributors

[stars-badge]: https://img.shields.io/github/stars/Whiletruend/GestionConference.svg?style=for-the-badge
[stars-wlink]: https://github.com/Whiletruend/GestionConference/stargazers

[license-badge]: https://img.shields.io/github/license/Whiletruend/GestionConference.svg?style=for-the-badge
[license-wlink]: ttps://github.com/Whiletruend/GestionConference/blob/master/LICENSE.txt

[version-badge]: https://img.shields.io/badge/Version-v1.0.0-green?style=for-the-badge
[version-wlink]: https://github.com/Whiletruend/GestionConference
