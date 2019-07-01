-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Jun-2019 às 23:22
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `up_eventos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE IF NOT EXISTS `evento` (
`id` int(10) unsigned NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `valor_entrada` decimal(5,2) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `faixa_etaria` tinyint(3) unsigned DEFAULT NULL,
  `horario_abertura` time DEFAULT NULL,
  `horario_fechamento` time DEFAULT NULL,
  `desc_evento` mediumtext,
  `tags` mediumtext
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `evento`
--

INSERT INTO `evento` (`id`, `nome`, `valor_entrada`, `data`, `faixa_etaria`, `horario_abertura`, `horario_fechamento`, `desc_evento`, `tags`) VALUES
(3, 'BERGAMOTEANDO DE INVERNO', '15.00', '2019-07-05', 8, '08:00:00', '18:00:00', 'Propriedades rurais com programação temática relacionada a bergamota, a mais famosa fruta do inverno gaúcho, com colheita, degustação e venda de citros e hortaliças de época.', 'comer,beber'),
(4, 'CAMPEONATO MUNICIPAL DE FUTSAL 2019 - INTERIOR (4° DISTRITO)', '10.00', '2019-07-27', 8, '13:00:00', '18:00:00', 'Envolver atletas do interior de nosso município, proporcionando momentos de lazer e diversão, difundindo a prática do esporte por meio da integração dos seus atletas. ', 'esporte,jogar,campeonato'),
(5, 'FESTIVAL NACIONAL DE PEIXES E FRUTOS DO MAR', '10.00', '2019-07-28', 18, '10:00:00', '17:00:00', 'Um dos maiores eventos a nível nacional com shows nacionais, regionais, locais, feiras, e festa gastronômica', 'peixes,comer,comida'),
(6, 'Eight times Ballroom Dancing - POA', '20.00', '2019-07-29', 18, '16:00:00', '23:00:00', 'Lugar para beber, dançar com os amigos', 'dançar,beber,comer'),
(7, 'Aquece Copa América:', '90.00', '2019-07-18', 18, '15:00:00', '22:00:00', 'Uma oportunidade única de visitar um espaço cervejeiro, conhecer seu processo industrial e degustar seus produtos. Uma experiência completa em um lugar alto astral!', 'beber,comer,esporte,jogar'),
(9, 'Deus me livre, mas quem me dera! :: OPEN BAR :: 03.07 :: @Margot', '50.00', '2019-07-31', 18, '14:00:00', '23:00:00', 'Aquela CLÁSSICA noitezinha de open bar, luzinhas, neons, pistas fervendo, glitter e gente linda ?chega mais uma DEUS ME LIVRE MAS QUEM ME DERA!\n', 'beber,comer,dançar');

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento_tema`
--

CREATE TABLE IF NOT EXISTS `evento_tema` (
`id` int(10) unsigned NOT NULL,
  `id_evento` int(10) unsigned DEFAULT NULL,
  `bebida_alcoolica` tinyint(1) DEFAULT NULL,
  `pista_danca` tinyint(1) DEFAULT NULL,
  `estilo_musical` varchar(100) DEFAULT NULL,
  `tipo_comida` varchar(200) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `evento_tema`
--

INSERT INTO `evento_tema` (`id`, `id_evento`, `bebida_alcoolica`, `pista_danca`, `estilo_musical`, `tipo_comida`) VALUES
(3, 3, 0, 0, 'Nenhum', 'Variada'),
(4, 4, 0, 0, 'Nenhum', 'Nenhum'),
(5, 5, 1, 0, 'Variado', 'Variada'),
(6, 6, 1, 1, 'Sertanejo', 'Variada'),
(7, 7, 1, 0, 'Variado', 'Variada'),
(9, 9, 1, 1, 'Pop', 'Variada');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `evento`
--
ALTER TABLE `evento`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `evento_tema`
--
ALTER TABLE `evento_tema`
 ADD PRIMARY KEY (`id`), ADD KEY `id_evento` (`id_evento`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `evento`
--
ALTER TABLE `evento`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `evento_tema`
--
ALTER TABLE `evento_tema`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `evento_tema`
--
ALTER TABLE `evento_tema`
ADD CONSTRAINT `evento_tema_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
