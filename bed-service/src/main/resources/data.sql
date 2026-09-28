INSERT INTO bed(id, hospital_id, specialty_id, available)
VALUES
    (1, 1, 21, TRUE),
    (2, 1, 21, TRUE),
    (3, 1, 21, FALSE),

    (4, 2, 21, TRUE),
    (5, 2, 22, TRUE),

    (6, 3, 22, FALSE),
    (7, 3, 22, TRUE);

INSERT INTO reservation(
    id,
    bed_id,
    patient_latitude,
    patient_longitude,
    status,
    created_at
)
VALUES
    (
        1,
        3,
        51.5074,
        -0.1278,
        'CONFIRMED',
        CURRENT_TIMESTAMP
    ),
    (
        2,
        6,
        51.5090,
        -0.1300,
        'CONFIRMED',
        CURRENT_TIMESTAMP
    );