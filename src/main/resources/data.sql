INSERT INTO users (username, password)
VALUES
    ('administrator', '$2a$12$URok/B/o/ugW5b3Df/AZquQ4sODXr1RSpKJNywoVfJNHwW6Ne6KyG')
ON CONFLICT (username) DO NOTHING;