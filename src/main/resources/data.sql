INSERT INTO public.t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.t_roles (name) VALUES ('ROLE_USER');

INSERT INTO public.t_user (active, anniversaire, email, nom, password, prenom, telephone, panier_id) VALUES (null, '2020-11-16', 'deneux.j@gmail.com', 'Jérôme Deneux', '$2a$10$3ZgfaLwo0Wl5f74MZ7IGtuzjUV8/v3NgbUDx0VaXZBWPVR9.8ZZ6y', 'Jérôme', '0625092170', null);
INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO public.t_categorie (id ,name) VALUES (1, 'Fruit séchés et oléagineux');
INSERT INTO public.t_categorie (id ,name) VALUES (2,'Graines');
INSERT INTO public.t_categorie (id ,name) VALUES (3,'Légumineuses');
INSERT INTO public.t_categorie (id ,name) VALUES (4,'Riz');
INSERT INTO public.t_categorie (id ,name) VALUES (5,'Pâtes');
INSERT INTO public.t_categorie (id ,name) VALUES (6,'Céréales');
INSERT INTO public.t_categorie (id ,name) VALUES (7,'Biscuits');
INSERT INTO public.t_categorie (id ,name) VALUES (8,'Farine');
INSERT INTO public.t_categorie (id ,name) VALUES (9,'Sucre');
INSERT INTO public.t_categorie (id ,name) VALUES (10,'Aides culinaires');
INSERT INTO public.t_categorie (id ,name) VALUES (11,'Fleur de sel');
INSERT INTO public.t_categorie (id ,name) VALUES (12,'Condiments');
INSERT INTO public.t_categorie (id ,name) VALUES (13,'Epices');
INSERT INTO public.t_categorie (id ,name) VALUES (14,'Infusions');
INSERT INTO public.t_categorie (id ,name) VALUES (15,'Thé');
INSERT INTO public.t_categorie (id ,name) VALUES (16,'Café');
INSERT INTO public.t_categorie (id ,name) VALUES (17,'Savon');
INSERT INTO public.t_categorie (id ,name) VALUES (18,'Shampoing');
INSERT INTO public.t_categorie (id ,name) VALUES (19,'Masque');
INSERT INTO public.t_categorie (id ,name) VALUES (20,'Bien-être');
INSERT INTO public.t_categorie (id ,name) VALUES (21,'Linge');
INSERT INTO public.t_categorie (id ,name) VALUES (22,'Produit ménagers');
