CREATE TABLE specialty
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialty_group VARCHAR(255) NOT NULL
);

CREATE TABLE hospital
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

CREATE TABLE hospital_specialty
(
    id BIGINT PRIMARY KEY,

    hospital_id BIGINT NOT NULL,
    specialty_id BIGINT NOT NULL,

    available_beds INT NOT NULL,

    CONSTRAINT fk_hospital_specialty_hospital
        FOREIGN KEY (hospital_id)
            REFERENCES hospital(id),

    CONSTRAINT fk_hospital_specialty_specialty
        FOREIGN KEY (specialty_id)
            REFERENCES specialty(id)
);