INSERT INTO public.t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.t_roles (name) VALUES ('ROLE_USER');
SELECT setval('t_roles_id_seq', 3, true);

INSERT INTO public.t_user (active, anniversaire, email, nom, password, prenom, telephone, panier_id) VALUES (null, '2020-11-16', 'deneux.j@gmail.com', 'Deneux', '$2a$10$3ZgfaLwo0Wl5f74MZ7IGtuzjUV8/v3NgbUDx0VaXZBWPVR9.8ZZ6y', 'Jérôme', '0625092170', null);
SELECT setval('t_user_id_seq', 2, true);

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (1, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (2, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 'Paris', 'rue de la Grande Armée');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (3, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (4, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 'Paris', 'rue de la Grande Armée');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (5, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (6, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 'Paris', 'rue de la Grande Armée');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (7, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, ville, voie) VALUES (8, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 'Paris', 'rue de la Grande Armée');
SELECT setval('t_adresse_id_seq', 9, true);

INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 1);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 2);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 3);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 4);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 5);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 6);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 7);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 8);
