INSERT INTO public.t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.t_roles (name) VALUES ('ROLE_USER');

INSERT INTO public.t_shopping_cart (id) VALUES (1);
INSERT INTO public.t_shopping_cart (id) VALUES (2);
select setval('t_shopping_cart_id_seq', 2, true);

INSERT INTO public.t_user (id, birthday, email, gender, newsletter, first_name, password, last_name, shopping_cart_id) VALUES (1, '2022-07-02', 'admin@gmail.com', 'Monsieur', null, 'testN', '$2a$10$3ZgfaLwo0Wl5f74MZ7IGtuzjUV8/v3NgbUDx0VaXZBWPVR9.8ZZ6y', 'testP', 1);
INSERT INTO public.t_user (id, birthday, email, gender, newsletter, first_name, password, last_name, shopping_cart_id) VALUES (2, '1988-07-02', 'test@gmail.com', 'Monsieur', false, 'Paul', '$2a$10$9kXDz3wiloAzoxUaylJKXOj0RHFuJGyOTb4UvdCpNxptZcdsogfIi', 'Pierre', 2);
SELECT setval('t_user_id_seq', 3, true);


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

INSERT INTO public.t_sub_categorie (id, name) VALUES (1, 'Thés verts');
INSERT INTO public.t_sub_categorie (id, name) VALUES (2, 'Thés noirs');
INSERT INTO public.t_sub_categorie (id, name) VALUES (3, 'Infusions et Rooïbos');
INSERT INTO public.t_sub_categorie (id, name) VALUES (4, 'Fleurs, herbes et aromates');
INSERT INTO public.t_sub_categorie (id, name) VALUES (5, 'Piments');
INSERT INTO public.t_sub_categorie (id, name) VALUES (6, 'Epices et condiments');
INSERT INTO public.t_sub_categorie (id, name) VALUES (7, 'Chocolats');
INSERT INTO public.t_sub_categorie (id, name) VALUES (8, 'Confiseries');
INSERT INTO public.t_sub_categorie (id, name) VALUES (9, 'Biscuits sucrés');
INSERT INTO public.t_sub_categorie (id, name) VALUES (10, 'Biscuits salés');
INSERT INTO public.t_sub_categorie (id, name) VALUES (11, 'Oléagineux');
INSERT INTO public.t_sub_categorie (id, name) VALUES (12, 'Tour d''Egypte');
INSERT INTO public.t_sub_categorie (id, name) VALUES (13, 'Saveur du Maroc');
INSERT INTO public.t_sub_categorie (id, name) VALUES (14, 'Objectif prise de masse');
INSERT INTO public.t_sub_categorie (id, name) VALUES (15, 'Objectif poids plume');
INSERT INTO public.t_sub_categorie (id, name) VALUES (16, 'Nos eaux aromatisées');
INSERT INTO public.t_sub_categorie (id, name) VALUES (17, 'Nos rhums arrangés');
INSERT INTO public.t_sub_categorie (id, name) VALUES (18, 'Boissons médiévales');
INSERT INTO public.t_sub_categorie (id, name) VALUES (19, 'Nos box sushi-makis');
INSERT INTO public.t_sub_categorie (id, name) VALUES (20, 'Nos box de nouilles');
INSERT INTO public.t_sub_categorie (id, name) VALUES (21, 'Nos box gateaux d''Asie');
INSERT INTO public.t_sub_categorie (id, name) VALUES (22, 'Pour les textiles');
INSERT INTO public.t_sub_categorie (id, name) VALUES (23, 'Pour les surfaces');
SELECT setval('t_sub_categorie_id_seq', 24, true);

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

INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (8, 19);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (8, 20);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (8, 21);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (24, 22);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (24, 23);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (1, 1);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (1, 2);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (1, 3);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (2, 4);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (2, 5);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (2, 6);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (3, 7);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (3, 8);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (3, 9);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (4, 10);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (4, 11);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (9, 12);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (9, 13);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (10, 14);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (10, 15);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (11, 16);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (11, 17);
INSERT INTO public.t_categorie_sub_categories (categorie_id, sub_categories_id) VALUES (11, 18);

INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (1, '', 'soja, huile essentielle
', 'La route des comptoirs', 'Thé vert de Chine*, menthe*, écorces de citron*, zestes de grenade*, huile essentielle de citron*, arôme naturel mangue
(soja) - *: Ingrédients issus de l''agriculture biologique
', 'Le thé vert contient de puissants antioxydants.', 'Chine (matière 1ère principale), France (transformation et assemblage)', '', '', 'La fraîcheur du thé vert au doux parfum de mangue, ravivée par une touche acidulée de citron et soulignée par une
pointe de menthe, digestive et rafraîchissante. Niveau de Théine : peu élevé', 'Thé vert - Tropical', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629384416546thé_vert_-Tropiques_300x300.jpg', '', '', 'A déguster aussi bien chaud que glacé, selon la saison.
Dosage : 3 cuillères/ L,
Temps d’infusion : 4-5 mn
Température de l’eau : 80°C', 'Nous avons choisi ce thé vert pour sa douceur et sa polyvalence (excellent en thé chaud et glacé). Le thé vert est un thé
peu transformé (juste séché, d''où sa couleur verte), qui possède un goût subtil aux notes d''herbe tondues.', 1, null, 1, 1);
INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (2, '', 'huile essentielle', 'La route des comptoirs', 'Rooibos d’Afrique du Sud* , gingembre*, huile essentielle d‘orange*, arôme naturel abricot*
 *Ingrédients issus de l''agriculture biologique.
Ingrédients issus du commerce équitable certifiés Fairtrade / Max Havelaar : Rooibos, gingembre (96,5% du poids total).', 'N/C', 'Afrique du Sud (matière 1ère principale), France (assemblage et transformation)', '', '', 'Laissez votre esprit voyager, avec ce mélange fruité et épicé, au doux parfum de fruits du verger associé au puissant
éclat du gingembre. Niveau de Théine : peu élevé
', 'Rooibos - Voyage Voyage', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629384730574Rooibos-_Voyage_voyage_300x300.jpg', '', '', 'À savourer à n''importe quelle heure grâce à son absence de théine.
Dosage : 3 cuillères/ L,
Temps d’infusion : 4-5 mn
Température de l’eau : 80°C
', 'Nos infusions et thés sont élaborés en France par un spécialiste qui sélectionne pour nous les meilleurs ingrédients et
préfère les coopératives du commerce équitable.
', 1, null, 3, 1);
INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (3, '', 'N/C', 'Le Dauphin', 'Romarin*, Thym*, Sarriette*, Origan*, Basilic* - *Produit issu de l''agriculture biologique', 'Parmi mes plantes qui rentrent dans la composition de ce mélange d''herbes de provence,on trouve des plantes
digestives, riches en antioxydants et adoucissantes.
', 'France - Drôme provençale (matière 1ère et transformation)', '', '', 'Ingrédient incontournable de la cuisine méditerranéenne, les Herbes de Provence dégagent des saveurs incomparables.
Elles sont idéales pour les grillades, les plats mijotés, les poêlées de légumes ou encore la ratatouille… ', 'Herbes de Provence Drôme', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629386186416Herbes-de-Provence-bio-40-gr.jpg', '', '', '3 cuillères a café pour un plat complet', 'Nos herbes proviennent d’une maison fondée en 1953, qui crée, assemble, fabrique et conditionne des infusions et
tisanes biologiques en Drôme provençale.
', 2, null, 4, 1);
INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (5, '', 'Ail (fabriqué dans un atelier qui utilise: sésame, blé)', 'Une dose de vert', 'Fleur de sel de Guérande, poudre de cèpes BIO, ail BIO, persil BIO', '', 'France - Île de france (fabrication) , Paraguay (matière 1ère principale)', '', '', 'Découvrez notre mélange maison, confectionné en Île-de-France: De la fleur de sel de Guérande en direct producteur, et des aromates et épices BIO cultivées traditionnellement. Notre recette est riche en saveur pour un résultat qualitatif qui vous permet de mettre moins de sel dans vos plats.
', 'Fleur de sel "Forestière" aux cèpes', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629386838226fleur-de-sel.jpg', '', '', 'Remplace le sel et les aromates: Ici, un doux parfum de champignons rappelant les sous-bois, parfait dans un risotto, une poêlée de légumes forestière ou pour donner du goût à un « tofu brouillé »…
 À utiliser de préférence en fin de cuisson, et à conserver à l''abri de la lumière et de l''humidité.
', 'Nous avons mis au point ce mélange riche en saveurs, afin de vous aider à parfumer de façon ludique des plats variés,
en leur ajoutant une petite touche ''haute couture".
', 2, null, 4, 1);
INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (7, 'Le café et le guarana sont deux ingrédients connus pour booster l''organisme', 'blé, sésame. Traces possibles de fruits à coque, sésame, moutarde.', 'Lou Bio', 'Farine de froment* T65, sucre de canne non raffiné*, huile de coco non hydrogénée*, son d''avoine*, café* 1,3%, graines
de lin brun*, sésame blond complet*, sel fin de Guérande, guarana* 0,5%, extrait de vanille*, poudre à lever : bicarbonate d''ammonium.
Traces possibles de fruits à coques et de sésame.
* Produits issus de l''agriculture biologique.
Les produits contenants des allergènes sont indiqués en gras.
Conditionné dans un atelier utilisant des produits à base de gluten, d''œufs, d''arachides, soja, fruits à coques, graines de sésame.
', 'Données nutritionnelles pour 100 g :
Valeurs énergétiques : 2031 kj
Valeurs énergétiques : 485 kcal
Matières grasses (lipides) : 22 g
Dont acides gras saturés : 17 g
Glucides : 63 g
Dont sucres : 25 g
Fibres alimentaires : 3.5 g
Protéines : 8 g
Sel : 0.56 g
', 'France - Provence (matières 1ères principales et fabrication)', '', '', 'Ces biscuits sont parfaits pour les amateurs de café!', 'Biscuits Café Guarana', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629387720145cafe-guarana.jpg', '', '', 'A grignoter lors des petites faims ou au petit déjeuner!', 'Les valeurs de l''entreprise Lou Bio et leur provenance française nous ont attiré. Et il faut avouer, on a adoré leur bon
goût de café et leur originalité! Parfait pour les matins pressés ou les encas de journées chargées!!
', 3, null, 9, 1);
INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (6, '', 'N/C', 'Maldon salt Company', 'Cristaux de sel de Maldon fumés au bois de chêne', 'N/C', 'Angleterre (comté d''Essex)', 'Les maîtres sauniers de l''estuaire du fleuve Blackwater dans l''Essex, emploient les mêmes méthodes traditionnelles
artisanales utilisées dans la ville côtière de Maldon depuis 1882.
', '', 'Le sel de Maldon est un sel de mer que l''on soumet à un délicat procédé de fumage au bois de chêne, ce qui procure
une saveur distincte, riche et raffinée à tous les plats. Il a la particularité de présenter des cristaux pyramidaux, très aériens et une texture feuilletée.
', 'Cristaux de sel Maldon fumé', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629387339342sel-malson.jpg', '', '', 'A utiliser de préférence en fin de cuisson, pour profiter du croquant de ses flocons. Peut être utilisé de façon similaire à la
fleur de sel, mais possède une texture plus légère: sur des légumes rôtis au four ou en purée, des fruits secs caramélisés.
', 'C''est un sel très original, tant par son goût que par sa texture. C''est un des rares sels à forme pyramidale, qui a
l''avantage d''être produit dans un pays voisin du nôtre, pour un impact CO2 limité.
', 2, null, 6, 1);
INSERT INTO public.t_product (id, additional_information, allergen, brand, composition, nutritional_information, origin, producer, producer_comment, product_description, title, url_picture1, url_picture2, url_picture3, utilisation_advice, why_this_product, categorie_id, reduction_id, sub_categorie_id, type_id) VALUES (4, '', 'Sésame (fabriqué dans un atelier qui utilise: blé)
', 'Une dose de vert', 'Graines de sésame torréfié*,piment ñora *, échalote*, ciboulette*, Fleur de sel - *Issus de l''agriculture biologique', 'Les graines de sésame sont riches en fer (recommandé en cas d’anémie), calcium, phosphore, magnésium.', 'France - Hauts de Seine (transformation), Paraguay (matière 1ère principale)', '', '', 'Condiment d’origine Japonaise, notre gomasio est délicatement parfumé avec des aromates:
Piment ñora (plus proche du poivron par sa saveur douce & fruité), ail et ciboulette (pour leur goût et leur vertues digestives.
Ce produit permet de baisser les quantités de sel dans vos plats.
', 'Gomasio', 'https://unedosedevertdev.s3.eu-west-3.amazonaws.com/1629387017335gomasio.jpg', '', '', 'A saupoudrer sur les salades, pâtes, riz etc.', 'Notre gomasio est assemblé par nos soins en en île de france, à partir d’ingrédients bio uniquement. Etant une petite entreprise, qui privilégie la qualité aux labels et certifications officielles, nous avons fait le choix de ne pas faire certifier ce produit. Nous utilisons de la fleur de sel de Guérande en direct producteur et des épices cultivées et récoltées de façon traditionnelle.
', 2, null, 5, 1);
SELECT setval('t_product_id_seq', 8, true);

INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (5, '50g ', 3.7, 74, null, 'DISPONIBLE', 2);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (6, '250g', 15.2, 61.2, null, 'DISPONIBLE', 2);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (7, '500g', 29.2, 58.4, null, 'DISPONIBLE', 2);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (8, '50g', 4, 80, null, 'DISPONIBLE', 3);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (9, '100g', 6.8, 68, null, 'DISPONIBLE', 3);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (10, '250g', 16, 64, null, 'DISPONIBLE', 3);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (11, '50g', 3.9, 78, null, 'DISPONIBLE', 4);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (12, '125g', 5.7, 45.6, null, 'DISPONIBLE', 4);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (13, '300g', 12, 40, null, 'DISPONIBLE', 4);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (14, '60g', 4, 7, null, 'DISPONIBLE', 5);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (15, '125g', 7, 56, null, 'DISPONIBLE', 5);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (16, '300g', 15, 50, null, 'DISPONIBLE', 5);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (17, '250g', 8, 32, null, 'STOCK_FAIBLE', 6);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (18, '150g', 4, 26.67, null, 'DISPONIBLE', 7);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (19, '300g', 7.3, 24.33, null, 'DISPONIBLE', 7);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (20, '500g', 11, 22, null, 'STOCK_FAIBLE', 7);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (3, '100g', 6.8, 68, null, 'DISPONIBLE', 1);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (1, '50g', 3.8, 76, null, 'DISPONIBLE', 1);
INSERT INTO public.t_variant (id, name, price, price_kg, reduction_price, stock, product_id) VALUES (23, '500g', 25, 75, null, 'DISPONIBLE', 1);
SELECT setval('t_variant_id_seq', 19, true);

INSERT INTO public.t_label (id, name, url_picture) VALUES (1, 'Bio(EU)', '');
INSERT INTO public.t_label (id, name, url_picture) VALUES (2, 'Made in France', '');
SELECT setval('t_label_id_seq', 3, true);

INSERT INTO public.t_product_labels (product_id, labels_id) VALUES (5, 1);
INSERT INTO public.t_product_labels (product_id, labels_id) VALUES (5, 2);
INSERT INTO public.t_product_labels (product_id, labels_id) VALUES (1, 1);

INSERT INTO public.t_tag (id, description, name) VALUES (1, 'Produit réalisé par nos soins !', 'Une dose de vert');
SELECT setval('t_tag_id_seq', 2, true);

INSERT INTO public.t_product_tags (product_id, tags_id) VALUES (5, 1);
INSERT INTO public.t_product_tags (product_id, tags_id) VALUES (1, 1);
