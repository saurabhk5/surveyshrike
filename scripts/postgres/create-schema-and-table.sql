-- SCHEMA: survey

DROP SCHEMA survey ;

CREATE SCHEMA survey
    AUTHORIZATION postgres;

-- Table: survey.user_details

DROP TABLE survey.user_details;

CREATE TABLE survey.user_details
(
    id integer NOT NULL DEFAULT nextval('survey.user_details_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    last_login date,
    isactive boolean,
    CONSTRAINT user_details_pkey PRIMARY KEY (id)
);

ALTER TABLE survey.user_details
    OWNER to postgres;
	

-- Table: survey.survey_details

DROP TABLE survey.survey_details;

CREATE TABLE survey.survey_details
(
    id integer NOT NULL DEFAULT nextval('survey.survey_details_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    start_date date,
    end_date date,
    created_date date,
    created_by integer,
    isactive boolean,
    CONSTRAINT survey_details_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user_details_id FOREIGN KEY (created_by)
        REFERENCES survey.user_details (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE NO ACTION
);

ALTER TABLE survey.survey_details
    OWNER to postgres;
	
-- Table: survey.survey_questions

DROP TABLE survey.survey_questions;

CREATE TABLE survey.survey_questions
(
    id integer NOT NULL DEFAULT nextval('survey.survey_questions_id_seq'::regclass),
    question text COLLATE pg_catalog."default",
    input_type integer,
    answer_required boolean,
    survey_id integer,
    CONSTRAINT survey_questions_pkey PRIMARY KEY (id),
    CONSTRAINT fk_survey_details_id FOREIGN KEY (survey_id)
        REFERENCES survey.survey_details (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_survey_input_type_id FOREIGN KEY (input_type)
        REFERENCES survey.survey_input_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE survey.survey_questions
    OWNER to postgres;
	
-- Table: survey.survey_question_options

DROP TABLE survey.survey_question_options;

CREATE TABLE survey.survey_question_options
(
    id integer NOT NULL DEFAULT nextval('survey.survey_question_options_id_seq'::regclass),
    question_id integer,
    option_choice_name text COLLATE pg_catalog."default",
    CONSTRAINT survey_question_options_pkey PRIMARY KEY (id),
    CONSTRAINT fk_survey_questions_id FOREIGN KEY (question_id)
        REFERENCES survey.survey_questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE survey.survey_question_options
    OWNER to postgres;
	
-- Table: survey.survey_input_type

DROP TABLE survey.survey_input_type;

CREATE TABLE survey.survey_input_type
(
    id integer NOT NULL DEFAULT nextval('survey.survey_input_type_id_seq'::regclass),
    input_type_name text COLLATE pg_catalog."default",
    CONSTRAINT survey_input_type_pkey PRIMARY KEY (id)
);

ALTER TABLE survey.survey_input_type
    OWNER to postgres;
	
-- Table: survey.survey_answers

DROP TABLE survey.survey_answers;

CREATE TABLE survey.survey_answers
(
    id integer NOT NULL DEFAULT nextval('survey.survey_answers_id_seq'::regclass),
    answered_by integer,
    question_id integer,
    option_id integer,
    answer_text text COLLATE pg_catalog."default",
    isanswered boolean,
    CONSTRAINT survey_answers_pkey PRIMARY KEY (id),
    CONSTRAINT fk_survey_question_options_id FOREIGN KEY (option_id)
        REFERENCES survey.survey_question_options (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_survey_questions_id FOREIGN KEY (question_id)
        REFERENCES survey.survey_questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_user_details_id FOREIGN KEY (answered_by)
        REFERENCES survey.user_details (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE survey.survey_answers
    OWNER to postgres;
    
--Insert for input type
INSERT INTO survey.survey_input_type(input_type_name) VALUES ('RadioButton');
INSERT INTO survey.survey_input_type(input_type_name) VALUES ('CheckBox');
INSERT INTO survey.survey_input_type(input_type_name) VALUES ('Text');
INSERT INTO survey.survey_input_type(input_type_name) VALUES ('DropDown');

COMMIT;
