------------------------------------------------------------
-- SPECIALTIES (Données NHS complètes)
------------------------------------------------------------

INSERT INTO specialty (id, name, specialty_group)
VALUES
    (1, 'Anaesthetics', 'Anaesthetics'),
    (2, 'Intensive care medicine', 'Anaesthetics'),
    (3, 'Clinical oncology', 'Clinical oncology'),
    (4, 'Additional dental specialties', 'Dental group'),
    (5, 'Dental and maxillofacial radiology', 'Dental group'),
    (6, 'Endodontics', 'Dental group'),
    (7, 'Oral and maxillofacial surgery', 'Dental group'),
    (8, 'Oral and maxillofacial pathology', 'Dental group'),
    (9, 'Oral medicine', 'Dental group'),
    (10, 'Oral surgery', 'Dental group'),
    (11, 'Orthodontics', 'Dental group'),
    (12, 'Paediatric dentistry', 'Dental group'),
    (13, 'Periodontics', 'Dental group'),
    (14, 'Prosthodontics', 'Dental group'),
    (15, 'Restorative dentistry', 'Dental group'),
    (16, 'Special care dentistry', 'Dental group'),
    (17, 'Emergency medicine', 'Emergency Medicine'),
    (18, 'Acute internal medicine', 'General medicine group'),
    (19, 'Allergy', 'General medicine group'),
    (20, 'Audio vestibular medicine', 'General medicine group'),
    (21, 'Cardiology', 'General medicine group'),
    (22, 'Clinical genetics', 'General medicine group'),
    (23, 'Clinical neurophysiology', 'General medicine group'),
    (24, 'Clinical pharmacology and therapeutics', 'General medicine group'),
    (25, 'Dermatology', 'General medicine group'),
    (26, 'Endocrinology and diabetes mellitus', 'General medicine group'),
    (27, 'Gastroenterology', 'General medicine group'),
    (28, 'General (internal) medicine', 'General medicine group'),
    (29, 'General med practitioner', 'General medicine group'),
    (30, 'General practice (GP) 6 month training', 'General medicine group'),
    (31, 'Genito-urinary medicine', 'General medicine group'),
    (32, 'Geriatric medicine', 'General medicine group'),
    (33, 'Infectious diseases', 'General medicine group'),
    (34, 'Medical oncology', 'General medicine group'),
    (35, 'Medical ophthalmology', 'General medicine group'),
    (36, 'Neurology', 'General medicine group'),
    (37, 'Occupational medicine', 'General medicine group'),
    (38, 'Other', 'General medicine group'),
    (39, 'Palliative medicine', 'General medicine group'),
    (40, 'Rehabilitation medicine', 'General medicine group'),
    (41, 'Renal medicine', 'General medicine group'),
    (42, 'Respiratory medicine', 'General medicine group'),
    (43, 'Rheumatology', 'General medicine group'),
    (44, 'Sport and exercise medicine', 'General medicine group'),
    (45, 'Community sexual and reproductive health', 'Obstetrics & gynecology'),
    (46, 'Paediatric cardiology', 'Paediatric group'),
    (47, 'Paediatrics', 'Paediatric group'),
    (48, 'Chemical pathology', 'Pathology group'),
    (49, 'Diagnostic neuropathology', 'Pathology group'),
    (50, 'Forensic histopathology', 'Pathology group'),
    (51, 'General pathology', 'Pathology group'),
    (52, 'Haematology', 'Pathology group'),
    (53, 'Histopathology', 'Pathology group'),
    (54, 'Immunology', 'Pathology group'),
    (55, 'Medical microbiology', 'Pathology group'),
    (56, 'Paediatric and perinatal pathology', 'Pathology group'),
    (57, 'Virology', 'Pathology group'),
    (58, 'Community health service dental', 'PHM & CHS group'),
    (59, 'Community health service medical', 'PHM & CHS group'),
    (60, 'Dental public health', 'PHM & CHS group'),
    (61, 'General dental practitioner', 'PHM & CHS group'),
    (62, 'Public health medicine', 'PHM & CHS group'),
    (63, 'Child and adolescent psychiatry', 'Psychiatry group'),
    (64, 'Forensic psychiatry', 'Psychiatry group'),
    (65, 'General psychiatry', 'Psychiatry group'),
    (66, 'Old age psychiatry', 'Psychiatry group'),
    (67, 'Psychiatry of learning disability', 'Psychiatry group'),
    (68, 'Psychotherapy', 'Psychiatry group'),
    (69, 'Clinical radiology', 'Radiology group'),
    (70, 'Nuclear medicine', 'Radiology group'),
    (71, 'Cardiothoracic surgery', 'Surgical group'),
    (72, 'General surgery', 'Surgical group'),
    (73, 'Neurosurgery', 'Surgical group'),
    (74, 'Ophthalmology', 'Surgical group'),
    (75, 'Otolaryngology', 'Surgical group'),
    (76, 'Paediatric surgery', 'Surgical group'),
    (77, 'Plastic surgery', 'Surgical group'),
    (78, 'Trauma and orthopedic surgery', 'Surgical group'),
    (79, 'Urology', 'Surgical group'),
    (80, 'Vascular Surgery', 'Surgical group');

------------------------------------------------------------
-- HOSPITALS
------------------------------------------------------------

INSERT INTO hospital
(id, name, latitude, longitude)
VALUES
    (1, 'Fred Brooks Hospital', 51.5074, -0.1278),
    (2, 'Julia Crusher Hospital', 51.5090, -0.1180),
    (3, 'Beverly Bashir Hospital', 51.5033, -0.1195);

------------------------------------------------------------
-- HOSPITAL SPECIALTIES
------------------------------------------------------------

INSERT INTO hospital_specialty
(id, hospital_id, specialty_id, available_beds)
VALUES
    (1, 1, 21, 2),
    (2, 1, 54, 1),
    (3, 1, 72, 3),

    (4, 2, 17, 1),
    (5, 2, 47, 2),
    (6, 2, 25, 4),

    (7, 3, 34, 5),
    (8, 3, 55, 3),
    (9, 3, 79, 4);