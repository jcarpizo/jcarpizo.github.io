Install LAMP in one command
===========================

A few complex packages but all (bar linux!) can be installed with one command and then following the on-screen instructions:

.. code-block:: console

    sudo apt-get install lamp-server^

==================
Install phpMyAdmin
==================

To get started, we can simply install phpMyAdmin from the default Ubuntu repositories.

.. code-block:: console

    sudo apt-get update

    sudo apt-get install phpmyadmin php-mbstring php-gettext


The only thing we need to do is explicitly enable the PHP mcrypt and mbstring extensions, which we can do by typing:

.. code-block:: console

    sudo phpenmod mcrypt

    sudo phpenmod mbstring

    sudo service apache2 restart

.. hint::

   You can now access the web interface by visiting your server's domain name or public IP address followed by /phpmyadmin

Re-configure phpMyadmin
-----------------------

.. code-block:: console

    sudo dpkg-reconfigure phpmyadmin

===============================
Secure your phpMyAdmin Instance
===============================

Configure Apache to Allow .htaccess Overrides
---------------------------------------------

We will edit the linked file that has been placed in our Apache configuration directory:

.. code-block:: console

    sudo subl /etc/apache2/conf-available/phpmyadmin.conf


We need to add an ``AllowOverride All`` directive within the ``<Directory /usr/share/phpmyadmin>`` section of the configuration file, like this: ::

    <Directory /usr/share/phpmyadmin>
        Options FollowSymLinks
        DirectoryIndex index.php
        AllowOverride All
    </Directory>

When you have added this line, save and close the file.

To implement the changes you made, restart Apache:

.. code-block:: console

    sudo service apache2 restart

Create an .htaccess file
------------------------

Now that we have enabled .htaccess use for our application, we need to create one to actually implement some security.

In order for this to be successful, the file must be created within the application directory. We can create the necessary file and open it in our text editor with root privileges by typing:

.. code-block:: console

    sudo subl /usr/share/phpmyadmin/.htaccess

Within this file, we need to enter the following information: ::

    AuthType Basic
    AuthName "Restricted Files"
    AuthUserFile /etc/phpmyadmin/.htpasswd
    Require valid-user

Create the .htpasswd file for Authentication
--------------------------------------------

Now that we have specified a location for our password file through the use of the AuthUserFile directive within our .htaccess file, we need to create this file.

We actually need an additional package to complete this process. We can install it from our default repositories:

.. code-block:: console

    sudo apt-get install apache2-utils

Afterward, we will have the **htpasswd** utility available.

The location that we selected for the password file was **/etc/phpmyadmin/.htpasswd**. Let's create this file and pass it an initial user by typing:

.. code-block:: console

    sudo htpasswd -c /etc/phpmyadmin/.htpasswd username


You will be prompted to select and confirm a password for the user you are creating. Afterwards, the file is created with the hashed password that you entered.

If you want to enter an additional user, you need to do so without the -c flag, like this:

.. code-block:: console

    sudo htpasswd /etc/phpmyadmin/.htpasswd additionaluser

Enable .httaccess rewrite
-------------------------

.. code-block:: console

    sudo a2enmod rewrite

    sudo service apache2 restart

Solve phpmyadmin not found
--------------------------

Create a link in ``/var/www/html`` like this:

.. code-block:: console

    sudo ln -s /usr/share/phpmyadmin /var/www/html


.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo