create database PSL_Data;
use PSL_Data;

CREATE TABLE Players (
Name VARCHAR(50) NOT NULL,
Team VARCHAR(50) NOT NULL,
Nationality VARCHAR(50) NOT NULL,
Role VARCHAR(50) NOT NULL,
Age VARCHAR(50) NOT NULL,
Player_Rank VARCHAR(50) NOT NULL
);

CREATE TABLE Titles(
	Team VARCHAR(50) NOT NULL,
    Title VARCHAR(50) NOT NULL,
    Year VARCHAR(50) NOT NULL
);


CREATE TABLE Fixtures (
Team1 VARCHAR(50) NOT NULL,
Team2 VARCHAR(50) NOT NULL,
Date VARCHAR(50) NOT NULL,
Time VARCHAR(50) NOT NULL,
Venue VARCHAR(50) NOT NULL
);

CREATE TABLE Points (
Team VARCHAR(50) NOT NULL,
Points VARCHAR(50) NOT NULL
);

SELECT *
FROM Players;

SELECT *
FROM Titles;

SELECT *
FROM Fixtures;

SELECT *
FROM Points;

-- Islamabad United
INSERT INTO players
value("Hassan Ali","Islamabad United","Pakistan","Bowler","27","62");
INSERT INTO players
value("Alex Hales","Islamabad United","England","Batsman","33","21");
INSERT INTO players
value("Shadab Khan","Islamabad United","Pakistan","Bowler","23","9");
INSERT INTO players
value("Paul Stirling","Islamabad United","Ireland","All-Rounder","31","19");
INSERT INTO players
value("Colin Munro","Islamabad United","South Africa","Batsman","34","58");
INSERT INTO players
value("Asif Ali","Islamabad United","Pakistan","Batsman","30","181");
INSERT INTO players
value("Marchant de Lange","Islamabad United","South Africa","Bowler","31","N/A");
INSERT INTO players
value("Faheem Ashraf","Islamabad United","Pakistan","Bowler","28","95");
INSERT INTO players
value("Rahmanullah Gurbaz","Islamabad United","Afghanistan","Wicket-Keeper","20","22");
INSERT INTO players
value("Zafar Gohar","Islamabad United","Pakistan","All-Rounder","26","252");

-- Multan Sultans
INSERT INTO players
value("Rumman Raees","Multan Sultans","Pakistan","Bowler","30","130");
INSERT INTO players
value("Rovman Powell","Multan Sultans","West Indies","Batsman","28","255");
INSERT INTO players
value("Imran Tahir","Multan Sultans","South Africa","Bowler","42","39");
INSERT INTO players
value("Shan Masood","Multan Sultans","Kuwait","Batsman","32","499");
INSERT INTO players
value("Imran Khan Snr","Multan Sultans","Pakistan","Bowler","34","345");
INSERT INTO players
value("Rilee Rossouw","Multan Sultans","South Africa","Batsman","32","99");
INSERT INTO players
value("Sohaib Maqsood","Multan Sultans","Pakistan","Batsman","34","498");
INSERT INTO players
value("Khushdil Shah","Multan Sultans","Pakistan","Batsman","26","N/A");
INSERT INTO players
value("Mohammad Rizwan","Multan Sultans","Pakistan","Batsman","29","2");
INSERT INTO players
value("Tim David","Multan Sultans","Singapore","All-Rounder","25","N/A");

-- Lahore Qalanders
INSERT INTO players
value("Fakhar Zaman","Lahore Qalandars","Pakistan","Batsman","31","38");
INSERT INTO players
value("Mohammad Hafeez","Lahore Qalandars","Pakistan","All-Rounder","41","74");
INSERT INTO players
value("Rashid Khan","Lahore Qalandars","Afghanistan","Bowler","23","38");
INSERT INTO players
value("Shaheen Afridi","Lahore Qalandars","Pakistan","Bowler","21","11");
INSERT INTO players
value("Samit Patel","Lahore Qalandars","England","All-Rounder","37","31");
INSERT INTO players
value("David Wiese","Lahore Qalandars","Namibia","All-Rounder","36","120");
INSERT INTO players
value("Ben Dunk","Lahore Qalandars","Australia","Wicket-Keeper","34","391");
INSERT INTO players
value("Harry Brook","Lahore Qalandars","England","Batsman","22","N/A");
INSERT INTO players
value("Haris Rauf","Lahore Qalandars","Pakistan","Bowler","28","22");
INSERT INTO players
value("Dean Foxcroft","Lahore Qalandars","South Africa","Batsman","23","424");

-- Karachi Kings
INSERT INTO players
value("Babar Azam","Karachi Kings","Pakistan","Batsman","27","1");
INSERT INTO players
value("Imad Wasim","Karachi Kings","Pakistan","Bowler","33","34");
INSERT INTO players
value("Mohammad Amir","Karachi Kings","Pakistan","Bowler","29","176");
INSERT INTO players
value("Chris Jordan","Karachi Kings","England","Bowler","33","15");
INSERT INTO players
value("Mohammad Nabi","Karachi Kings","Afghanistan","All-Rounder","37","29");
INSERT INTO players
value("Aamer Yamin","Karachi Kings","Pakistan","All-Rounder","31","488");
INSERT INTO players
value("Umaid Asif","Karachi Kings","Pakistan","Bowler","37","369");
INSERT INTO players
value("Joe Clarke","Karachi Kings","England","Batsman","25","547");
INSERT INTO players
value("Rohail Nazir","Karachi Kings","Pakistan","Wicket-Keeper","20","N/A");
INSERT INTO players
value("Sharjeel Khan","Karachi Kings","Pakistan","Batsman","32","390");

-- Quetta Gladiators
INSERT INTO players
value("Jason Roy","Quetta Gladiators","England","Batsman","31","16");
INSERT INTO players
value("James Vince","Quetta Gladiators","England","Batsman","30","166");
INSERT INTO players
value("Sarfraz Ahmed","Quetta Gladiators","Pakistan","Wicket-Keeper","34","206");
INSERT INTO players
value("Mohammad Nawaz","Quetta Gladiators","Pakistan","All-Rounder","27","99");
INSERT INTO players
value("Sohail Tanvir","Quetta Gladiators","Pakistan","Bowler","37","61");
INSERT INTO players
value("James Faulkner","Quetta Gladiators","Australia","Bowler","31","18");
INSERT INTO players
value("Ben Duckett","Quetta Gladiators","England","Batsman","27","813");
INSERT INTO players
value("Umar Akmal","Quetta Gladiators","Pakistan","Batsman","31","364");
INSERT INTO players
value("Shahid Afridi","Quetta Gladiators","Pakistan","All-Rounder","46","N/A");
INSERT INTO players
value("Naveen-ul-Haq","Quetta Gladiators","Afghanistan","Bowler","22","84");

-- Peshawar Zalmi
INSERT INTO players
value("Kamran Akmal","Peshawar Zalmi","Pakistan","Wicket-Keeper","40","110");
INSERT INTO players
value("Shoaib Malik","Peshawar Zalmi","Pakistan","Batsman","39","135");
INSERT INTO players
value("Wahab Riaz","Peshawar Zalmi","Pakistan","Bowler","36","227");
INSERT INTO players
value("Ben Cutting","Peshawar Zalmi","Australia","All-Rounder","34","301");
INSERT INTO players
value("Liam Livingstone","Peshawar Zalmi","England","Batsman","28","57");
INSERT INTO players
value("Hussain Talat","Peshawar Zalmi","Pakistan","Batsman","25","247");
INSERT INTO players
value("Saqib Mahmood","Peshawar Zalmi","England","Bowler","24","N/A");
INSERT INTO players
value("Tom Kohler-Cadmore","Peshawar Zalmi","England","Batsman","27","800");
INSERT INTO players
value("Sherfane Rutherford","Peshawar Zalmi","West Indies","All-Rounder","23","N/A");
INSERT INTO players
value("Matthew Parkinson","Peshawar Zalmi","England","Bowler","25","813");

-- Tiles 
INSERT INTO Titles
values("Islamabad United", "Winner", "2016");
INSERT INTO Titles
values("Quetta Gladiators", "Runners-up", "2016");
INSERT INTO Titles
values("Peshawar Zalmi", "Winner", "2017");
INSERT INTO Titles
values("Quetta Gladiators", "Runners-up", "2017");

INSERT INTO Titles
values("Islamabad United", "Winner", "2018");
INSERT INTO Titles
values("Peshawar Zalmi", "Runners-up", "2018");

INSERT INTO Titles
values("Quetta Gladiators", "Winner", "2019");
INSERT INTO Titles
values("Peshawar Zalmi", "Runners-up", "2019");

INSERT INTO Titles
values("Karachi Kings", "Winner", "2020");
INSERT INTO Titles
values("Lahore Qalandars", "Runners-up", "2020");

INSERT INTO Titles
values("Multan Sultans", "Winner", "2021");
INSERT INTO Titles
values("Peshawar Zalmi", "Runners-up", "2021");

-- Points
INSERT INTO Points
values ("Karachi Kings", "0");

INSERT INTO Points
values ("Peshawar Zalmi", "2");

INSERT INTO Points
values ("Multan Sultans", "8");

INSERT INTO Points
values ("Islamabad United", "4");

INSERT INTO Points
values ("Quetta Gladiators", "2");

INSERT INTO Points
values ("Lahore Qalandars", "4");

-- Adding Fixtures
INSERT INTO Fixtures
values("Karachi Kings", "Multan Sultans", "27-01-2022","8:00 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Quetta Gladiators", "Peshawar Zalmi", "28-01-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Multan Sultans", "Lahore Qalandars", "29-01-2022","2:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Karachi Kings", "Quetta Gladiators", "29-01-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Peshawar Zalmi", "Islamabad United", "30-01-2022","2:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Karachi Kings", "Lahore Qalandars", "30-01-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Quetta Gladiators", "Multan Sultans", "31-01-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Islamabad United", "Multan Sultans", "01-02-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Peshawar Zalmi", "Lahore Qalandars", "02-02-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Quetta Gladiators", "Islamabad United", "03-02-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Karachi Kings", "Peshawar Zalmi", "04-02-2022","7:30 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Islamabad United", "Lahore Qalandars", "05-02-2022","2:00 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Peshawar Zalmi", "Multan Sultans", "05-02-2022","7:00 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Karachi Kings", "Islamabad United", "06-02-2022","7:00 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Quetta Gladiators", "Lahore Qalandars", "07-02-2022","7:00 PM","National Stadium, Karachi");
INSERT INTO Fixtures
values("Multan Sultans", "Peshawar Zalmi", "10-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Lahore Qalandars", "Multan Sultans", "11-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Islamabad United", "Quetta Gladiators", "12-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Peshawar Zalmi", "Karachi Kings", "13-02-2022","2:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Lahore Qalandars", "Quetta Gladiators", "13-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Islamabad United", "Karachi Kings", "14-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Peshawar Zalmi", "Quetta Gladiators", "15-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Multan Sultans", "Karachi Kings", "16-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Islamabad United", "Peshawar Zalmi", "17-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Multan Sultans", "Quetta Gladiators", "18-02-2022","3:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Lahore Qalandars", "Karachi Kings", "18-02-2022","8:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Lahore Qalandars", "Islamabad United", "19-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Quetta Gladiators", "Karachi Kings", "20-02-2022","2:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Multan Sultans", "Islamabad United", "20-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("Lahore Qalandars", "Peshawar Zalmi", "21-02-2022","7:00 PM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("TBD", "TBD", "24-02-2022","12:30 AM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("TBD", "TBD", "25-02-2022","12:30 AM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("TBD", "TBD", "26-02-2022","12:30 AM","Qaddafi Stadium, Lahore");
INSERT INTO Fixtures
values("TBD", "TBD", "28-02-2022","12:30 AM","Qaddafi Stadium, Lahore");

