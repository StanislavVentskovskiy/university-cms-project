CREATE SCHEMA IF NOT EXISTS university;

DROP TABLE IF EXISTS university.groups
    CASCADE;
DROP TABLE IF EXISTS university.groupsstudents
    CASCADE;
DROP TABLE IF EXISTS university.lessons
    CASCADE;
DROP TABLE IF EXISTS university.rooms
    CASCADE;
DROP TABLE IF EXISTS university.students
    CASCADE;
DROP TABLE IF EXISTS university.subject
    CASCADE;
DROP TABLE IF EXISTS university.teachers
    CASCADE;

CREATE TABLE IF NOT EXISTS university.rooms
(
    id BIGSERIAL NOT NULL,
    floor integer NOT NULL,
    "number" integer NOT NULL,
    CONSTRAINT rooms_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.rooms
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS university.groups
(
    id BIGSERIAL NOT NULL,
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT groups_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.groups
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS university.subjects
(
    id BIGSERIAL NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT subjects_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.subjects
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS university.teachers
(
    id BIGSERIAL NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    birthday time without time zone,
    subject_id integer NOT NULL,
    "position" character varying COLLATE pg_catalog."default",
    CONSTRAINT teachers_pkey PRIMARY KEY (id),
    CONSTRAINT teachers_subject_fkey FOREIGN KEY (subject_id)
    REFERENCES university.subjects (id) MATCH SIMPLE
                  ON UPDATE NO ACTION
                  ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.teachers
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS university.students
(
    id BIGSERIAL NOT NULL,
    group_id integer NOT NULL,
    course integer,
    name character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    birthday timestamp without time zone,
    CONSTRAINT students_pkey PRIMARY KEY (id),
    CONSTRAINT students FOREIGN KEY (group_id)
    REFERENCES university.groups (id) MATCH SIMPLE
                       ON UPDATE NO ACTION
                       ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.students
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS university.groupsstudents
(
    id BIGSERIAL NOT NULL,
    student_id integer,
    group_id integer,
    CONSTRAINT groupsstudents_pkey PRIMARY KEY (id),
    CONSTRAINT groups FOREIGN KEY (group_id)
    REFERENCES university.groups (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT students FOREIGN KEY (student_id)
    REFERENCES university.students (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.groupsstudents
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS university.lessons
(
    id integer NOT NULL,
    room_id integer NOT NULL,
    group_id integer NOT NULL,
    teacher_id integer NOT NULL,
    subject_id integer NOT NULL,
    "startTime" time without time zone,
    "endTime" time without time zone,
    date date,
    CONSTRAINT lessons_pkey PRIMARY KEY (id),
    CONSTRAINT groups FOREIGN KEY (group_id)
    REFERENCES university.groups (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT rooms FOREIGN KEY (room_id)
    REFERENCES university.rooms (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT subjects FOREIGN KEY (subject_id)
    REFERENCES university.subjects (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT teachers FOREIGN KEY (teacher_id)
    REFERENCES university.teachers (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS university.lessons
    OWNER to postgres;