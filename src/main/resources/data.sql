INSERT INTO public.t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.t_roles (name) VALUES ('ROLE_USER');
SELECT setval('t_roles_id_seq', 3, true);

INSERT INTO public.t_user (active, anniversaire, email, nom, password, prenom, telephone, panier_id) VALUES (null, '2020-11-16', 'deneux.j@gmail.com', 'Deneux', '$2a$10$3ZgfaLwo0Wl5f74MZ7IGtuzjUV8/v3NgbUDx0VaXZBWPVR9.8ZZ6y', 'Jérôme', '0625092170', null);
SELECT setval('t_user_id_seq', 2, true);

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO public.t_categorie (id, name) VALUES (1,'Fruit séchés et oléagineux');
INSERT INTO public.t_categorie (id, name) VALUES (2,'Graines');
INSERT INTO public.t_categorie (id, name) VALUES (3,'Légumineuses');
INSERT INTO public.t_categorie (id, name) VALUES (4,'Riz');
INSERT INTO public.t_categorie (id, name) VALUES (5,'Pâtes');
INSERT INTO public.t_categorie (id, name) VALUES (6,'Céréales');
INSERT INTO public.t_categorie (id, name) VALUES (7,'Biscuits');
INSERT INTO public.t_categorie (id, name) VALUES (8,'Farine');
INSERT INTO public.t_categorie (id, name) VALUES (9,'Sucre');
INSERT INTO public.t_categorie (id, name) VALUES (10,'Aides culinaires');
INSERT INTO public.t_categorie (id, name) VALUES (11,'Fleur de sel');
INSERT INTO public.t_categorie (id, name) VALUES (12,'Condiments');
INSERT INTO public.t_categorie (id, name) VALUES (13,'Epices');
INSERT INTO public.t_categorie (id, name) VALUES (14,'Infusions');
INSERT INTO public.t_categorie (id, name) VALUES (15,'Thé');
INSERT INTO public.t_categorie (id, name) VALUES (16,'Café');
INSERT INTO public.t_categorie (id, name) VALUES (17,'Savon');
INSERT INTO public.t_categorie (id, name) VALUES (18,'Shampoing');
INSERT INTO public.t_categorie (id, name) VALUES (19,'Masque');
INSERT INTO public.t_categorie (id, name) VALUES (20,'Bien-être');
INSERT INTO public.t_categorie (id, name) VALUES (21,'Linge');
INSERT INTO public.t_categorie (id, name) VALUES (22,'Produit ménagers');
SELECT setval('t_categorie_id_seq', 23, true);

INSERT INTO public.t_type (id, name) VALUES (1, 'Alimentaire');
INSERT INTO public.t_type (id, name) VALUES (2, 'Cosmétique et Hygiène');
INSERT INTO public.t_type (id, name) VALUES (3, 'Pour la maison');
SELECT setval('t_user_id_seq', 4, true);

INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 1);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 2);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 3);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 4);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 5);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 6);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 7);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 8);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 9);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 10);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 11);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 12);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 13);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 14);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 15);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 16);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 17);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 18);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 19);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 20);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 21);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 22);

INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (1, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 1, 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (2, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 1, 'Paris', 'rue de la Grande Armée');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (3, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 1, 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (4, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 1, 'Paris', 'rue de la Grande Armée');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (5, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 1, 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (6, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 1, 'Paris', 'rue de la Grande Armée');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (7, null, '92300', '2526', 5, 'Paul', 'Bureau', 25, 'G', 1, 'Levallois-Perret', 'avenue Aristide Briand');
INSERT INTO public.t_adresse (id, batiment, code_postal, digicode, etage, interphone, nom, numero, porte, userid, ville, voie) VALUES (8, 'A', '75200', '2569', 1, 'Arnaud', 'Maison', 125, 'D', 1, 'Paris', 'rue de la Grande Armée');
SELECT setval('t_adresse_id_seq', 9, true);

INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 1);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 2);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 3);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 4);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 5);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 6);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 7);
INSERT INTO public.t_user_adresses (user_id, adresses_id) VALUES (1, 8);


