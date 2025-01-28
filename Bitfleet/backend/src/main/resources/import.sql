INSERT INTO admiral (id, username, password, email, funds) VALUES (0, 'John Doe', '123', 'john@mail.com', 10);
INSERT INTO admiral (id, username, password, email, funds) VALUES (1, 'Jane Doe', '321', 'jane@mail.com', 10);

INSERT INTO fleet (id, name, admiral_id, is_active, is_reserve) VALUES (0, 'aa_fleet_1', 0, true, true);
INSERT INTO fleet (id, name, admiral_id, is_active, is_reserve) VALUES (1, 'bb_fleet_1', 1, true, true);
INSERT INTO fleet (id, name, admiral_id, is_active, is_reserve) VALUES (2, 'aa_fleet_2', 0, true, true);
INSERT INTO fleet (id, name, admiral_id, is_active, is_reserve) VALUES (3, 'bb_fleet_2', 1, true, true);
INSERT INTO fleet (id, name, admiral_id, is_active, is_reserve) VALUES (4, 'aa_fleet_3', 0, true, true);

INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (0, 'aa_ship_1', 'CAPITAL', 100, 30, 20, 10, 50, 0.5, false, false, 150, 0, 0);
INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (1, 'aa_ship_2', 'SCREEN', 80, 25, 15, 5, 40, 0.4, false, false, 80, 0, 0);

INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (2, 'bb_ship_1', 'CAPITAL', 110, 35, 25, 15, 55, 0.6, false, false, 170, 1, 1);
INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (3, 'bb_ship_2', 'SCREEN', 90, 20, 10, 5, 45, 0.3, false, false, 90, 1, 1);

INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (4, 'aa_ship_3', 'CAPITAL', 120, 40, 30, 20, 60, 0.7, false, false, 200, 0, 2);
INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (5, 'aa_ship_4', 'SCREEN', 85, 20, 20, 10, 50, 0.6, false, false, 100, 0, 2);

INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (6, 'bb_ship_3', 'CAPITAL', 115, 32, 28, 18, 52, 0.5, false, false, 160, 1, 3);
INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (7, 'bb_ship_4', 'SCREEN', 75, 15, 15, 10, 40, 0.4, false, false, 85, 1, 3);

INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (8, 'aa_ship_5', 'CAPITAL', 130, 45, 35, 25, 70, 0.8, false, false, 250, 0, 4);
INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (9, 'aa_ship_6', 'SCREEN', 95, 25, 20, 15, 55, 0.5, false, false, 120, 0, 4);
