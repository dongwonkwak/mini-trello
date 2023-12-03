create schema if not exists minitrello;

create TABLE IF NOT EXISTS minitrello.user_account(
    user_id uuid NOT NULL DEFAULT random_uuid(),
    username varchar(20) NOT NULL,
    email varchar(24) NOT NULL,
    password varchar(72) NOT NULL,
    created_at TIMESTAMP NOT NULL
)