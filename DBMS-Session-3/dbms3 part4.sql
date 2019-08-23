use store;


/*Part-4*/

create table citystate
(

id int AUTO_INCREMENT not null,

city varchar(20),

state varchar(20),

primary key(id)
);


create table zip
(

zipcode int,

zipid int not null,

primary key(zipcode),

foreign key(zipid) references citystate(id)
);




insert into citystate(city,state)

values

('Jaipur','Rajasthan'),

('Alwar','Rajasthan'),

('Jodhpur','Rajasthan'),

('Ahemdabad','Gujrat'),

('Gandhinagar','Gujrat');




insert into zip(zipcode,zipid)

values

('302016','1'),

('302022','1'),

('302020','1'),

('301713','2'),

('320008','5'),

('308944','3'),

('340044','4');





select zip.zipcode,citystate.city,citystate.state

from citystate

inner join zip on 

zip.zipid=citystate.id;
