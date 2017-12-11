-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2017 at 04:43 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jobs`
--

-- --------------------------------------------------------

--
-- Table structure for table `group_jobs`
--

CREATE TABLE `group_jobs` (
  `id` int(6) NOT NULL,
  `GroupName` varchar(30) CHARACTER SET cp932 NOT NULL,
  `memo` varchar(255) CHARACTER SET cp932 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_jobs`
--

INSERT INTO `group_jobs` (`id`, `GroupName`, `memo`) VALUES
(1, 'SE1', 'System en dsfsdfs'),
(2, 'System', 'System en'),
(3, 'Web2', 'System en'),
(5, '開発', '開発'),
(8, '募集', '採用する'),
(9, 'sdgs', 'sdvsd'),
(10, 'sa', 'sdsdsd'),
(11, 'aaaa', 'aaaa'),
(12, 'aaaaaa', 'adsdfsdgsd'),
(14, 'dhdbfd', 'fbdbdbfd'),
(15, 'dfdbddfb', 'dbfdfd'),
(16, 'dfbdfb', 'dfdbdfbd'),
(17, 'dbfdfd', 'fbdfbdfbdfbdfb'),
(18, 'dfbdfbf', 'dbdbs da'),
(19, 'aaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaa'),
(20, 'aaa', 'xzvasd'),
(21, 'asfasc', 'ascascasc'),
(22, 'ascascasc', 'ascascac'),
(23, 'ascasc', 'ascascas'),
(24, 'ascascacsa', 'acacsa'),
(25, 'ascascasasc', 'acsacasca'),
(27, 'aaaaaaaaaaa', 'aaaaa');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `id` int(6) NOT NULL,
  `JobName` varchar(30) CHARACTER SET cp932 NOT NULL,
  `groupid` int(6) NOT NULL,
  `company` varchar(50) CHARACTER SET cp932 DEFAULT NULL,
  `salary` int(11) NOT NULL,
  `link` varchar(50) CHARACTER SET cp932 DEFAULT NULL,
  `image` varchar(255) CHARACTER SET cp932 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET cp932 DEFAULT NULL,
  `Industry` varchar(20) CHARACTER SET cp932 DEFAULT NULL,
  `memo` varchar(255) CHARACTER SET cp932 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `JobName`, `groupid`, `company`, `salary`, `link`, `image`, `address`, `Industry`, `memo`) VALUES
(1, 'a', 1, 'a', 0, 'asdas', 'C:\\Users\\J1637009\\Documents\\新しいタブ.pdf', 'a', NULL, NULL),
(2, 'regd', 1, 'regd', 0, 'dfg', 'C:\\Users\\J1637009\\Documents\\新しいタブ.pdf', 'dfvd', NULL, NULL),
(4, 'a', 1, 'a', 0, 'asfdsafa', 'C:\\Users\\J1637009\\Documents\\新しいタブ.pdf', 'a', NULL, NULL),
(6, 'aaaa', 1, 'aaaa', 0, '1212', 'C:\\Users\\J1637009\\Documents\\新しいタブ.pdf', 'aaaa', NULL, NULL),
(7, 'sadfsd', 1, 'sadfsd', 0, '1２１２１あさ', 'C:\\Users\\J1637009\\Documents\\新しいタブ.pdf', 'sdsdsds', NULL, NULL),
(8, 'TEst2', 1, 'TEst2', 150000, 'iwatani', 'C:\\Users\\J1637009\\Documents\\新しいタブ.pdf', 'yokohama', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `group_jobs`
--
ALTER TABLE `group_jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jobs_ibfk_1` (`groupid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `group_jobs`
--
ALTER TABLE `group_jobs`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `jobs`
--
ALTER TABLE `jobs`
  ADD CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `group_jobs` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
