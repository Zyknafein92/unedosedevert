INSERT INTO public.t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.t_roles (name) VALUES ('ROLE_USER');


INSERT INTO public.t_user (id, active, anniversaire, email, genre, nom, password, prenom, telephone, panier_id) VALUES (1, null, '2022-07-02', 'admin@gmail.com', 'Monsieur', 'testN', '$2a$10$3ZgfaLwo0Wl5f74MZ7IGtuzjUV8/v3NgbUDx0VaXZBWPVR9.8ZZ6y', 'testP', '0000000000', null);
SELECT setval('t_user_id_seq', 2, true);

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);



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
SELECT setval('t_categorie_id_seq', 7, true);

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
SELECT setval('t_sous_categorie_id_seq', 6, true);
