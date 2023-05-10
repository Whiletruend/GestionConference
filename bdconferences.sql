-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 24 avr. 2023 à 07:06
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdconferences`
--
CREATE DATABASE IF NOT EXISTS `bdconferences` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdconferences`;

-- --------------------------------------------------------

--
-- Structure de la table `conference`
--

CREATE TABLE `conference` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `lieu` varchar(50) DEFAULT NULL,
  `annee` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `is_online` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `conference`
--

INSERT INTO `conference` (`id`, `nom`, `lieu`, `annee`, `url`, `password`, `is_online`) VALUES
(4, 'MDLA', 'online', 2023, 'https://mdla2023-online.zoom.us/546823', '546823', 1),
(5, 'LPDP', 'Paris', 2023, NULL, NULL, 0),
(6, 'LPPA', 'online', 2023, 'https://lppa2023-online.zoom.us/5987452', '5987452', 1),
(7, 'PDDI', 'Berlin', 2023, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `presentation`
--

CREATE TABLE `presentation` (
  `id` int(11) NOT NULL,
  `auteurs` varchar(255) DEFAULT NULL,
  `titreArticle` varchar(255) DEFAULT NULL,
  `mois` int(11) DEFAULT NULL,
  `jour` int(11) DEFAULT NULL,
  `heure` varchar(10) DEFAULT NULL,
  `id_session` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `presentation`
--

INSERT INTO `presentation` (`id`, `auteurs`, `titreArticle`, `mois`, `jour`, `heure`, `id_session`) VALUES
(10, 'Benjamin', 'Comment fonctionne l\'arithmétique, en 1h', 10, 31, '8', 6),
(11, 'Benjamin', 'Comment a-t\'il été créé ?', 10, 31, '8', 7),
(12, 'Ewen', 'Quelles sont les possibilités avec ce langage ?', 10, 31, '9', 7),
(13, 'Ewen', 'D\'où viennent ces problèmes ?', 10, 31, '8', 9),
(14, 'Ewen', 'Quelles sont les potentielles solutions ?', 10, 31, '9', 9),
(15, 'Benjamin', 'Depuis 1970', 10, 31, '8', 10),
(16, 'Benjamin', 'Les nouvelles en 2023 ?', 10, 31, '9', 10),
(17, 'Benjamin', 'Comment sont-elles créées ?', 12, 14, '8', 11),
(18, 'Benjamin', 'A quoi elle sert ?', 12, 14, '9', 11),
(19, 'Ewen', 'Pourquoi et comment les protéger ?', 12, 14, '8', 12),
(20, 'Ewen', 'Les organismes qui nous protègent', 12, 14, '9', 12);

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `specialite` varchar(50) DEFAULT NULL,
  `jour` int(11) DEFAULT NULL,
  `mois` int(11) DEFAULT NULL,
  `id_conference` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `session`
--

INSERT INTO `session` (`id`, `specialite`, `jour`, `mois`, `id_conference`) VALUES
(6, 'Le monde de l\'arithmétique', 31, 10, 4),
(7, 'Qu\'est-ce que le langage python ?', 31, 10, 5),
(8, 'Le language python - avancé', 31, 10, 5),
(9, 'Les problèmes du pôle Arctique', 31, 10, 6),
(10, 'L\'origine de ces problèmes', 31, 10, 6),
(11, 'Qu\'est-ce qu\'une donnée ?', 14, 12, 7),
(12, 'Pourquoi les protéger ?', 14, 12, 7);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `conference`
--
ALTER TABLE `conference`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `presentation`
--
ALTER TABLE `presentation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `presentation_session_id_fk` (`id_session`);

--
-- Index pour la table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `session_conference_id_fk` (`id_conference`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `conference`
--
ALTER TABLE `conference`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `presentation`
--
ALTER TABLE `presentation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `presentation`
--
ALTER TABLE `presentation`
  ADD CONSTRAINT `presentation_session_id_fk` FOREIGN KEY (`id_session`) REFERENCES `session` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_conference_id_fk` FOREIGN KEY (`id_conference`) REFERENCES `conference` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
