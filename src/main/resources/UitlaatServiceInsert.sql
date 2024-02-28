USE UitlaatService;

INSERT INTO `Klant` VALUES (1,'G','de','Boer','0612345678'),(2,'MJW',NULL,'Willemsen','0611223344'),(3,'A','van','Veen','0623456172'),(4,'J',NULL,'Long','0612131415'),(5,'T',NULL,'Hartman','0656347263');


INSERT INTO `Hond` VALUES ('1','Chipo','Mix',1),('2','Gingy','Mix',1),('3','Fred','Spaniel',4),('4','Woolly','Dobermann',3),('5','Spank','Jack Russell',2);


INSERT INTO `Medewerker` VALUES ('GJ','Gertjan'),('JC','Jacqueline'),('MR','Martin');


INSERT INTO `Wandeling`(chipnr, datum, duur, medewerkercode) VALUES ('1','2016-01-02',2.0,'JC'),('1','2016-01-03',3.0,'GJ'),('1','2016-01-05',2.5,'MR'),('2','2017-01-02',2.0,'JC'),('2','2017-01-03',3.0,'GJ'),('2','2017-01-05',2.5,'MR'),('3','2018-01-03',3.0,'GJ'),('3','2018-01-05',2.5,'MR'),('4','2019-01-03',3.0,'GJ'),('5','2019-01-05',2.5,'MR');
