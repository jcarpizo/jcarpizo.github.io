Install MySQL on Mac OS X
=========================

1. Download the MySQL DMG for Mac OS X
2. Install MySQL

Creating aliases for mysql and mysqladmin. However there are other commands that are helpful such as mysqldump. Instead, I updated my path to include /usr/local/mysql/bin.

.. code-block:: console

    export PATH=/usr/local/mysql/bin:$PATH

.. note::

   You will need to open a new Terminal window or run the command above for your path to update.

I also run **mysql_secure_installation**. While this isn’t necessary, it’s good practice.

=====================
Connect PHP and MySQL
=====================

You need to ensure PHP and MySQL can communicate with one another.

.. code-block:: console

    cd /var
    mkdir mysql
    cd mysql
    ln -s /tmp/mysql.sock mysql.sock


.. code-block:: console

    cd /var
    sudo mkdir mysql
    sudo chmod 755 mysql
    cd mysql
    sudo ln -s /tmp/mysql.sock mysql.sock

If you have /var/mysql/mysql.sock but no /tmp/mysql.sock then


.. code-block:: console

    cd /tmp
    ln -s /var/mysql/mysql.sock mysql.sock

===================================
Additional Configuration (optional)
===================================

The default configuration for Apache 2.4 on OS X Yosemite seemed pretty lean. For example, common modules like **mod_rewrite** were disabled. You may consider enabling this now to avoid forgetting they are disabled in the future.

I edited my Apache Configuration:

.. code-block:: console

    vi /etc/apache2/httpd.conf

I uncommented the following lines (remove #):

.. code-block:: console

    LoadModule deflate_module libexec/apache2/mod_deflate.so
    LoadModule expires_module libexec/apache2/mod_expires.so
    LoadModule rewrite_module libexec/apache2/mod_rewrite.so


.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo