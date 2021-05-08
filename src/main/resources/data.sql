INSERT INTO public.t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.t_roles (name) VALUES ('ROLE_USER');


INSERT INTO public.t_user (id, active, anniversaire, email, genre, newsletter, nom, password, prenom, panier_id) VALUES (1, null, '2022-07-02', 'admin@gmail.com', 'Monsieur', null, 'testN', '$2a$10$3ZgfaLwo0Wl5f74MZ7IGtuzjUV8/v3NgbUDx0VaXZBWPVR9.8ZZ6y', 'testP', null);
SELECT setval('t_user_id_seq', 2, true);


INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);



-- INSERT INTO public.t_type (id, name) VALUES (t_type_id_seq.nextval(), 'Epicerie fine');
INSERT INTO public.t_type (id, name) VALUES (1, 'Epicerie fine');
INSERT INTO public.t_type (id, name) VALUES (2, 'Prêt à cuisiner');
INSERT INTO public.t_type (id, name) VALUES (3, 'vrac alimentaire');
INSERT INTO public.t_type (id, name) VALUES (5, 'salle de bain');
INSERT INTO public.t_type (id, name) VALUES (6, 'maison');
SELECT setval('t_type_id_seq', 6, true);

INSERT INTO public.t_categorie (id, name) VALUES (1, 'Thés,cafés,infusions');
INSERT INTO public.t_categorie (id, name) VALUES (2, 'Epices');
INSERT INTO public.t_categorie (id, name) VALUES (3, 'Gourmandises');
INSERT INTO public.t_categorie (id, name) VALUES (4, 'Apéritifs');
INSERT INTO public.t_categorie (id, name) VALUES (5, 'Huiles et vinaigres');
INSERT INTO public.t_categorie (id, name) VALUES (6, 'Spécialités étrangères');
INSERT INTO public.t_categorie (id, name) VALUES (7, 'Tous les produits');
INSERT INTO public.t_categorie (id, name) VALUES (8, 'Cuisine d''Asie');
INSERT INTO public.t_categorie (id, name) VALUES (9, 'Voyage en Méditerranée ');
INSERT INTO public.t_categorie (id, name) VALUES (10, 'Repas de sportif');
INSERT INTO public.t_categorie (id, name) VALUES (11, 'Prêt a boire');
INSERT INTO public.t_categorie (id, name) VALUES (12, 'Tous nos produits');
INSERT INTO public.t_categorie (id, name) VALUES (13, 'Pâtes, riz, céréales');
INSERT INTO public.t_categorie (id, name) VALUES (14, 'Oléagineux et graines');
INSERT INTO public.t_categorie (id, name) VALUES (15, 'Fruits séchés');
INSERT INTO public.t_categorie (id, name) VALUES (16, 'Biscuits sucrés et salés');
INSERT INTO public.t_categorie (id, name) VALUES (17, 'Aide culinaire');
INSERT INTO public.t_categorie (id, name) VALUES (18, 'Farines');
INSERT INTO public.t_categorie (id, name) VALUES (19, 'Tous les produits');
INSERT INTO public.t_categorie (id, name) VALUES (20, 'Corps');
INSERT INTO public.t_categorie (id, name) VALUES (21, 'Visage');
INSERT INTO public.t_categorie (id, name) VALUES (22, 'Cheveux');
INSERT INTO public.t_categorie (id, name) VALUES (23, 'Tous les produits');
INSERT INTO public.t_categorie (id, name) VALUES (24, 'Entretien');
INSERT INTO public.t_categorie (id, name) VALUES (25, 'Accessoires');
INSERT INTO public.t_categorie (id, name) VALUES (26, 'Tous les produits pour la maison');
SELECT setval('t_categorie_id_seq', 27, true);

INSERT INTO public.t_sous_categorie (id, name) VALUES (1, 'Thés verts');
INSERT INTO public.t_sous_categorie (id, name) VALUES (2, 'Thés noirs');
INSERT INTO public.t_sous_categorie (id, name) VALUES (3, 'Infusions et Rooïbos');
INSERT INTO public.t_sous_categorie (id, name) VALUES (4, 'Fleurs, herbes et aromates');
INSERT INTO public.t_sous_categorie (id, name) VALUES (5, 'Piments');
INSERT INTO public.t_sous_categorie (id, name) VALUES (6, 'Epices et condiments');
INSERT INTO public.t_sous_categorie (id, name) VALUES (7, 'Chocolats');
INSERT INTO public.t_sous_categorie (id, name) VALUES (8, 'Confiseries');
INSERT INTO public.t_sous_categorie (id, name) VALUES (9, 'Biscuits sucrés');
INSERT INTO public.t_sous_categorie (id, name) VALUES (10, 'Biscuits salés');
INSERT INTO public.t_sous_categorie (id, name) VALUES (11, 'Oléagineux');
INSERT INTO public.t_sous_categorie (id, name) VALUES (12, 'Tour d''Egypte');
INSERT INTO public.t_sous_categorie (id, name) VALUES (13, 'Saveur du Maroc');
INSERT INTO public.t_sous_categorie (id, name) VALUES (14, 'Objectif prise de masse');
INSERT INTO public.t_sous_categorie (id, name) VALUES (15, 'Objectif poids plume');
INSERT INTO public.t_sous_categorie (id, name) VALUES (16, 'Nos eaux aromatisées');
INSERT INTO public.t_sous_categorie (id, name) VALUES (17, 'Nos rhums arrangés');
INSERT INTO public.t_sous_categorie (id, name) VALUES (18, 'Boissons médiévales');
INSERT INTO public.t_sous_categorie (id, name) VALUES (19, 'Nos box sushi-makis');
INSERT INTO public.t_sous_categorie (id, name) VALUES (20, 'Nos box de nouilles');
INSERT INTO public.t_sous_categorie (id, name) VALUES (21, 'Nos box gateaux d''Asie');
INSERT INTO public.t_sous_categorie (id, name) VALUES (22, 'Pour les textiles');
INSERT INTO public.t_sous_categorie (id, name) VALUES (23, 'Pour les surfaces');
SELECT setval('t_sous_categorie_id_seq', 24, true);

INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (5, 20);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (5, 21);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (5, 22);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (5, 23);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (6, 24);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (6, 25);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (6, 26);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 1);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 2);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 3);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 4);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 5);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (1, 6);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 8);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 9);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 10);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 11);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (2, 12);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 13);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 14);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 15);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 16);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 17);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 18);
INSERT INTO public.t_type_categories (type_id, categories_id) VALUES (3, 19);

INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (8, 19);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (8, 20);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (8, 21);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (24, 22);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (24, 23);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (1, 1);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (1, 2);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (1, 3);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (2, 4);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (2, 5);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (2, 6);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (3, 7);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (3, 8);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (3, 9);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (4, 10);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (4, 11);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (9, 12);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (9, 13);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (10, 14);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (10, 15);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (11, 16);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (11, 17);
INSERT INTO public.t_categorie_sous_categories (categorie_id, sous_categories_id) VALUES (11, 18);

