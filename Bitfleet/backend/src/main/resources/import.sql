INSERT INTO admiral (id, username, password, email, funds) VALUES (0, 'aa', 'aa', 'aa', 0);
INSERT INTO fleet (id, name, admiral_id, is_active, is_reserve) VALUES (0, 'aa', 0, true, true);
INSERT INTO ship (id, name, type, hp, la, ha, ta, org, vet, is_repairing, is_sunken, value, admiral_id, fleet_id) VALUES (0, 'aa', 'CAPITAL', 1, 1, 1, 1, 1, 0.1, false, false, 1, 0, 0);