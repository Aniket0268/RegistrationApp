

Insert Into COUNTRY_MASTER (COUNTRY_ID, COUNTRY_NAME) Values(1,'India');
Insert Into COUNTRY_MASTER (COUNTRY_ID, COUNTRY_NAME) Values(2,'USA');


Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(1,1,'Madhya Pradesh');
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(2,1,'Maharashtra');
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(3,2,'New Jersy');
insert into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) values(4,2,'Ohio');


Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(1,'Indore',1);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(2,'Bhopal',1);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(3,'pune',2);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(4,'mumbai',2);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(5,'Maywood',3);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(6,'Westwood',3);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(7,'Oakwood',4);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(8,'Cuyahoga County',4);