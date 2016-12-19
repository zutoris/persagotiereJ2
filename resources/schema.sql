-- script généré par le framework, lors du 1er démarrage de l'appli 
create table activity (
	id                            integer not null,
	date                          date,
	begin_time                    time,
	end_time                      time,
	max_places                    integer,
	description                   varchar(255),
	constraint pk_activity primary key (id)
);
create sequence activity_seq;

create table participation (
	id                            integer not null,
	email                         varchar(255),
	activity_id                   integer,
	constraint pk_participation primary key (id)
);
create sequence participation_seq;
alter table participation add constraint fk_participation_activity_id foreign key (activity_id) references activity (id) on delete restrict on update restrict;
create index ix_participation_activity_id on participation (activity_id);