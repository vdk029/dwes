-- 1
SELECT nombre,especie from personajes;

--2
SELECT nombre from personajes where nivel_inteligencia >80;

--3
SELECT a from aventuras a JOIN personajes p ON a.personaje_id = p.id
WHERE p.nombre = 'Summer Smith';

--4
SELECT p.nombre, COUNT(a.id) AS total_aventuras
FROM personajes p left join aventuras a ON p.id = a.personaje_id
GROUP BY p.id, p.nombre;

--5
SELECT a.*FROM aventuras a JOIN personajes p ON a.personaje_id = p.id
WHERE LOWER(p.habilidad_especial) LIKE '%portal gun%';
--6
SELECT p.nombre
FROM personajes p JOIN aventuras a ON p.id = a.personaje_id GROUP BY p.id, p.nombre
HAVING COUNT(DISTINCT a.planeta_id) > 3;

--7
SELECT DISTINCT p.nombre
FROM personajes p
         JOIN aventuras a ON p.id = a.personaje_id
         JOIN planetas pl ON a.planeta_id = pl.id
WHERE p.especie = 'Humano'
  AND pl.afiliacion_gobierno = 'Federación Galáctica';

--8
SELECT AVG(p.nivel_inteligencia) AS promedio_inteligencia
FROM personajes p
         JOIN aventuras a ON p.id = a.personaje_id
         JOIN planetas pl ON a.planeta_id = pl.id
WHERE pl.nombre = 'Blips and Chitz';