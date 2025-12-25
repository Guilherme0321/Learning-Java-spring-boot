INSERT INTO users (username, password)
VALUES
    ('admin', '$2a$12$H.sFok5GOsKLvg3yEMdte.cmtojWx6PQBh8DKP5uSM/x254qd8f8C')
ON CONFLICT (username) DO NOTHING;