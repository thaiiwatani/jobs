-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2017 at 04:26 AM
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
(3, '', 3, '', 0, '', '', '', NULL, NULL);

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
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
