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

INSERT INTO public.t_type (id, name) VALUES (1, 'Epicerie fine');
INSERT INTO public.t_type (id, name) VALUES (2, 'Prêt a cuisiner');
INSERT INTO public.t_type (id, name) VALUES (3, 'Vrac');
INSERT INTO public.t_type (id, name) VALUES (4, 'Cosmetique');
INSERT INTO public.t_type (id, name) VALUES (5, 'Maison');
SELECT setval('t_type_id_seq', 6, true);

INSERT INTO public.t_categorie (id, name) VALUES (1, 'Thés et infusions');
INSERT INTO public.t_categorie (id, name) VALUES (2, 'Epices');
INSERT INTO public.t_categorie (id, name) VALUES (3, 'Gourmandises');
INSERT INTO public.t_categorie (id, name) VALUES (4, 'Huiles et vinaigres');
INSERT INTO public.t_categorie (id, name) VALUES (5, 'Cafés');
INSERT INTO public.t_categorie (id, name) VALUES (6, 'Sels');
INSERT INTO public.t_categorie (id, name) VALUES (7, 'Apéritif');
INSERT INTO public.t_categorie (id, name) VALUES (8, 'Spécialités étrangères');
SELECT setval('t_categorie_id_seq', 9, true);

INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 1);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 2);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 3);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 4);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 5);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 6);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 7);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 8);


INSERT INTO public.t_sous_categorie (id, name) VALUES (1, 'Thés verts');
INSERT INTO public.t_sous_categorie (id, name) VALUES (2, 'Thés noirs');
INSERT INTO public.t_sous_categorie (id, name) VALUES (3, 'Infusions et Rooïbos');
INSERT INTO public.t_sous_categorie (id, name) VALUES (4, 'Fleurs, herbes et aromates');
INSERT INTO public.t_sous_categorie (id, name) VALUES (5, 'Piments');
INSERT INTO public.t_sous_categorie (id, name) VALUES (6, 'Epices et condiments');
INSERT INTO public.t_sous_categorie (id, name) VALUES (7, 'Nos sels Une dose de vert');
INSERT INTO public.t_sous_categorie (id, name) VALUES (8, 'Sels du monde');
INSERT INTO public.t_sous_categorie (id, name) VALUES (9, 'Chocolats');
INSERT INTO public.t_sous_categorie (id, name) VALUES (10, 'Confiseries');
INSERT INTO public.t_sous_categorie (id, name) VALUES (11, 'Biscuits sucrés');
INSERT INTO public.t_sous_categorie (id, name) VALUES (12, 'Biscuits salés');
INSERT INTO public.t_sous_categorie (id, name) VALUES (13, 'Oléagineux');
SELECT setval('t_sous_categorie_id_seq', 14, true);

INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (1, 1);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (1, 2);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (2, 4);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (2, 5);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (2, 6);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (3, 9);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (3, 10);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (3, 11);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (6, 7);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (6, 8);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (7, 12);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (7, 13);
