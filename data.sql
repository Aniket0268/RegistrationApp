
//SQL QUERIES TO INSERT DATA INTO COUNTRY_MASTER
Insert Into COUNTRY_MASTER (COUNTRY_ID, COUNTRY_NAME) Values(1,'India');
Insert Into COUNTRY_MASTER (COUNTRY_ID, COUNTRY_NAME) Values(2,'USA');

//SQL QUERIES TO INSERT DATA INTO STATE_MASTER
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(1,1,'Madhya Pradesh');
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(2,1,'MAHARASHTRA');
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(3,2,'New Jersy');
insert into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) values(4,2,'Ohio');

//SQL QUERIES TO INSERT DATA INTO CITY_MASTER
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(1,'BHOPAL',1);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(2,'INDORE',1);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(3,'PUNE',2);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(4,'MUMBAI',2);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(5,'Maywood',3);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(6,'Westwood',3);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(7,'Oakwood',4);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(8,'Cuyahoga County',4);