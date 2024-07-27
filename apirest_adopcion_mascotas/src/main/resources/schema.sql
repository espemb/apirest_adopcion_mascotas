create table if not exists Mascota (
  id identity,
  nombre varchar(50) not null,
  nacimiento date not null,
  raza varchar(50) not null,
  peso float not null,
  chip boolean not null,
  foto varchar(100)
  
); 