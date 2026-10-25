-- users
INSERT INTO app_user(name) VALUES ('admin');
INSERT INTO app_user(name) VALUES ('user');
INSERT INTO app_user(name) VALUES ('marin');

-- projects
INSERT INTO project(name) VALUES ('Test');
INSERT INTO project(name) VALUES ('Task Management API');

-- tasks
INSERT INTO task (title, project_id, assignee_id) VALUES ('Create a Hello endpoint', 2, 3);
INSERT INTO task (title, project_id, assignee_id) VALUES ('Create a Task class', 2, 3);
INSERT INTO task (title, project_id, assignee_id) VALUES ('Add the database', 2, 3);
INSERT INTO task (title, project_id, assignee_id) VALUES ('Configuration and polish', 2, 3);