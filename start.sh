#!/bin/bash



DB="order"
USER="root"
PASS="123456"

mysql -uroot -prootpassword -e "CREATE DATABASE $DB CHARACTER SET utf8 COLLATE utf8_general_ci";
mysql -uroot -prootpassword -e "CREATE USER $USER@'127.0.0.1' IDENTIFIED BY '$PASS'";
mysql -uroot -prootpassword -e "GRANT SELECT, INSERT, UPDATE ON $DB.* TO '$USER'@'127.0.0.1'";