XAMPP - Replacing MariaDB with MySQL
====================================

.. raw:: html

    As of XAMPP 5.5.30 and 5.6.14, XAMPP ships MariaDB instead of MySQL. <a href="https://mariadb.com/kb/en/mariadb/mariadb-vs-mysql-compatibility/">MariaDB is not 100% compatible with MySQL</a> and can be replaced with the “orginal” MySQL server.
    <br/> <br/>

Requirements
------------

.. raw:: html

    <ul>
        <li>Windows</li>
        <li><a href="https://www.apachefriends.org/">XAMPP</a> for Windows</li>
        <li>Administrator privileges to restart Windows services</li>
    </ul>

Backup
------

.. raw:: html

    <ul>
        <li>Backup the old database into a sql dump file</li>
        <li>Stop the MariaDB service</li>
        <li>Rename the folder: <b>c:\xampp\mysql</b> to <b>c:\xampp\mariadb</b></li>
    </ul>


Installation
------------

.. raw:: html

    <ul>
        <li>Download MySQL Community Server: <a href="https://dev.mysql.com/downloads/mysql/">https://dev.mysql.com/downloads/mysql/</a></li>
        <li>Goto: Other Downloads > ZIP Archive	5.7.22 (mysql-5.7.22-win32.zip) > <a href="https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.22-win32.zip">No thanks, just start my download</a>.</li>
        <li>Create a new and empty folder: <b>c:\xampp\mysql</b></li>
        <li>Extract <b>mysql-5.7.22-win32.zip</b> to: <b>c:\xampp\mysql</b></li>
        <li>Create a new file: <b>c:\xampp\mysql\my.ini</b> and copy this content:</li>
    </ul>


.. code-block:: console

    [mysqld]
    # Set basedir to your installation path
    basedir=c:/xampp/mysql

    # Set datadir to the location of your data directory
    datadir=c:/xampp/mysql/data

    # Default: 128 MB
    # New: 1024 MB
    innodb_buffer_pool_size = 1024M


Initializing the data directory
-------------------------------

.. raw:: html

    <ul>
        <li>Copy the old data directory from <b>c:\xampp\mariadb\data</b> to <b>c:\xampp\mysql\data</b></li>
        <li>Start the MySQL server. You can use the XAMPP Control Panel (MySQL > Start) to start the MySQL service.</li>
        <li>Repair all corrupted tables in the <b>c:\xampp\mysql\data directory</b>. Press ENTER if your password is empty.</li>
    </ul>


.. code-block:: console

    cd c:\xampp\mysql\bin

.. code-block:: console

    mysqlcheck.exe -u root -p --auto-repair --all-databases

Update structure to latest version:

.. code-block:: console

    mysql_upgrade.exe -u root -p --force


Check the tables for errors:

.. code-block:: console

    mysqlcheck.exe -u root -p --check --all-databases


.. note::

     If you don’t want to copy and migrate the old data directory, you can create a fresh directory with this command:

.. code-block:: console

    c:\xampp\mysql>bin\mysqld.exe --initialize-insecure --basedir=c:\xampp\mysql --datadir=c:\xampp\mysql\data
