-- USER
-- hashed password: letmein
INSERT INTO security_user (username, password, first_name, last_name) VALUES
('admin', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Administrator', 'Adminstrator'),
('ayaz', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Ayaz', 'Ahmed'),
('mobile', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Mobile', 'User'),
('web', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Web', 'User');

-- ROLES

INSERT INTO security_role (role_name, description) VALUES ('ROLE_ADMIN', 'Administrator');
INSERT INTO security_role (role_name, description) VALUES ('ROLE_API_ACCESS', 'API ACCESS');

INSERT INTO user_role(user_id, role_id) VALUES
 (1, 1), -- give admin ROLE_ADMIN
 (2, 1),  -- give AYAZ ROLE_ADMIN
 (2, 2),  -- give AYAZ ROLE_API_ACCESS
 (3, 1),  -- give MOBILE ROLE_API_ACCESS
 (4, 2);  -- give WEB ROLE_API_ACCESS
