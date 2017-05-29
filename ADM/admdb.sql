-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2017 at 08:22 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `admdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `finished`
--

CREATE TABLE IF NOT EXISTS `finished` (
`finishID` int(11) NOT NULL,
  `finishLocation` varchar(500) NOT NULL,
  `finishName` varchar(200) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `finished`
--

INSERT INTO `finished` (`finishID`, `finishLocation`, `finishName`) VALUES
(1, 'C:\\Users\\user\\Desktop\\', 'ronaldu.jpg'),
(3, 'C:\\Users\\user\\Desktop\\', 'Real-Madrid-CR7-Hairstyles-Collection-2016-2017.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `queue`
--

CREATE TABLE IF NOT EXISTS `queue` (
`queueID` int(11) NOT NULL,
  `queueLink` varchar(500) NOT NULL,
  `queueLocation` varchar(500) NOT NULL,
  `queueName` varchar(500) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `queue`
--

INSERT INTO `queue` (`queueID`, `queueLink`, `queueLocation`, `queueName`) VALUES
(2, 'http://storinka.com.ua/wp-content/uploads/2016/08/krishtianu-ronaldu.jpg', 'C:\\Users\\user\\Desktop', 'ronaldu.jpg'),
(3, 'http://menshairstylesweb.com/wp-content/uploads/2016/01/Real-Madrid-CR7-Hairstyles-Collection-2016-2017.jpg', 'C:\\Users\\user\\Desktop', 'Real-Madrid-CR7-Hairstyles-Collection-2016-2017.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `savelocation`
--

CREATE TABLE IF NOT EXISTS `savelocation` (
`LocationID` int(11) NOT NULL,
  `LocationPath` varchar(600) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `savelocation`
--

INSERT INTO `savelocation` (`LocationID`, `LocationPath`) VALUES
(1, 'C:\\Users\\user\\Desktop');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `finished`
--
ALTER TABLE `finished`
 ADD PRIMARY KEY (`finishID`);

--
-- Indexes for table `queue`
--
ALTER TABLE `queue`
 ADD PRIMARY KEY (`queueID`);

--
-- Indexes for table `savelocation`
--
ALTER TABLE `savelocation`
 ADD PRIMARY KEY (`LocationID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `finished`
--
ALTER TABLE `finished`
MODIFY `finishID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `queue`
--
ALTER TABLE `queue`
MODIFY `queueID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `savelocation`
--
ALTER TABLE `savelocation`
MODIFY `LocationID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
