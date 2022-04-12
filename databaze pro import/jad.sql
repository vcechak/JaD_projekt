-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Pát 22. dub 2022, 09:33
-- Verze serveru: 10.4.24-MariaDB
-- Verze PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `jad`
--
CREATE DATABASE IF NOT EXISTS `jad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_czech_ci;
USE `jad`;

-- --------------------------------------------------------

--
-- Struktura tabulky `hero`
--

CREATE TABLE `hero` (
  `hero_id` int(11) NOT NULL,
  `agility` int(11) NOT NULL,
  `charisma` int(11) NOT NULL,
  `endurance` int(11) NOT NULL,
  `hero_class` varchar(55) COLLATE utf8mb4_czech_ci NOT NULL,
  `hero_name` varchar(55) COLLATE utf8mb4_czech_ci NOT NULL,
  `intelligence` int(11) NOT NULL,
  `strength` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `weapons` varchar(500) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  `wisdom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `hero`
--

INSERT INTO `hero` (`hero_id`, `agility`, `charisma`, `endurance`, `hero_class`, `hero_name`, `intelligence`, `strength`, `user_id`, `weapons`, `wisdom`) VALUES
(1, 12, 10, 12, 'Bojovník', 'Vlkan', 8, 16, 3, 'Obouruční meč +2, 1k8', 12),
(2, 10, 8, 16, 'Mág', 'Pesan', 16, 10, 6, 'Mágova hůl, +3 ohnivé zranění 1k10', 14),
(3, 16, 10, 12, 'Poutník', 'Kojot', 14, 12, 4, 'Dýky 1k8, +2 zákeřné zranění', 12),
(4, 10, 12, 10, 'Druid', 'Kakoš', 14, 10, 4, 'Srp +2', 16),
(5, 14, 12, 14, 'Alchymista', 'Pakoš', 12, 16, 3, 'Obouruční meč +2\r\nPaladinův štít +2', 10);

-- --------------------------------------------------------

--
-- Struktura tabulky `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_czech_ci NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `roles`
--

INSERT INTO `roles` (`role_id`, `name`, `id`) VALUES
(1, 'ADMIN', 0),
(2, 'PLAYER', 0),
(3, 'DUNGEONMASTER', 0);

-- --------------------------------------------------------

--
-- Struktura tabulky `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(55) COLLATE utf8mb4_czech_ci NOT NULL,
  `password` varchar(64) COLLATE utf8mb4_czech_ci NOT NULL,
  `nick` varchar(45) COLLATE utf8mb4_czech_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `users`
--

INSERT INTO `users` (`user_id`, `email`, `password`, `nick`, `enabled`) VALUES
(3, 'player@na.com', '$2a$10$NlzwvlWZF.Mjw/HPJoOtk.ZQgIgGF0wKirzfXe2U1t2uQiyVuhNiS', 'player', 1),
(4, 'dm@na.com', '$2a$10$Lvyqd9ZCur4U1M6wk.YQnu8zfJp5fD/XFUVS1c7XGTr0nc4kDHmHq', 'dungeonmaster', 1),
(5, 'admin@na.com', '$2a$10$DZVjk5keA.BXUoz3jyy2vuu6Cfv9EkOUC2XNisJiOsKVjApIZpjVq', 'admin', 1),
(11, 'pokemon@na.com', '$2a$10$wtgFFzBkftzPMcrufAUjgunjM9YSVhjGKOdjRBvj9M/V93utaCq.O', 'pokemon', 1);

-- --------------------------------------------------------

--
-- Struktura tabulky `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(3, 2),
(4, 3),
(5, 1),
(11, 2),
(11, 3);

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `hero`
--
ALTER TABLE `hero`
  ADD PRIMARY KEY (`hero_id`);

--
-- Indexy pro tabulku `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexy pro tabulku `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `nick` (`nick`);

--
-- Indexy pro tabulku `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `user_fk_idx` (`user_id`),
  ADD KEY `role_fk_idx` (`role_id`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `hero`
--
ALTER TABLE `hero`
  MODIFY `hero_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pro tabulku `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pro tabulku `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
