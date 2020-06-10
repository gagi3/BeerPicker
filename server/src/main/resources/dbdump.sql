-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: beerpicker
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `beer`
--

LOCK TABLES `beer` WRITE;
/*!40000 ALTER TABLE `beer` DISABLE KEYS */;
INSERT INTO `beer` VALUES (1,'Jelen Pivo',4.5,'PILSNER','LAGER'),(2,'Lav Pivo',4.5,'PILSNER','LAGER'),(3,'Old Speckled Hen',5.2,'PALE','ALE'),(4,'La Messagere Gluten Free',5,'AMBER','ALE'),(5,'Palm Amber Ale',5.2,'AMBER','ALE'),(6,'Smithwicks Ale',5,'AMBER','ALE'),(7,'Alexander Keiths Red',5,'AMBER','ALE'),(8,'Amsterdam Big Wheel',5,'AMBER','ALE'),(9,'Camerons Ambear Red Ale',5,'AMBER','ALE'),(10,'Unibroue La Fin Du Monde',9,'BLONDE','ALE'),(11,'Molson Export',5,'BLONDE','ALE'),(12,'Griffon',5,'BLONDE','ALE'),(13,'Leffe Blonde',6.6,'BLONDE','ALE'),(14,'Grimbergen Blonde',6.6,'BLONDE','ALE'),(15,'Mill St Stock Ale',5,'BLONDE','ALE'),(16,'Molson Stock Ale',5,'BLONDE','ALE'),(17,'Red Cap Ale',5,'BLONDE','ALE'),(18,'Amsterdam Downtown Brown',5,'BROWN','ALE'),(19,'Big Rock Traditional Ale',5,'BROWN','ALE'),(20,'Big Rock Warthog Ale',4.5,'BROWN','ALE'),(21,'Black Oak Nut Brown Ale',5,'BROWN','ALE'),(22,'Newcastle Brown Ale',4.7,'BROWN','ALE'),(23,'Leffe Brune',6.5,'BROWN','ALE'),(24,'Grimbergen Double Ambree',6.5,'BROWN','ALE'),(25,'Grimbergen Brassin De Noel',6.5,'BROWN','ALE'),(26,'Grimbergen Triple DAbbaye',8,'BLONDE','ALE'),(27,'Grimbergen Belgian Pale Ale',5.5,'BLONDE','ALE'),(28,'Grimbergen Rouge',6,'RED','ALE'),(29,'Grimbergen Blanche',6,'WHEAT','ALE'),(30,'Boddingtons Blanche',6,'CREAM','ALE'),(31,'Boddingtons Pub Ale',4.8,'CREAM','ALE'),(32,'Camerons Cosmic Cream Ale',5,'CREAM','ALE'),(33,'Kilkenny Cream Ale',4.3,'CREAM','ALE'),(34,'Muskoka Cream Ale',5,'CREAM','ALE'),(35,'Sleeman Cream Ale',5,'CREAM','ALE'),(36,'True North Cream Ale',5,'CREAM','ALE'),(37,'Hockley Dark Ale',5,'DARK','ALE'),(38,'Stonehammer Dark Ale',5,'DARK','ALE'),(39,'Upper Canada Dark Ale',5,'DARK','ALE'),(40,'Wellington County Brown Ale',5,'DARK','ALE'),(41,'Erdinger Dunkel Weissbier',5.6,'DARK','ALE'),(42,'Rickerds Red',5.2,'RED','ALE'),(43,'Sleeman Rousse Dark',5.5,'DARK','ALE'),(44,'Fruli Strawberry Beer',4.1,'FRUIT','ALE'),(45,'St Ambroise Apricot Wheat',5,'FRUIT','ALE'),(46,'Lakeport Honey Lager',5,'HONEY','LAGER'),(47,'PC Honey Red',5,'HONEY','LAGER'),(48,'Amsterdam Boneshaker IPA',7.1,'IPA','ALE'),(49,'Dead Elephant IPA',6.5,'IPA','ALE'),(50,'Double Drooling Dog Black IPA',6.4,'IPA','ALE'),(51,'Goose Island IPA',5.9,'IPA','ALE'),(52,'Muskoka Mad Tom IPA',6.4,'IPA','ALE'),(53,'True North Inukshuk IPA',6.5,'IPA','ALE'),(54,'Sleeman India Pale Ale',5.3,'IPA','ALE'),(55,'Okanagan Spring Pale Ale',5,'PALE','ALE'),(56,'St Ambroise Pale Ale',5,'PALE','ALE'),(57,'Moosehead Pale Ale',5,'PALE','ALE'),(58,'Black Oak Pale Ale',5,'PALE','ALE'),(59,'Labatt 50 Ale',5,'PALE','ALE'),(60,'Maclays',5,'PALE','ALE'),(61,'Wellington Spa',4.5,'PALE','ALE'),(62,'Laker Strong',6.5,'STRONG','LAGER'),(63,'Maximum Ice',7.1,'STRONG','LAGER'),(64,'Molson XXX',7.3,'STRONG','LAGER'),(65,'Olde English 800',8,'STRONG','LAGER'),(66,'Faxe Extra Strong - 10',10,'STRONG','LAGER'),(67,'Faxe Royal Strong',8,'STRONG','LAGER'),(68,'Crest Super',10,'STRONG','LAGER'),(69,'Big Rock Grasshopper Kristallweizen',5,'WHEAT','ALE'),(70,'Kronenbourg 1664 Blanc',5,'WHEAT','ALE'),(71,'Hoegaarden',5,'WHEAT','ALE'),(72,'Hacker-Pschorr Hefe Weiss',5.5,'WHEAT','ALE'),(73,'Erdinger Weissbier',5.3,'WHEAT','ALE'),(74,'Belhaven Black Scot Stout',4.2,'DARK','STOUT'),(75,'Black Creek Porter',5,'DARK','STOUT'),(76,'Calabogies Brown Cow Nitro Stout',5.5,'DARK','STOUT'),(77,'Dragon Stout',7.5,'DARK','STOUT'),(78,'Guinness Drought',4.2,'CREAM','STOUT'),(79,'Guinness Pub Draught',4.2,'CREAM','STOUT'),(80,'Guinness Extra Stout',4.2,'DARK','STOUT'),(81,'Kingsville Barrel Aged Stout',6.7,'DARK','STOUT'),(82,'Beaus Tom Green Beer',5,'CREAM','STOUT'),(83,'Beaus Tom Green Cherry Milk Stout',5,'DARK','STOUT'),(84,'Lake Of Bays Twilight Hour Coffee Stout',5.5,'DARK','STOUT'),(85,'Mackeson Stout',4.9,'CREAM','STOUT'),(86,'Midnight Stout Oatmeal Milk Stout',4.5,'CREAM','STOUT'),(87,'Mill St Vanilla Porter',5,'CREAM','STOUT'),(88,'Mill Streat Cobblestone Stout',4.2,'DARK','STOUT'),(89,'Murphys Irish Stout',4.1,'DARK','STOUT'),(90,'Oharas Irish Stout',4.3,'DARK','STOUT'),(91,'Simple Man Oatmeal Stout',6.1,'DARK','STOUT'),(92,'Sleeman Fine Porter',5.5,'DARK','STOUT'),(93,'Sleeping Giant Skull Rock Stout',5.1,'DARK','STOUT'),(94,'St Ambrose Oatmeal Stout',5,'DARK','STOUT'),(95,'Stonehammer Oatmeal Coffee',5,'CREAM','STOUT'),(96,'Walkerville Easy Stout',5.5,'CREAM','STOUT'),(97,'Wellington Imperial Russian Stout',8,'DARK','STOUT'),(98,'Bitburger',4.8,'PILSNER','LAGER'),(99,'Kozel',4.6,'PILSNER','LAGER'),(100,'Stella Artois',5,'PILSNER','LAGER');
/*!40000 ALTER TABLE `beer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `beer_flavours`
--

LOCK TABLES `beer_flavours` WRITE;
/*!40000 ALTER TABLE `beer_flavours` DISABLE KEYS */;
INSERT INTO `beer_flavours` VALUES (1,'OATS'),(1,'BARLEY'),(2,'OATS'),(2,'BARLEY'),(4,'FRUIT'),(4,'WOOD'),(5,'HONEY'),(9,'CARAMEL'),(9,'CITRUS'),(10,'HERBS'),(11,'MALT'),(13,'CLOVES'),(14,'CLOVES'),(15,'MALT'),(16,'MALT'),(18,'CHOCOLATE'),(19,'CARAMEL'),(19,'MALT'),(19,'NUTS'),(20,'TOFFEE'),(21,'CHOCOLATE'),(22,'FRUIT'),(23,'FRUIT'),(23,'APPLE'),(24,'CARAMEL'),(24,'PLUM'),(24,'MALT'),(25,'FRUIT'),(25,'CARAMEL'),(25,'BANANA'),(25,'APPLE'),(26,'HERBS'),(26,'FRUIT'),(26,'CLOVES'),(27,'CITRUS'),(27,'FRUIT'),(27,'LEMON'),(28,'HERBS'),(28,'FRUIT'),(29,'CITRUS'),(29,'CLOVES'),(29,'FRUIT'),(30,'CITRUS'),(30,'CLOVES'),(30,'FRUIT'),(32,'FRUIT'),(32,'HERBS'),(33,'FRUIT'),(34,'FRUIT'),(34,'GRASS'),(34,'TOFFEE'),(35,'FRUIT'),(36,'FRUIT'),(38,'CHOCOLATE'),(39,'MALT'),(40,'MALT'),(41,'MALT'),(42,'MALT'),(42,'CARAMEL'),(43,'MALT'),(43,'CARAMEL'),(44,'FRUIT'),(45,'FRUIT'),(46,'HONEY'),(47,'HONEY'),(48,'CITRUS'),(51,'CITRUS'),(52,'CITRUS'),(53,'TOFFEE'),(53,'BISCUITS'),(55,'FRUIT'),(56,'FRUIT'),(59,'FRUIT'),(69,'FRUIT'),(69,'BREAD'),(70,'CITRUS'),(71,'FRUIT'),(72,'BANANA'),(72,'CLOVES'),(74,'MALT'),(75,'CHOCOLATE'),(75,'COFFEE'),(75,'BREAD'),(75,'CARAMEL'),(76,'CHOCOLATE'),(77,'MALT'),(79,'BARLEY'),(81,'FRUIT'),(82,'CHOCOLATE'),(82,'COFFEE'),(83,'DRIED_CHERRIES'),(83,'CHOCOLATE'),(83,'COFFEE'),(84,'CARAMEL'),(84,'MALT'),(84,'COFFEE'),(85,'MALT'),(85,'COFFEE'),(86,'OATS'),(87,'VANILLA'),(88,'BARLEY'),(89,'BARLEY'),(89,'MALT'),(90,'BARLEY'),(90,'MALT'),(91,'DRIED_CHERRIES'),(91,'CHOCOLATE'),(91,'COFFEE'),(91,'TOFFEE'),(91,'OATS'),(92,'MALT'),(93,'CHOCOLATE'),(94,'CHOCOLATE'),(94,'COFFEE'),(94,'OATS'),(95,'COFFEE'),(95,'OATS'),(96,'COFFEE'),(96,'CHOCOLATE'),(97,'COFFEE'),(97,'CHOCOLATE');
/*!40000 ALTER TABLE `beer_flavours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dish_descriptors`
--

LOCK TABLES `dish_descriptors` WRITE;
/*!40000 ALTER TABLE `dish_descriptors` DISABLE KEYS */;
/*!40000 ALTER TABLE `dish_descriptors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dish_ingredients`
--

LOCK TABLES `dish_ingredients` WRITE;
/*!40000 ALTER TABLE `dish_ingredients` DISABLE KEYS */;
/*!40000 ALTER TABLE `dish_ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dish_preparation`
--

LOCK TABLES `dish_preparation` WRITE;
/*!40000 ALTER TABLE `dish_preparation` DISABLE KEYS */;
/*!40000 ALTER TABLE `dish_preparation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'burger','MEAT'),(2,'turkey','MEAT'),(3,'brie','CHEESE');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `meal`
--

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `meal_dishes`
--

LOCK TABLES `meal_dishes` WRITE;
/*!40000 ALTER TABLE `meal_dishes` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_dishes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-06 10:08:16
