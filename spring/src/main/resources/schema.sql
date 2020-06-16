CREATE TABLE IF NOT EXISTS platform (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    owner VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS game (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    number_of_players INT NOT NULL
);

CREATE TABLE IF NOT EXISTS game_platforms (
    game_id INT,
    platform_id INT,
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (platform_id) REFERENCES platform(id)
);