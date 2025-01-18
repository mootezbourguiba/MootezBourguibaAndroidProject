# MootezBourguibaAndroidProject
# MathExplorer

## Description

MathExplorer est une application Android conçue pour aider les utilisateurs à explorer et à analyser des concepts mathématiques. L'application offre diverses fonctionnalités telles que l'analyse de fonctions, un chatbot éducatif, un quiz mathématique, un historique d'étude et plus encore.

## Fonctionnalités

*   **Analyse de fonctions:**
    *   Saisie flexible de fonctions mathématiques.
    *   Calcul de l'ensemble de définition.
    *   Analyse de la parité.
    *  Analyse de la continuité.
    *   Détermination de la dérivabilité.
    *   Étude des limites.
    *   Recherche d'asymptotes.
    *   Tableau de variations.
    *   Recherche de points particuliers.
    *   Affichage du graphe de la fonction.
*   **Chatbot éducatif:** Un chatbot pour répondre aux questions liées aux mathématiques.
*   **Interface utilisateur intuitive:** Design simple et clair.
*   **Authentification utilisateur :** Connexion et déconnexion de l'application.

## Technologies utilisées

*   **Langage :** Kotlin
*   **IDE :** Android Studio
*   **Bibliothèques :**
    *   `androidx.appcompat:appcompat`
    *   `com.google.android.material:material`
    *   `androidx.constraintlayout:constraintlayout`
    *   `com.jjoe64:graphview` (pour les graphiques)
       *   `net.objecthunter:exp4j` (pour l'analyse des fonctions)

## Structure du projet

Le projet suit une structure standard Android :

*   **`app/src/main/java/tm/esprit/mathexplorer1` :** Contient le code source de votre application (classes Java/Kotlin).
    *   **`adapters/` :** Contient les adapteurs pour les listes `RecyclerView`.
    *   **`model/` :** Contient les classes de données, comme `ChatMessage`.
    *   **`utils/` :**  Contient des classes utilitaires, comme `ExpressionBuilder`.
    *   **`view/` :** Contient les classes d'activités (`Activity`) de l'application.
*   **`app/src/main/res` :** Contient les fichiers ressources de l'application.
    *   **`drawable/` :**  Contient les images et icônes.
    *   **`layout/` :** Contient les fichiers XML des layouts de l'interface utilisateur.
    *   **`values/` :** Contient les fichiers XML des styles, thèmes et couleurs de l'application.

## Installation

1.  **Clonez le repository :**

    ```bash
    git clone https://[lien_vers_votre_repository]
    ```
2.  **Ouvrez le projet avec Android Studio :**

    *   Lancez Android Studio.
    *   Choisissez `Open an existing Android Studio project` et sélectionnez le dossier du projet.
3.  **Construisez et exécutez l'application :**

    *   Dans Android Studio, cliquez sur `Build` > `Make Project`, puis `Run` pour lancer l'application sur un émulateur ou un appareil physique.

## Utilisation

1.  **Authentification :** Lancez l'application, identifiez-vous, ou créez un compte.
2.  **Menu principal :**  Vous arrivez au menu principal, vous y trouverez les différentes options de l'application (analyser les fonctions, chatbot educatif, déconnexion).
3.  **Analyse de fonctions :**
    *   Cliquez sur "Explorer les fonctions".
    *  Entrez l'expression de la fonction dans le champ dédié (ex: `x^2 + 2x - 1`,  `sqrt(x)`, `log(x)`, `1/x`, `x^(1/2)` etc).
    * Sélectionnez les propriétés à étudier.
    *  Cliquez sur "Analyser".
4.  **Chatbot Educatif :**
    *   Cliquez sur "Chatbot Educatif".
    *   Saisissez votre question ou votre message.
    *   Cliquez sur "Envoyer" ou appuyez sur Entrée.
5.   **Déconnexion :**  Cliquez sur  "Se déconnecter" pour quitter votre compte.

## Contributions

Les contributions à ce projet sont les bienvenues ! Voici quelques façons de contribuer :

*   **Remonter des bugs:**  Signalez les bugs et erreurs que vous rencontrez.
*   **Suggérer des améliorations:** Proposez des idées pour améliorer les fonctionnalités existantes ou en ajouter de nouvelles.
*  **Ajouter des tests:** Si vous le souhaitez vous pouvez implémenter des tests pour vous assurer de la bonne stabilité de votre code.
*   **Soumettre des pull requests :** Si vous avez apporté des corrections ou de nouvelles fonctionnalités, soumettez une pull request pour qu'elle puisse être examinée.

N'hésitez pas à fork le repository, à créer des branches pour vos fonctionnalités, et soumettez vos propositions.

## Licence

Ce projet est distribué sous la licence [Choisissez votre licence, par exemple MIT ou Apache 2.0].

## Contact

Si vous avez des questions ou des suggestions, n'hésitez pas à me contacter via GitHub ou à utiliser les issue du projet.
