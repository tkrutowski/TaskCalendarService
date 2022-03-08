
create table kalendarz_zadania
(
    id_wpisu             INTEGER not null,
    id_zadania           INTEGER not null,
    id_brygady           INTEGER not null,
    rodzaj_zadania       VARCHAR not null,
    data                 VARCHAR not null,
    mail_status_pgn      VARCHAR not null,
    post_date_pgn        DATE null,
    mail_status_surveyor VARCHAR not null,
    post_date_surveyor   DATE not null,
    mail_status_customer VARCHAR not null,
    post_date_customer   DATE null,
    info                 VARCHAR not null
);


INSERT INTO kalendarz_zadania(id_wpisu, id_zadania,id_brygady, rodzaj_zadania, data, mail_status_pgn,post_date_pgn,mail_status_surveyor,
                           post_date_surveyor,mail_status_customer,post_date_customer,info)
VALUES(1, 1, 1, 'przylacze','2021-02-22', 'NOT_SEND', null, 'NOT_SEND', '0001-01-01','NOT_SEND', null,'gaz 8:00');

INSERT INTO kalendarz_zadania(id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, mail_status_pgn,post_date_pgn,mail_status_surveyor,
                           post_date_surveyor,mail_status_customer,post_date_customer,info)
VALUES(2, 2,2, 'przylacze','2021-02-22', 'SENT', '2021-01-15', 'NOT_SEND', '0001-01-01','SENT', '2021-04-12','gaz 12:00');



INSERT INTO kalendarz_zadania(id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, mail_status_pgn,post_date_pgn,mail_status_surveyor,
                           post_date_surveyor,mail_status_customer,post_date_customer,info)
VALUES(3, 3,2, 'przylacze','2021-02-23', 'NOT_SEND', null, 'NOT_SEND', '0001-01-01','NOT_SEND', null,'gaz 8:00');

INSERT INTO kalendarz_zadania(id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, mail_status_pgn,post_date_pgn,mail_status_surveyor,
                           post_date_surveyor,mail_status_customer,post_date_customer,info)
VALUES(4,2,2, 'przylacze','2021-03-08', 'NOT_SEND', null, 'NOT_SEND', '0001-01-01','NOT_SEND', null,'gaz 8:00 data-08');

INSERT INTO kalendarz_zadania(id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, mail_status_pgn,post_date_pgn,mail_status_surveyor,
                           post_date_surveyor,mail_status_customer,post_date_customer,info)
VALUES(5,1,2, 'przylacze','2021-03-10', 'NOT_SEND', null, 'NOT_SEND', '0001-01-01','NOT_SEND', null,'gaz 8:00 data-10');


INSERT INTO kalendarz_zadania(id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, mail_status_pgn,post_date_pgn,mail_status_surveyor,
                           post_date_surveyor,mail_status_customer,post_date_customer,info)
VALUES(6,1,2, 'gazociag','2021-02-22', 'NOT_SEND', null, 'NOT_SEND', '0001-01-01','NOT_SEND', null,'gaz 8:00');

--
