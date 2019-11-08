-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 08, 2019 at 02:39 AM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `reminderdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `reminder`
--

CREATE TABLE IF NOT EXISTS `reminder` (
  `rid` text,
  `rdate` text,
  `rdescription` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reminder`
--

INSERT INTO `reminder` (`rid`, `rdate`, `rdescription`) VALUES
('1', '1/1/2019', 'Going home'),
('2', '10/09/2019', 'Movie'),
('3', '15/09/2019', 'Birthday'),
('4', '10/09/20', 'avss'),
('5', '10/11/19', 'Movie'),
('6', '08/11/19', 'Birthday amma'),
('7', '12/11/19', 'Exam');
