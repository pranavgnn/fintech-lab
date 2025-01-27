CREATE TABLE Player (
    player_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    nationality VARCHAR(50),
    position VARCHAR(50)
);

CREATE TABLE Stadium (
    stadium_id INT PRIMARY KEY,
    stadium_name VARCHAR(100),
    city VARCHAR(50),
    capacity INT
);

CREATE TABLE Batting (
    batting_id INT PRIMARY KEY,
    player_id INT,
    match_id INT,
    runs_scored INT,
    balls_faced INT,
    fours INT,
    sixes INT,
    strike_rate DECIMAL(5, 2),
    FOREIGN KEY (player_id) REFERENCES Player (player_id)
);

CREATE TABLE Bowling (
    bowling_id INT PRIMARY KEY,
    player_id INT,
    match_id INT,
    overs_bowled DECIMAL(5, 2),
    runs_conceded INT,
    wickets INT,
    economy_rate DECIMAL(5, 2),
    FOREIGN KEY (player_id) REFERENCES Player (player_id)
);
