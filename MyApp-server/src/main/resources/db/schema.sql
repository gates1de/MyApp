-- drop all tables

drop table if exists restaurants_reviews;
drop table if exists restaurants_pictures;
drop table if exists restaurants_foods;
drop table if exists restaurants_cities;
drop table if exists restaurants_genres;
drop table if exists foods_cities;

drop table if exists reviews;
drop table if exists pictures;
drop table if exists foods;
drop table if exists restaurants;

drop table if exists cities;
drop table if exists areas;
drop table if exists prefectures;
drop table if exists regions;

drop table if exists genres;


-- semi-static table

create table if not exists regions (
	id int not null auto_increment,
	name varchar(32) not null,
	code varchar(16) not null,
	created_at datetime,
	updated_at datetime,
	primary key (id)
) engine = innodb default charset = utf8;

create table if not exists prefectures (
	id int not null auto_increment,
	name varchar(32) not null,
	code varchar(16) not null,
	region_id int not null,
	region_code varchar(16) not null,
	created_at datetime,
	updated_at datetime,
	primary key (id),
	constraint `prefectures_region_id_fk` foreign key (region_id) references regions (id) on delete cascade on update cascade
) engine = innodb default charset = utf8;

create table if not exists areas (
	id int not null auto_increment,
	name varchar(32) not null,
	code varchar(16) not null,
	prefecture_id int not null,
	prefecture_code varchar(16) not null,
	created_at datetime,
	updated_at datetime,
	primary key (id),
	constraint `areas_prefecture_id_fk` foreign key (prefecture_id) references prefectures (id) on delete cascade on update cascade
) engine = innodb default charset = utf8;

create table if not exists cities (
	id int not null auto_increment,
	name varchar(32) not null,
	code varchar(16) not null,
	area_id int not null,
	area_code varchar(16) not null,
	created_at datetime,
	updated_at datetime,
	primary key (id),
	constraint `cities_area_id_fk` foreign key (area_id) references areas (id) on delete cascade on update cascade
) engine = innodb default charset = utf8;

create table if not exists genres (
	id int not null auto_increment,
	name varchar(32) not null,
	created_at datetime,
	updated_at datetime,
	primary key (id)
) engine = innodb default charset = utf8;


-- basic table

create table if not exists restaurants (
	id int not null auto_increment,
	name varchar(128) not null,
	address varchar(128),
	phone_number varchar(16),
	lat decimal(9, 6) not null,
	lon decimal(9, 6) not null,
	city_id int not null,
	message text,
	created_at datetime,
	updated_at datetime,
	primary key (id),
	foreign key (city_id) references cities (id)
) engine = innodb default charset = utf8;

create table if not exists foods (
	id int not null auto_increment,
	name varchar(128) not null,
	is_specialty boolean not null default false,
	created_at datetime,
	updated_at datetime,
	primary key (id)
) engine = innodb default charset = utf8;

create table if not exists pictures (
	id int not null auto_increment,
	name varchar(64) not null,
	path varchar(128) not null,
	created_at datetime,
	updated_at datetime,
	primary key (id)
) engine = innodb default charset = utf8;

create table if not exists reviews (
	id int not null auto_increment,
	name varchar(64) not null,
	star tinyint,
	created_at datetime,
	updated_at datetime,
	primary key (id)
) engine = innodb default charset = utf8;


-- association table

create table if not exists restaurants_foods (
	restaurant_id int not null,
	food_id int not null,
	primary key (restaurant_id, food_id),
	foreign key (restaurant_id) references restaurants (id),
	foreign key (food_id) references foods (id)
) engine = innodb default charset = utf8;

create table if not exists restaurants_cities (
	restaurant_id int not null,
	city_id int not null,
	primary key (restaurant_id, city_id),
	foreign key (restaurant_id) references restaurants (id),
	foreign key (city_id) references cities (id)
) engine = innodb default charset = utf8;

create table if not exists restaurants_pictures (
	restaurant_id int not null,
	picture_id int not null,
	primary key (restaurant_id, picture_id),
	foreign key (restaurant_id) references restaurants (id),
	foreign key (picture_id) references pictures (id)
) engine = innodb default charset = utf8;

create table if not exists restaurants_reviews (
	restaurant_id int not null,
	review_id int not null,
	primary key (restaurant_id, review_id),
	foreign key (restaurant_id) references restaurants (id),
	foreign key (review_id) references reviews (id)
) engine = innodb default charset = utf8;

create table if not exists restaurants_genres (
	restaurant_id int not null,
	genre_id int not null,
	primary key (restaurant_id, genre_id),
	foreign key (restaurant_id) references restaurants (id),
	foreign key (genre_id) references genres (id)
) engine = innodb default charset = utf8;

create table if not exists foods_cities (
	food_id int not null,
	city_id int not null,
	primary key (food_id, city_id),
	foreign key (food_id) references foods (id),
	foreign key (city_id) references cities (id)
) engine = innodb default charset = utf8;
