-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2018 at 06:52 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop1_b13`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `userId` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `phone_no` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`userId`, `userName`, `mail`, `phone_no`) VALUES
('c001', 'Anisha', 'anisha@gmail.com', 1234567689),
('c002', 'Tarin', 'tarin@gmail.com', 1234567898),
('c003', 'Kallol', 'kalllol@gmail.com', 1324567893),
('c004', 'Shatil', 's@gmail.com', 8807879),
('c009', 'tr', 't@gmail.com', 880598654);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `userId` varchar(15) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `phone_no` varchar(17) NOT NULL,
  `role` varchar(10) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`userId`, `userName`, `phone_no`, `role`, `salary`) VALUES
('e001', 'Boiragi', '01797732626', 'Manager', 20000.00),
('e002', 'Tasnim', '01624818535', 'Employee', 12000.00),
('e008', 'e', '+880444', 'Employee', 3400.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userid` varchar(30) NOT NULL,
  `password` varchar(19) NOT NULL,
  `status` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userid`, `password`, `status`) VALUES
('c001', 'a123', '1'),
('c002', 't123', '1'),
('c003', 'k0987', '1'),
('c004', '123', '1'),
('e001', 'e123', '0'),
('e002', 'e3456', '2'),
('e005', '57595506', '0'),
('e008', '63284267', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
