CREATE TABLE webSite
(
    id  SERIAL,
    url TEXT NOT NULL
        CONSTRAINT url_pk PRIMARY KEY
);

CREATE TABLE wordsCounter
(
    ID       SERIAL,
    site_url TEXT    NOT NULL REFERENCES webSite (url) ON DELETE CASCADE,
    word     TEXT    NOT NULL,
    count    INTEGER NOT NULL
);