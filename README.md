# Projet de Graphes (DUT S2)

Ce projet consiste en la réalisation de différentes "IA" pour un jeu de type PacMan. Le langage utilisé est le Java.

## Principe du jeu et des IA

### Principe du jeu

Le jeu comporte deux personnages (contrôlés tous les deux par l’ordinateur) :
* PacMan,
* le fantôme.
Les deux personnages sont enfermés dans un labyrinthe parsemé de pac-gommes (petites boules blanches). L’objectif de PacMan est de manger toutes les pac-gommes sans être attrapé par le fantôme, dont l’objectif est de manger PacMan.

### Principe des IA

Différentes IA ont été implémentées pour les deux joueurs. Toutes les IA mentionnées ci-dessous ont été implémentées indépendamment et sont activables par l’appel d’une fonction dans le main.

#### Déplacement aléatoire pour PacMan

Pour cette IA, PacMan se déplace aléatoirement dans le labyrinthe. Plus précisemment, à chaque intersection, PacMan choisis avec la même probabilité chacune des directions possibles.

#### Principe de la main droite

Pour cette IA, le fantôme se déplace en suivant le mur qui est à sa gauche. À défaut d’un mur sur sa gauche à son départ (uniquement), le fantome se déplacera vers le haut jusqu’à rencontrer un mur sur sa gauche.

#### Traqueur efficace

Pour cette IA, le fantôme se dirige le plus efficacement possible vers PacMan, en sachant que traverser une case de brouillard bloque le fantôme un tour.

#### PacMan efficace

Pour cette IA, à tout moment, PacMan se déplace vers la pac-gomme la plus proche de lui par le plus court chemin.