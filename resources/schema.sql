create table activity(id int primary key, date date ,beginTime time,endTime time ,maxPlaces int, description varchar);

create table participation (id int primary key, email varchar(50), activity_id int,
	constraint fk_activity foreign key (activity) references activity(id));
