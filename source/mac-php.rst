Update PHP on Mac OS X
======================

How to upgrade or install a different version of PHP on Mac OS X.

==============
Installing PHP
==============

First, choose the version of PHP you want to install. In this example, I’ll install PHP 7.1 as that is the latest stable version of PHP. However, if you want to install PHP 7.0 that is available as well.

.. code-block:: console

    curl -s http://php-osx.liip.ch/install.sh | bash -s 7.1

==================
Configuring Apache
==================

Provided you are using the pre-installed version of Apache, PHP OSX will add the /etc/apache2/other/+php-osx.conf configuration file which will automatically be loaded by Apache.

If you had previously enabled PHP (as I did), you’ll need to comment out the following line in /etc/apache2/httpd.conf:

::

    LoadModule php5_module /usr/local/php5/libphp5.so


==================
Updating your PATH
==================


Although Apache will now run the new version of PHP, the command line will not. In order for the command line to use the new version of PHP you will need to update your PATH.

.. code-block:: console

    export PATH=/usr/local/php5/bin:$PATH

If you don’t want to run the command above every time you open a new terminal, you can update the PATH in your .bash_profile.

.. code-block:: console

    vi ~/.bash_profile


===============
Configuring PHP
===============

Finally, you will want to update some of the PHP configuration values. PHP OSX installs a PHP INI file for you to change. To edit this file, run:

.. code-block:: console

    sudo vi /usr/local/php5/php.d/99-liip-developer.ini

If you kept all of your local PHP configuration within a single INI file (as I did), you can simply append it to the PHP OSX file with:

.. code-block:: console

    sudo cat /Library/Server/Web/Config/php/local.ini >> /usr/local/php5/php.d/99-liip-developer.ini

That’s it!

Now you’ll just need to review your PHP code to ensure it’s compatible with your newly installed PHP version. And for that, I recommend PHP Shift.


.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo